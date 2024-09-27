package tasks.tasks2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // #1
        System.out.println(duplicateChars("Barack", "Obama"));

        //#2
        System.out.println(dividedByThree(new int[]{3, 12, 7, 81, 52}));

        //#3
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));

        //#6
        System.out.println(camelToSnake("helloWorld!"));
    }

    //#1
    public static String duplicateChars(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        List<String> list = new ArrayList<>(Arrays.asList(s1.split("")));
        String[] array = s2.split("");

        for (int i = 0; i < array.length ; i++) {
            list.remove(array[i]);
        }

        String result = "";

        for (int i = 0; i < list.size() ; i++) {
            result += list.get(i);
        }

        return result;

    }

    //#2
    public static int dividedByThree(int [] array) {
        int count = 0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i] % 2 != 0 && array[i] % 3 == 0) {
                count++;
            }
        }
        return count;
    }

    //#3
    public static String getInitials(String s) {
        String[] arr = s.split(" ");
        String a = arr[1].toUpperCase().charAt(0) + "." + arr[2].toUpperCase().charAt(0) + ".";
        for (int i = 0; i < arr[0].length(); i++) {
            if (i == 0) {
                a += arr[0].toUpperCase().charAt(i);
                continue;
            }
            a += arr[0].charAt(i);
        }
        return a;
    }

    //#4

    //#5

    //#6
    public static String camelToSnake(String str) {
        String[] arr = str.split("(?=[A-Z])");
        String a = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                a += arr[i].toLowerCase();
                break;
            }
            a += arr[i].toLowerCase() + "_";
        }
        return a;
    }
}




