package tasks.tasks6;

import java.util.*;

import static java.lang.System.*;


public class Main {
    public static void main(String[] args) {
        //#1
        out.println("#1");
        out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        //#2
        out.println("#2");
        out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));
        out.println(stripUrlParams("https://edabit.com", new String[]{"b"}));
        out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", null));
        //#3
        out.println("#3");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh")); // "yowmledrovlvsnieesrh"
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt")); // "deabtiismaaznig "
        System.out.println(nicoCipher("iloveher", "612345"));
        //#4
        out.println("#4");
        //#5
        out.println("#5");
        //#6
        out.println("#6");
        //#7
        out.println("#7");
        //#8
        out.println("#8");
        out.println(formula("6 * 4 = 24"));
        out.println(formula("18 / 17 = 2"));
        out.println(formula("16 * 10 = 160 = 14 + 120"));
        //#9
        out.println("#9");
        //#10
        out.println("#10");
        out.println(palindromeDescendant(11211230));
        out.println(palindromeDescendant(13001120));
        out.println(palindromeDescendant(23336014));
        out.println(palindromeDescendant(11));
        out.println(palindromeDescendant(1234));
        out.println(palindromeDescendant(15984245));
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

        // Создание числового ключа на основе сортировки символов
        Character[] keyChars = new Character[keyLength];
        for (int i = 0; i < keyLength; i++) {
            keyChars[i] = key.charAt(i);
        }
        // Сортировка ключа и сохранение индексов
        Integer[] order = new Integer[keyLength];
        for (int i = 0; i < keyLength; i++) {
            order[i] = i;
        }
        Arrays.sort(order, Comparator.comparingInt(o -> keyChars[o]));

        // Заполнение сообщения до кратности длины ключа
        int rows = (int) Math.ceil((double) messageLength / keyLength);
        char[][] matrix = new char[rows][keyLength];
        Arrays.fill(matrix[rows - 1], ' ');  // Заполнение пробелами последней строки

        // Заполнение матрицы символами сообщения
        for (int i = 0; i < messageLength; i++) {
            matrix[i / keyLength][i % keyLength] = message.charAt(i);
        }

        // Создание закодированного сообщения
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int col : order) {
                encodedMessage.append(matrix[i][col]);
            }
        }

        return encodedMessage.toString();
    }
    //#4

    //#5

    //#6

    //#7

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
