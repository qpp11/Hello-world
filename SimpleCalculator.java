import java.util.Scanner;

/**
 * 简单计算器
 * 支持：加减乘除、平方、立方、取模、判断奇偶、数字反转
 * 包含完善的异常处理
 */
public class SimpleCalculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int op = getIntInput("请选择功能：");
            if (op == 0) {
                System.out.println("计算器已退出，感谢使用！");
                break;
            }
            executeOperation(op);
        }
    }

    // 显示菜单
    private static void showMenu() {
        System.out.println("\n====== 多功能计算器 ======");
        System.out.println("1. 加法运算");
        System.out.println("2. 减法运算");
        System.out.println("3. 乘法运算");
        System.out.println("4. 除法运算");
        System.out.println("5. 取模运算");
        System.out.println("6. 计算平方");
        System.out.println("7. 计算立方");
        System.out.println("8. 判断奇偶");
        System.out.println("9. 数字反转");
        System.out.println("0. 退出");
        System.out.println("==========================");
    }

    // 执行运算
    private static void executeOperation(int op) {
        switch (op) {
            case 1:
                add();
                break;
            case 2:
                subtract();
                break;
            case 3:
                multiply();
                break;
            case 4:
                divide();
                break;
            case 5:
                mod();
                break;
            case 6:
                square();
                break;
            case 7:
                cube();
                break;
            case 8:
                checkOddEven();
                break;
            case 9:
                reverseNumber();
                break;
            default:
                System.out.println("无效选项！");
        }
    }

    private static void add() {
        double a = getDoubleInput("请输入第一个数：");
        double b = getDoubleInput("请输入第二个数：");
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    private static void subtract() {
        double a = getDoubleInput("请输入被减数：");
        double b = getDoubleInput("请输入减数：");
        System.out.println(a + " - " + b + " = " + (a - b));
    }

    private static void multiply() {
        double a = getDoubleInput("请输入第一个数：");
        double b = getDoubleInput("请输入第二个数：");
        System.out.println(a + " × " + b + " = " + (a * b));
    }

    private static void divide() {
        double a = getDoubleInput("请输入被除数：");
        double b = getDoubleInput("请输入除数：");
        if (b == 0) {
            System.out.println("错误：除数不能为0！");
            return;
        }
        System.out.println(a + " ÷ " + b + " = " + (a / b));
    }

    private static void mod() {
        int a = getIntInput("请输入被除数：");
        int b = getIntInput("请输入除数：");
        if (b == 0) {
            System.out.println("错误：除数不能为0！");
            return;
        }
        System.out.println(a + " % " + b + " = " + (a % b));
    }

    private static void square() {
        double num = getDoubleInput("请输入数字：");
        System.out.println(num + " 的平方 = " + (num * num));
    }

    private static void cube() {
        double num = getDoubleInput("请输入数字：");
        System.out.println(num + " 的立方 = " + (num * num * num));
    }

    private static void checkOddEven() {
        int num = getIntInput("请输入整数：");
        if (num % 2 == 0) {
            System.out.println(num + " 是偶数");
        } else {
            System.out.println(num + " 是奇数");
        }
    }

    private static void reverseNumber() {
        int num = getIntInput("请输入整数：");
        int reversed = 0;
        int temp = num;
        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        System.out.println(num + " 反转后 = " + reversed);
    }

    // 安全获取整数
    private static int getIntInput(String tip) {
        while (true) {
            System.out.print(tip);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("输入错误，请输入整数！");
            }
        }
    }
    // 安全获取小数
    private static double getDoubleInput(String tip) {
        while (true) {
            System.out.print(tip);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("输入错误，请输入数字！");
            }
        }
    }
}

