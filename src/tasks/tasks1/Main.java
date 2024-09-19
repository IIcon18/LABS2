package tasks.tasks1;

public class Main {
    public static void main(String[] args) {
        //#1

        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        //#2
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        //#3
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        //#4
        System.out.println(triangleType(5,5,5));
        System.out.println(triangleType(5,4,5));
        System.out.println(triangleType(3,4,5));
        System.out.println(triangleType(5,1,1));
        //#5
        System.out.println(ternaryEvalution(8, 4));
        System.out.println(ternaryEvalution(1, 11));
        System.out.println(ternaryEvalution(5, 9));
        //#6
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        //#7
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        //#8
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        //#9
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24,950));
        System.out.println(ticketSaler(53,1250));
        //#10
        System.out.println(tables(5,2));
        System.out.println(tables(31,20));
        System.out.println(tables(123, 58));
    }

    //#1
    public static double convert(int n) {
        return n * 3.785;
    }

    //#2
    public static int fitCalc(int m, int l) {
        return m * l;
    }

    //#3
    public static int containers(int a, int b, int c) {
        return a * 20 + b * 50 + c * 100;
    }

    //#4

    public static String triangleType(int x, int y, int z) {
        if (x + y > z && x + z > y && y + z > x) {
            if (x == y && y == z) {
                return "isosceles";
            }
            else if (x == y || x == z || y == z) {
                return "equilateral";
            }
            else {
                return "different-sided";
            }
        } else {
            return "not a triangle";
        }
    }

    //#5
    public static int ternaryEvalution(int a, int b) {
        return (a > b) ? a : b;
    }

    //#6
    public static int howManyItems(double f, double w, double h) {
        double area = w * h;

        int num = (int) (f / area);

        return num;
    }

    //#7
    public static int factorial(int g) {
        int r = 1;
        for (int i = 1; i <= g; i++ ) {
            r *= i;
        }

        return r;
    }

    //#8
    public static int gcd(int f, int s) {
        while (s != 0) {
            int temp = s;
            s = f % s;
            f = temp;
        }
        return f;
    }

    //#9
    public static int ticketSaler(int tickets, int cost) {
        return (int) ((tickets * cost) * 0.72);
    }

    //#10
    public static int tables(int s, int t) {
        int temp = (s + 1) / 2;

        if (temp <= t) {
            return 0;
        } else {
            return temp - t;
        }
    }
}