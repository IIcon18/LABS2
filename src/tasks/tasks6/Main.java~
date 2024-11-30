package tasks.tasks6;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        //#1
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
        System.out.println("#3");
//        System.out.println(nicoCipher("myworldevolvesinhers", "tesh")); // "yowmledrovlvsnieesrh"
//        System.out.println(nicoCipher("andiloveherso", "tesha"));
//        System.out.println(nicoCipher("mubashirhassan", "crazy"));
//        System.out.println(nicoCipher("edabitisamazing", "matt")); // "deabtiismaaznig "
//        System.out.println(nicoCipher("iloveher", "612345"));
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
        System.out.println(formula("6 * 4 = 24")); // true
        System.out.println(formula("18 / 17 = 2")); // false
        System.out.println(formula("16 * 10 = 160 = 14 + 120")); // false
        //#9
        System.out.println("#9");
        //#10
        System.out.println("#10");
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
}
