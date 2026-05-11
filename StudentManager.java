import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 学生管理系统
 * 功能：添加、删除、查询、展示所有学生
 */
public class StudentManager {
    // 学生列表
    private static final List<Student> studentList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getIntInput("请输入操作选项：");
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    queryStudent();
                    break;
                case 4:
                    showAllStudents();
                    break;
                case 5:
                    System.out.println("感谢使用学生管理系统，再见！");
                    return;
                default:
                    System.out.println("输入无效，请重新选择！");
            }
        }
    }

    // 显示菜单
    private static void showMenu() {
        System.out.println("\n====== 学生管理系统 ======");
        System.out.println("1. 添加学生");
        System.out.println("2. 删除学生");
        System.out.println("3. 查询学生");
        System.out.println("4. 展示所有学生");
        System.out.println("5. 退出系统");
        System.out.println("==========================");
    }

    // 添加学生
    private static void addStudent() {
        System.out.println("\n------ 添加学生 ------");
        String id = getStringInput("请输入学生ID：");

        // 判断ID是否重复
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                System.out.println("该学生ID已存在，添加失败！");
                return;
            }
        }

        String name = getStringInput("请输入学生姓名：");
        int age = getIntInput("请输入学生年龄：");
        String className = getStringInput("请输入班级：");

        Student student = new Student(id, name, age, className);
        studentList.add(student);
        System.out.println("学生添加成功！");
    }

    // 删除学生
    private static void deleteStudent() {
        System.out.println("\n------ 删除学生 ------");
        String id = getStringInput("请输入要删除的学生ID：");
        boolean isDeleted = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                studentList.remove(i);
                isDeleted = true;
                break;
            }
        }

        if (isDeleted) {
            System.out.println("学生删除成功！");
        } else {
            System.out.println("未找到该学生，删除失败！");
        }
    }

    // 查询学生
    private static void queryStudent() {
        System.out.println("\n------ 查询学生 ------");
        String id = getStringInput("请输入要查询的学生ID：");
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                System.out.println("学生信息：" + s);
                return;
            }
        }
        System.out.println("未找到该学生！");
    }

    // 展示所有学生
    private static void showAllStudents() {
        System.out.println("\n------ 所有学生信息 ------");
        if (studentList.isEmpty()) {
            System.out.println("暂无学生数据！");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // 获取整数输入（防错误）
    private static int getIntInput(String tip) {
        while (true) {
            System.out.print(tip);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("输入格式错误，请输入数字！");
            }
        }
    }

    // 获取字符串输入
    private static String getStringInput(String tip) {
        System.out.print(tip);
        return scanner.nextLine().trim();
    }
}

// 学生实体类
class Student {
    private String id;
    private String name;
    private int age;
    private String className;

    public Student(String id, String name, int age, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "学生{" +
                "学号='" + id + '\'' +
                ", 姓名='" + name + '\'' +
                ", 年龄=" + age +
                ", 班级='" + className + '\'' +
                '}';
    }
}
