package tasks.tasks5;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {
    public static void main(String[] args) throws ParseException {
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
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        //#5
        System.out.println("#5");
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9}));
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15}));
        System.out.println(longestRun(new int[]{5, 4, 2, 1}));
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15}));
        //#6
        System.out.println("#6");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
        //#7
        System.out.println("#7");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));
        //#8
        System.out.println("#8");
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));
        //#9
        System.out.println("#9");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        //#10
        System.out.println("#10");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
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
    public static int totalPoints(String[] guessedWords, String scrambledWord) {
        int totalPoints = 0;
        Map<Character, Integer> letterCount = getLetterCount(scrambledWord);

        for (String word : guessedWords) {
            if (canFormWord(word, letterCount)) {
                totalPoints += getPointsForWord(word);
            }
        }

        return totalPoints;
    }

    private static Map<Character, Integer> getLetterCount(String word) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }
        return letterCount;
    }

    private static boolean canFormWord(String word, Map<Character, Integer> letterCount) {
        Map<Character, Integer> tempCount = new HashMap<>(letterCount);
        for (char c : word.toCharArray()) {
            if (!tempCount.containsKey(c) || tempCount.get(c) == 0) {
                return false;
            }
            tempCount.put(c, tempCount.get(c) - 1);
        }
        return true;
    }

    private static int getPointsForWord(String word) {
        int length = word.length();
        switch (length) {
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 4 + 50;
            default:
                return 0;
        }
    }

    //#5
    public static int longestRun(int[] arr) {
        if (arr.length == 0) return 0;

        int maxRun = 1;
        int currentRun = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1 || arr[i] == arr[i - 1] - 1) {
                currentRun++;
            } else {
                maxRun = Math.max(maxRun, currentRun);
                currentRun = 1;
            }
        }

        return Math.max(maxRun, currentRun);
    }

    //#6
    public static String takeDownAverage(String[] scores) {
        int total = 0;
        int count = scores.length;

        for (String score : scores) {
            total += Integer.parseInt(score.replace("%", ""));
        }

        double currentAverage = total / (double) count;

        double newAverage = currentAverage - 5;

        double requiredScore = newAverage * (count + 1) - total;

        int roundedScore = (int) Math.round(requiredScore);

        return roundedScore + "%";
    }

    //#7
    public static boolean canMove(String figure, String start, String end) {
        int startRow = start.charAt(1) - '1';
        int endRow = end.charAt(1) - '1';
        char startCol = start.charAt(0);
        char endCol = end.charAt(0);
        int colDiff = Math.abs(startCol - endCol);
        int rowDiff = Math.abs(startRow - endRow);

        switch (figure.toLowerCase()) {
            case "pawn":
                return (startRow + 1 == endRow && startCol == endCol) ||
                        (startRow + 2 == endRow && startCol == endCol && startRow == 1);
            case "knight":
                return (colDiff == 2 && rowDiff == 1) || (colDiff == 1 && rowDiff == 2);
            case "bishop":
                return colDiff == rowDiff;
            case "rook":
                return startCol == endCol || startRow == endRow;
            case "queen":
                return startCol == endCol || startRow == endRow || colDiff == rowDiff;
            case "king":
                return colDiff <= 1 && rowDiff <= 1;
            default:
                return false;
        }
    }

    //#8
    public static int maxPossible(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);

        Character[] digits2 = str2.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Arrays.sort(digits2, Collections.reverseOrder());

        char[] result = str1.toCharArray();
        int index2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (index2 < digits2.length && result[i] < digits2[index2]) {
                result[i] = digits2[index2];
                index2++;
            }
        }
        return Integer.parseInt(new String(result));
    }

    //#9
    private static final Map<String, Integer> CITY_OFFSETS = new HashMap<>();

    static {
        CITY_OFFSETS.put("Los Angeles", -8 * 60);
        CITY_OFFSETS.put("New York", -5 * 60);
        CITY_OFFSETS.put("Caracas", -4 * 60 - 30);
        CITY_OFFSETS.put("Buenos Aires", -3 * 60);
        CITY_OFFSETS.put("London", 0);
        CITY_OFFSETS.put("Rome", 1 * 60);
        CITY_OFFSETS.put("Moscow", 3 * 60);
        CITY_OFFSETS.put("Tehran", 3 * 60 + 30);
        CITY_OFFSETS.put("New Delhi", 5 * 60 + 30);
        CITY_OFFSETS.put("Beijing", 8 * 60);
        CITY_OFFSETS.put("Canberra", 10 * 60);
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.US);
        LocalDateTime cityATime = LocalDateTime.parse(timestamp, inputFormatter);

        int offsetA = CITY_OFFSETS.getOrDefault(cityA, 0);
        int offsetB = CITY_OFFSETS.getOrDefault(cityB, 0);

        LocalDateTime utcTime = cityATime.minusMinutes(offsetA);
        LocalDateTime cityBTime = utcTime.plusMinutes(offsetB);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
        return cityBTime.format(outputFormatter);
    }

    //#10
    public static boolean isNew(int n) {
        for (int i = 1; i < n; i++) {
            String strA = String.valueOf(n);
            String strB = String.valueOf(i);
                if (strA.length() == strB.length()) {
                char[] charA = strA.toCharArray();
                char[] charB = strB.toCharArray();
                Arrays.sort(charA);
                Arrays.sort(charB);
                if (Arrays.equals(charA, charB)) {
                    return false;
                }
            }
        }
        return true;
    }
}