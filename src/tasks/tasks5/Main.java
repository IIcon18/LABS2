package tasks.tasks5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //#1
        System.out.println("#1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        //#2
        System.out.println("#2");
        System.out.println(memeSum(26, 39));
        System.out.println(memeSum(122, 81));
        System.out.println(memeSum(1222, 30277));
        //#3
        System.out.println("#3");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        //#4
        System.out.println("#4");

        //#5
        System.out.println("#5");

        //#6
        System.out.println("#6");

        //#7
        System.out.println("#7");

        //#8
        System.out.println("#8");

        //#9
        System.out.println("#9");

        //#10
        System.out.println("#10");

    }
    //#1
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }

        return true;
    }
    //#2
    public static int memeSum(int num1, int num2) {
        StringBuilder result = new StringBuilder();

        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);

        int maxLength = Math.max(str1.length(), str2.length());

        str1 = String.format("%0" + maxLength + "d", num1);
        str2 = String.format("%0" + maxLength + "d", num2);

        for (int i = 0; i < maxLength; i++) {
            int digit1 = Character.getNumericValue(str1.charAt(i));
            int digit2 = Character.getNumericValue(str2.charAt(i));
            int sum = digit1 + digit2;
            result.append(sum);
        }

        return Integer.parseInt(result.toString());
    }
    //#3
    public static int digitsCount(long n) {
    if (n == 0) {
        return 1;
    } else if (n < 0) {
        return digitsCount(-n);
    } else {
        if (n < 10) {
            return 1;
        } else {
            return 1 + digitsCount(n / 10);
        }
    }
}
    //#4

    //#5

    //#6

    //#7

    //#8

    //#9

    //#10

}
