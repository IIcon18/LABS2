package tasks.tasks4;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //#1
        System.out.println("#1");
        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));
        //#2
        System.out.println("#2");
        System.out.println(bruteForce(1, 5));
        System.out.println(bruteForce(2, 2));
        System.out.println(bruteForce(5, 3));
        //#3
        /*
        System.out.println("#3");
        System.out.println(encode(new int[]{3, 12, 7, 81, 52}, "MKIIT"));
        System.out.println(decode("MTUCI","MKIIT"));
        */
        //#4
        System.out.println("#4");

        //#5
        System.out.println("#5");
        System.out.println(shortHand("abbccc")); // "ab*2c*3"
        System.out.println(shortHand("vvvvaajaaaaa")); // "v*4a*2ja*5"
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
    public static String nonRepeat(String str) {
        return nonRepeatHelper(str, new HashMap<Character, Integer>());
    }
    private static String nonRepeatHelper(String str, HashMap<Character, Integer> charCount) {
        if (str.isEmpty()) {
            return "";
        }
        char firstChar = Character.toLowerCase(str.charAt(0));
        charCount.put(firstChar, charCount.getOrDefault(firstChar, 0) + 1);
        String result = nonRepeatHelper(str.substring(1), charCount);
        if (charCount.get(firstChar) > 3) {
            return result;
        } else {
            return firstChar + result;
        }
    }
    //#2
    public static ArrayList<String> bruteForce(int n, int k) {
        if (n > k) {
            return new ArrayList<>();
        }
        ArrayList<String> combinations = new ArrayList<>();
        generateCombinations("", n, k, combinations);
        return combinations;
    }
    private static void generateCombinations(String current, int n, int k, ArrayList<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        for (int i = 0; i < k; i++) {
            char c = (char) ('0' + i);
            if (current.indexOf(c) == -1) {
                generateCombinations(current + c, n, k, result);
            }
        }
    }
    //#3
    /*
    public static String encode(int[] numbers, String key) {
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            char encodedChar = (char) (numbers[i] ^ key.charAt(i % key.length()));
            encodedMessage.append(encodedChar);
        }
        return encodedMessage.toString();
    }

    public static int[] decode(String message, String key) {
        int[] decodedNumbers = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            decodedNumbers[i] = message.charAt(i) ^ key.charAt(i % key.length());
        }
        return decodedNumbers;
    }
    */
    //#4

    //#5
    public static String shortHand(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(currentChar);
                if (count > 1) {
                    result.append('*').append(count);
                }
                currentChar = input.charAt(i);
                count = 1;
            }
        }

        result.append(currentChar);
        if (count > 1) {
            result.append('*').append(count);
        }

        return result.toString();
    }
    //#6

    //#7

    //#8

    //#9

    //#10

    
}
