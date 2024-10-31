package tasks.tasks4;
import java.util.*;

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
        System.out.println("#3");
        System.out.println(encode(new int[] {0, 31, 28, 10, 29}, "MKIIT"));
        System.out.println(Arrays.toString(decode("MTUCI", "MKIIT")));
        //#4
        System.out.println("#4");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));
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
        System.out.println(labirint(new int[][]{{1, 3, 1}, {1, -1, 1}, {4, 2, 1}}));
        System.out.println(labirint(new int[][]{{2, -7, 3}, {-4, -1, 8}, {4, 5, 9}}));
        //#9
        System.out.println("#9");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng") );
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        //#10
        System.out.println("#10");
        System.out.println(fibString("CCCABDD"));
        System.out.println(fibString("ABC"));
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
    public static String encode(int[] numbers, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length ; i++) {
            result.append((char) (numbers[i] ^ key.charAt(i % key.length())));
        }
        return result.toString();
    }

    public static int[] decode(String encoded, String key) {
        int[] result = new int[encoded.length()];
        for (int i = 0; i < encoded.length(); i++) {
            result[i] = encoded.charAt(i) ^ key.charAt(i % key.length());
        }
        return result;
    }
    //#4
    public static List<String> split(String str) {
        List<String> result = new ArrayList<>();
        int balace = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);
            if (c == '(') {
                balace++;
            } else if (c == ')') {
                balace--;
            }
            if (balace == 0) {
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        return result;
    }
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
    public static List<String> labirint(int[][] matrix) {
        StringBuilder path = new StringBuilder();
        int cost = findPath(matrix, 0, 0, path, 0);
        if (cost == Integer.MAX_VALUE) {
            return Collections.singletonList("Прохода нет");
        }
        path.deleteCharAt(path.length() - 1);
        return Arrays.asList(path.toString(), String.valueOf(cost));
    }

    private static int findPath(int[][] matrix, int x, int y, StringBuilder path, int cost) {
        int n = matrix.length;
        if (x >= n || y >= n ||  matrix[x][y] < 0) {
            return Integer.MAX_VALUE;
        }
        if (x == n - 1 && y == n - 1) {
            path.append(matrix[x][y]).append("-");
            return cost + matrix[x][y];
        }
        int temp = matrix[x][y];
        matrix[x][y] = -1;
        StringBuilder downPath = new StringBuilder(path);
        StringBuilder rightPath = new StringBuilder(path);
        int downCost = findPath(matrix, x + 1, y, downPath, cost + temp);
        int rightCost = findPath(matrix, x, y + 1, rightPath, cost + temp);
        matrix[x][y] = temp;
        if (downCost < rightCost) {
            path.setLength(0);
            path.append(downPath).append(temp).append("-");
            return downCost;
        } else {
            path.setLength(0);
            path.append(rightPath).append(temp).append("-");
            return rightCost;
        }
    }
    //#9
    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        String[] orderWords = new String[words.length];
        for (String word : words) {
            int num = Integer.parseInt(word.replaceAll("\\D", ""));
            orderWords[num - 1] = word.replaceAll("\\d", "");
        }
        return String.join(" ", orderWords);
    }
    //#10
    public static boolean fibString(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts);
        if (counts.size() < 3)
            return false;
        int fib1 = counts.get(0);
        int fib2 = counts.get(1);

        for (int i = 2; i < counts.size(); i++) {
            int fibNext = fib1 + fib2;
            if (counts.get(i) != fibNext) {
                return false;
            }
            fib1 = fib2;
            fib2 = fibNext;
        }
        return true;
    }
}
