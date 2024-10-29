package tasks.tasks4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));
        //#6
        System.out.println("#6");
        System.out.println(convertToRome(8));
        System.out.println(convertToRome(1234));
        System.out.println(convertToRome(52));
        //#7
        System.out.println("#7");
        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("12223234333"));
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
    public static String convertToRome(int num) {
        if (num < 1 || num > 1502) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 1502");
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }
    //#7
    public static String uniqueSubstring(String input) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        HashMap<Character, Integer> firstIndex = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            if (!firstIndex.containsKey(c)) {
                firstIndex.put(c, i);
            }
        }

        int maxCount = 0;
        for (int count : charCount.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        int firstMaxIndex = -1;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                int index = firstIndex.get(entry.getKey());
                if (firstMaxIndex == -1 || index < firstMaxIndex) {
                    firstMaxIndex = index;
                }
            }
        }

        if (firstMaxIndex % 2 == 0) {
            return "чет";
        } else {
            return "нечет";
        }
    }
    //#8

    //#9

    //#10

    
}
