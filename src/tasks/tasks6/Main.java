package tasks.tasks6;

import java.util.*;
import static java.lang.System.*;
import java.math.BigInteger;


public class Main {
    public static void main(String[] args) {
        //#1.
        System.out.println("#1");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        //#2
        System.out.println("#2");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));
        System.out.println(stripUrlParams("https://edabit.com", new String[]{"b"}));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", null));

        //#3
        out.println("#3");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        //#4
        out.println("#4");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15, 3}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));

        //#5
        System.out.println("#5");
        System.out.println(Arrays.toString(isExact(6)));        // [6, 3]
        System.out.println(Arrays.toString(isExact(24)));       // [24, 4]
        System.out.println(Arrays.toString(isExact(125)));      // []
        System.out.println(Arrays.toString(isExact(720)));      // [720, 6]
        System.out.println(Arrays.toString(isExact(1024)));     // []
        System.out.println(Arrays.toString(isExact(40320)));    // [40320, 8]

        //#6
        System.out.println("#6");
        System.out.println(fractions("0.(6)"));           // 2/3
        System.out.println(fractions("1.(1)"));           // 10/9
        System.out.println(fractions("3.(142857)"));      // 22/7
        System.out.println(fractions("0.19(2367)"));      // 5343/27775
        System.out.println(fractions("0.1097(3)"));       // 823/7500

        //#7
        System.out.println("#7");
        System.out.println(pilishString("33314444"));  // ➞ "333 1 4444"
        System.out.println(pilishString("TOP"));       // ➞ "TOP"
        System.out.println(pilishString("X"));         // ➞ "XXX"
        System.out.println(pilishString(""));          // ➞ ""
        System.out.println(pilishString("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSA" +
                "NDALLTHESECRETSOFTHEUNIVERSE"));// ➞ "HOW I NEED A DRINK ALCOHOLIC IN NATURE AFTER THE HEAVY LECTURES INVOLVING QUANTUM MECHANICS"
       
        //#8
        System.out.println("#8");
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));

        //#9
        out.println("#9");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(isValid("abc"));
        System.out.println(isValid("abcc"));

        //#10
        System.out.println("#10");
        System.out.println(palindromeDescendant(11211230));
        System.out.println(palindromeDescendant(13001120));
        System.out.println(palindromeDescendant(23336014));
        System.out.println(palindromeDescendant(11));
        System.out.println(palindromeDescendant(1234));
        System.out.println(palindromeDescendant(15984245));
    }

    //#1
    public static String hiddenAnagram(String sentence, String anagram) {
        sentence = sentence.toLowerCase().replaceAll("[^a-z]", "");
        anagram = anagram.toLowerCase().replaceAll("[^a-z]", "");

        Map<Character, Integer> anagramMap = new HashMap<>();
        for (char c : anagram.toCharArray()) {
            anagramMap.put(c, anagramMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= sentence.length() - anagram.length(); i++) {
            Map<Character, Integer> tempMap = new HashMap<>(anagramMap);
            boolean found = true;
            for (int j = i; j < i + anagram.length(); j++) {
                char c = sentence.charAt(j);
                if (!tempMap.containsKey(c) || tempMap.get(c) == 0) {
                    found = false;
                    break;
                }
                tempMap.put(c, tempMap.get(c) - 1);
            }
            if (found) {
                return sentence.substring(i, i + anagram.length());
            }
        }
        return "noutfond";
    }

    //#2
    public static String stripUrlParams(String url) {
        return stripUrlParams(url, null);
    }

    public static String stripUrlParams(String url, String[] paramsToRemove) {
        if (!url.contains("?")) {
            return url;
        }

        String[] parts = url.split("\\?");
        String baseUrl = parts[0];
        String queryString = parts[1];
        String processedQueryString = processQueryString(queryString, paramsToRemove, new HashMap<>());

        StringBuilder result = new StringBuilder(baseUrl);
        if (!processedQueryString.isEmpty()) {
            result.append("?");
            result.append(processedQueryString);
        }

        return result.toString();
    }

    private static String processQueryString(String queryString, String[] paramsToRemove, Map<String, String> paramMap) {
        String[] params = queryString.split("&");

        String[] keyValue = params[0].split("=");
        String key = keyValue[0];
        String value = keyValue.length > 1 ? keyValue[1] : "";

        if (paramsToRemove == null || !Arrays.asList(paramsToRemove).contains(key)) {
            paramMap.put(key, value);
        }

        if (params.length > 1) {
            return processQueryString(String.join("&", Arrays.copyOfRange(params, 1, params.length)), paramsToRemove, paramMap);
        } else {
            List<String> remainingParams = new ArrayList<>();
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                remainingParams.add(entry.getKey() + "=" + entry.getValue());
            }
            Collections.sort(remainingParams);
            return String.join("&", remainingParams);
        }
    }

    //#3
    public static String nicoCipher(String message, String key) {
        int keyLength = key.length();
        int messageLength = message.length();

        Character[] keyChars = new Character[keyLength];
        for (int i = 0; i < keyLength; i++) {
            keyChars[i] = key.charAt(i);
        }
        Integer[] order = new Integer[keyLength];
        for (int i = 0; i < keyLength; i++) {
            order[i] = i;
        }
        Arrays.sort(order, Comparator.comparingInt(o -> keyChars[o]));

        int rows = (int) Math.ceil((double) messageLength / keyLength);
        char[][] matrix = new char[rows][keyLength];
        Arrays.fill(matrix[rows - 1], ' ');

        for (int i = 0; i < messageLength; i++) {
            matrix[i / keyLength][i % keyLength] = message.charAt(i);
        }

        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int col : order) {
                encodedMessage.append(matrix[i][col]);
            }
        }

        return encodedMessage.toString();
    }

    //#4
    public static int[] twoProduct(int[] arr, int n) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] * arr[j] == n) {
                    return new int[]{arr[j], arr[i]};
                }
            }
        }
        return new int[]{};
    }

    //#5
    public static int[] isExact(int number) {
        return checkFactorial(number, 1, 1);
    }

    private static int[] checkFactorial(int number, int n, int factorial) {
        if (factorial == number) {
            return new int[]{number, n};  // Если факториал совпадает с числом
        } else if (factorial > number) {
            return new int[]{};  // Если текущий факториал превысил число
        } else {
            return checkFactorial(number, n + 1, factorial * (n + 1));  // Рекурсивный вызов с увеличением n
        }
    }

    //#6
    public static String fractions(String decimal) {
        if (!decimal.contains("(")) return decimal;

        String[] parts = decimal.split("\\.");
        String nonRepeating = "";
        String repeating = "";

        if (parts[1].contains("(")) {
            String beforeParentheses = parts[1].split("\\(")[0];
            repeating = parts[1].split("\\(")[1].replace(")", "");
            nonRepeating = beforeParentheses;
        }

        int lenNonRepeat = nonRepeating.length();
        int lenRepeat = repeating.length();

        long numerator = Long.parseLong(nonRepeating + repeating) - (nonRepeating.isEmpty() ? 0 : Long.parseLong(nonRepeating));
        long denominator = (long) (Math.pow(10, lenNonRepeat + lenRepeat) - Math.pow(10, lenNonRepeat));
        long gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).longValue();
        numerator /= gcd;
        denominator /= gcd;

        return numerator + "/" + denominator;
    }

    //#7
    public static String pilishString(String txt) {
        if (txt.isEmpty()) return "";

        int[] piDigits = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};
        StringBuilder result = new StringBuilder();
        int txtIndex = 0;

        for (int piDigit : piDigits) {
            if (txtIndex >= txt.length()) break;

            int end = txtIndex + piDigit;
            if (end > txt.length()) {
                end = txt.length();
                String word = txt.substring(txtIndex, end);
                char lastChar = word.charAt(word.length() - 1);
                while (word.length() < piDigit) {
                    word += lastChar;
                }
                result.append(word).append(" ");
                break;
            }

            result.append(txt.substring(txtIndex, end)).append(" ");
            txtIndex = end;
        }

        return result.toString().trim();
    }

    //#8
    public static boolean formula(String formula) {
        formula = formula.replaceAll("\\s+", "");
        String[] expressions = formula.split("=");

        List<Integer> results = new ArrayList<>();
        for (String expr : expressions) {
            try {
                int result = evaluateExpression(expr);
                results.add(result);
            } catch (Exception e) {
                return false;
            }
        }

        for (int i = 1; i < results.size(); i++) {
            if (!results.get(i).equals(results.get(0))) {
                return false;
            }
        }
        return true;
    }

    private static int evaluateExpression(String expression) {
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    result /= operand;
                    break;
                default:
                    throw new IllegalArgumentException("Неподдерживаемый оператор: " + operator);
            }
        }
        return result;
    }

    //#9
    public static String isValid(String str) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for (int freq : charCount.values()) {
            frequencyCount.put(freq, frequencyCount.getOrDefault(freq, 0) + 1);
        }

        if (frequencyCount.size() == 1) {
            return "YES";
        }

        if (frequencyCount.size() == 2) {
            List<Integer> keys = new ArrayList<>(frequencyCount.keySet());
            int freq1 = keys.get(0);
            int freq2 = keys.get(1);

            if ((frequencyCount.get(freq1) == 1 && (freq1 - 1 == freq2 || freq1 - 1 == 0)) ||
                    (frequencyCount.get(freq2) == 1 && (freq2 - 1 == freq1 || freq2 - 1 == 0))) {
                return "YES";
            }
        }
        return "NO";
    }

    //#10
    public static boolean palindromeDescendant(int num) {
        String numberStr = String.valueOf(num);

        while (numberStr.length() > 1) {
            if (isPalindrome(numberStr)) {
                return true;
            }

            if (numberStr.length() % 2 != 0) {
                return false;
            }
            numberStr = createDescendant(numberStr);
        }

        return false;
    }

    private static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static String createDescendant(String str) {
        StringBuilder descendant = new StringBuilder();

        for (int i = 0; i < str.length(); i += 2) {
            int sum = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(i + 1));
            descendant.append(sum);
        }

        return descendant.toString();
    }
}
