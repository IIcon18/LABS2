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
        //#3
        System.out.println("#3");
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

    //#3

    //#4

    //#5

    //#6

    //#7

    //#8

    //#9

    //#10
}
