package tasks.tasks3;

public class Main {
    public static void main(String[] args) {
        //#1
        System.out.println("#1");
        System.out.println(isStrangerPair("sparking", "groups"));
        System.out.println(isStrangerPair("bush", "hubris"));
        System.out.println(isStrangerPair("", ""));
        //#2
        System.out.println("#2");

        //#3
        System.out.println("#3");
        System.out.println(successShoot(0, 0, 5, 2, 2));
        System.out.println(successShoot(-2, -3, 4, 5, -6));
        //#4
        System.out.println("#4");
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));
        //#5
        System.out.println("#5");
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));
        //#6
        System.out.println("#6");
        System.out.println(bagger(39));
        System.out.println(bagger(999));
        System.out.println(bagger(4));
        //#7
        System.out.println("#7");

        //#8
        System.out.println("#8");

        //#9
        System.out.println("#9");

        //#10
        System.out.println("#10");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }
    //#1
    public static boolean isStrangerPair(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }
        boolean firstCondidtion = s1.charAt(0) == s2.charAt(s2.length() - 1);
        boolean secondCondidtion = s1.charAt(s1.length() - 1) == s2.charAt(0);
        return firstCondidtion && secondCondidtion;
    }
    //#2
    public static boolean doesBrickFit(int a, int b, int c, int d, int e) {
        if (a + b + c + d > e) {
            return true;
        }
        return false;
    }
    //#3
    public static boolean successShoot(int x, int y, int r, int m, int n) {
        int radiusSquared = r * r;
        int distanceSquared = (m - x) * (m - x) + (n - y) * (n - y);
        return distanceSquared <= radiusSquared;
    }
    //#4
    public static boolean parityAnalysis(int num) {
        boolean isNumEven = (num % 2 == 0);
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        boolean isSumEven = (sum % 2 == 0);
        return isSumEven == isNumEven;
    }
    //#5
    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Ничья";
        }
        switch (player1) {
            case "rock":
                return player2.equals("scissors") ? "Игрок 1 выигрывает" : "Игрок 2 выигрывает";
            case "paper":
                return player2.equals("rock") ? "Игрок 1 выигрывает" : "Игрок 2 выигрывает";
            case "scissors":
                return player2.equals("paper") ? "Игрок 1 выигрывает" : "Игрок 2 выигрывает";
            default:
                return "Некорректный ввод";
        }
    }
    //#6
    public static int bagger(int num) {
        int count = 0;
        while (num >= 10) {
            int composition = 1;
            int temp = num;
            while (temp > 0) {
                composition *= temp % 10;
                temp /= 10;
            }
            num = composition;
            count++;
        }
        return count;
    }
    //#7

    //#8

    //#9
    //сделать
    //#10
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) || (a <= w && c <= h) || (a <= h && c <= w) ||  (b <= w && c <= h) || (b <= h && c <= w);
    }
}
