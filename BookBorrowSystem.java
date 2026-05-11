import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 图书借阅系统
 * 功能：添加图书、借阅图书、归还图书、查询图书、展示所有图书
 */
public class BookBorrowSystem {
    private static final List<Book> bookList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            int choice = getIntInput("请输入操作：");
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    showAllBooks();
                    break;
                case 6:
                    System.out.println("欢迎再次使用图书系统！");
                    return;
                default:
                    System.out.println("输入错误，请重试！");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n====== 图书借阅管理系统 ======");
        System.out.println("1. 添加新图书");
        System.out.println("2. 借阅图书");
        System.out.println("3. 归还图书");
        System.out.println("4. 查询图书");
        System.out.println("5. 查看所有图书");
        System.out.println("6. 退出系统");
        System.out.println("==============================");
    }

    // 添加图书
    private static void addBook() {
        System.out.println("\n------ 添加图书 ------");
        String id = getStringInput("图书编号：");
        for (Book b : bookList) {
            if (b.getId().equals(id)) {
                System.out.println("图书编号已存在！");
                return;
            }
        }
        String name = getStringInput("图书名称：");
        String author = getStringInput("作者：");
        Book book = new Book(id, name, author, true);
        bookList.add(book);
        System.out.println("图书添加成功！");
    }

    // 借阅图书
    private static void borrowBook() {
        System.out.println("\n------ 借阅图书 ------");
        String id = getStringInput("请输入图书编号：");
        for (Book b : bookList) {
            if (b.getId().equals(id)) {
                if (!b.isAvailable()) {
                    System.out.println("该书已被借出！");
                    return;
                }
                b.setAvailable(false);
                System.out.println("借阅成功！请按时归还。");
                return;
            }
        }
        System.out.println("未找到该图书！");
    }

    // 归还图书
    private static void returnBook() {
        System.out.println("\n------ 归还图书 ------");
        String id = getStringInput("请输入图书编号：");
        for (Book b : bookList) {
            if (b.getId().equals(id)) {
                if (b.isAvailable()) {
                    System.out.println("该书未被借出，无需归还！");
                    return;
                }
                b.setAvailable(true);
                System.out.println("图书归还成功！");
                return;
            }
        }
        System.out.println("未找到该图书！");
    }

    // 查询图书
    private static void searchBook() {
        System.out.println("\n------ 查询图书 ------");
        String keyword = getStringInput("请输入图书名称或编号：");
        boolean found = false;
        for (Book b : bookList) {
            if (b.getId().contains(keyword) || b.getName().contains(keyword)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("未找到匹配图书！");
        }
    }

    // 展示所有图书
    private static void showAllBooks() {
        System.out.println("\n------ 图书列表 ------");
        if (bookList.isEmpty()) {
            System.out.println("暂无图书！");
            return;
        }
        for (Book b : bookList) {
            System.out.println(b);
        }
    }

    private static int getIntInput(String tip) {
        while (true) {
            System.out.print(tip);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("请输入有效数字！");
            }
        }
    }

    private static String getStringInput(String tip) {
        System.out.print(tip);
        return scanner.nextLine().trim();
    }
}

// 图书类
class Book {
    private String id;
    private String name;
    private String author;
    private boolean isAvailable;

    public Book(String id, String name, String author, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "图书{" +
                "编号='" + id + '\'' +
                ", 书名='" + name + '\'' +
                ", 作者='" + author + '\'' +
                ", 状态=" + (isAvailable ? "可借阅" : "已借出") +
                '}';
    }
}