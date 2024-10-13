package tasks.tasks3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //#1
        System.out.println("#1");
        System.out.println(isStrangerPair("sparking", "groups"));
        System.out.println(isStrangerPair("bush", "hubris"));
        System.out.println(isStrangerPair("", ""));
        //#2
        System.out.println("#2");
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Laptop", 124200);
        inventory.put("Phone", 51450);
        inventory.put("Headphones", 13800);
        System.out.println(sale(inventory, 25));
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
        System.out.println(mostExpensive(new Object[][]{{"Скакалка", 550, 8}, {"Шлем", 3750, 4}, {"Мяч", 2900, 10}}));
        //#8
        System.out.println("#8");
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));
        //#9
        System.out.println("#9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
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
    public static Map<String, Integer> sale(Map<String, Integer> map, int sale) {
        map.replaceAll((k, v) -> v - v * sale / 100);
        return map;
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
    public static String mostExpensive(Object[][] arr) {
        int max = 0;
        String name = "";
        for (Object[] objects : arr) {
            int n = 1;
            for (Object s : objects) {
                if (s instanceof String) {
                    name = (String) s;
                }
                if(s instanceof Integer) {
                    n *= (int) s;
                }
            }
            max = Math.max(max, n);
        }
        return "Наиб. общ. стоимость у предмета " + name + " - " + max;
    }
    //#8
    public static String longestUnique(String str) {

        StringBuilder sb = new StringBuilder();
        int size = 0;
        int len = 0;
        int max = 0;

        Map<Integer, String> map = new HashMap<>();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
            size++;

            if(set.size() == size){
                sb.append(str.charAt(i));
                len++;
            }else{
                max = Math.max(max, len);
                map.put(len, sb.toString());
                sb = new StringBuilder();
                set.clear();
                size = 0;
                len = 0;
            }
        }
        return map.get(max);
    }
    //#9
    public static boolean isPrefix(String word, String prefix) {
        prefix = prefix.replace("-", "");
        return word.startsWith(prefix);
    }

    public static boolean isSuffix(String word, String suffix) {
        suffix = suffix.replace("-", "");
        return word.endsWith(suffix);
    }
    //#10
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) || (a <= w && c <= h) || (a <= h && c <= w) ||  (b <= w && c <= h) || (b <= h && c <= w);
    }
}
