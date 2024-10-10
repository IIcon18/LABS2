package tasks.tasks3;

public class Main {
    public static void main(String[] args) {
        //#1
        System.out.println(isStrangerPair("sparking", "groups"));
        System.out.println(isStrangerPair("bush", "hubris"));
        System.out.println(isStrangerPair("", ""));
        //#2

        //#3

        //#4

        //#5

        //#6

        //#7

        //#8

        //#9

        //#10
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

    //#3

    //#4

    //#5

    //#6

    //#7

    //#8

    //#9

    //#10
}
