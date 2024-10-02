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

        //#4
        System.out.println(Arrays.toString(normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5})));
        //#5
        System.out.println(Arrays.toString(compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5})));

        //#6
        System.out.println(camelToSnake("helloWorld!"));

        //#7
        System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4}));

        //#8
        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));

        //#9
        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5, 5, 5));
        System.out.println(equal(4, 9, 6));

        //#10
        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));



    }

    //#1
    public static String duplicateChars(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        List<String> list = new ArrayList<>(Arrays.asList(s1.split("")));
        String[] array = s2.split("");

        for (int i = 0; i < array.length; i++) {
            list.remove(array[i]);
        }

        String result = "";

        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }

        return result;

    }

    //#2
    public static int dividedByThree(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
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
    public static int[] compressedNums(double[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                a++;
            }
        }
        int[] nums2 = new int[nums.length - a];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                continue;
            }
            nums2[j] = (int) nums[i];
            j++;
        }
        Arrays.sort(nums2);
        return nums2;

    }

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

    //#7
    public static int secondBiggest(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 2];
    }

    //#8
    public static  String localReverse(String str, char b) {
        String[] arr = str.split(String.valueOf(b));
        int j = (str.charAt(0) == b ? 0 : 1);
        for (int i = j; i < arr.length; i++){
            StringBuilder temp = new StringBuilder();
            temp.append(arr[i]).reverse();
            str = str.replace(arr[i], temp.toString());
        }
        return str;
    }

    //#9
    public static int equal(int a, int b, int c) {
        if (a == b && b == c) {
            return 3;
        } else if (a == b || b == c || a == c) {
            return 2;
        } else {
            return 0;
        }
    }

    //#10
    public static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }
        String[] arr1s = str1.toLowerCase().split("[!,?.]");
        String[] arr2s = str2.toLowerCase().split("[!,?.]");
        char[] arr1 = arr1s[0].toCharArray();
        char[] arr2 = arr2s[0].toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}

