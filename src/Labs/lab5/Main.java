package Labs.lab5;

import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        //#1
        String text = "The price of the product is $19.99.";
        numberFinder(text);

        //#2
        String password = "pAssword123";
        passwordValidator(password);

        //#3
        String str = "theReDSharkStartsSwiMmiNgInTHeWaTer";
        capitalAfterLowerFinder(str);

        //#4
        String ip = "38.0.101.76";
        ipAdressValidator(ip);

        //#5
        String s = "The quick brown fox jumps over the lazy dog. This sentence contains several words that start with " +
                "some letter. For example, the words 'the', 'this', 'that', and 'there'";
        char c = 't';
        wordStartingFinder(s, c);
    }

    //#1
    public static void numberFinder(String text) {
        try {
            Pattern pattern = Pattern.compile("\\$\\d+\\.\\d+");
            Matcher matcher = pattern.matcher(text);

            boolean found = false;
            while (matcher.find()) {
                System.out.println("Found: " + matcher.group());
                found = true;
            }

            if (!found) {
                System.out.println("No numbers found.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произашла непредвиденная ошибка: " + e.getMessage());
        }
    }

    //#2
    public static void passwordValidator(String password){
        try {
            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be null or empty.");
            }

            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher1 = pattern.matcher(password);

            if (matcher1.matches()) {
                System.out.println("Password1 is valid: " + password);
            } else {
                System.out.println("Password1 is not valid: " + password);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произашла непредвиденная ошибка: " + e.getMessage());
        }
    }

    //#3
    public static void capitalAfterLowerFinder (String text) {
        try {
            if (text == null || text.isEmpty()) {
                throw new IllegalArgumentException("Text cannot be null or empty.");
            }

            Pattern pattern = Pattern.compile("(?<=[a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);

            String result = matcher.replaceAll("!$1!");

            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произашла непредвиденная ошибка: " + e.getMessage());
        }
    }

    //#4
    public static void  ipAdressValidator(String ip) {
        try {
            if (ip == null || ip.isEmpty()) {
                throw new IllegalArgumentException("IP address cannot be null or empty.");
            }

            Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
            Matcher matcher1 = pattern.matcher(ip);

            if (matcher1.matches()) {
                System.out.println("IP address is valid: " + ip);
            } else {
                System.out.println("IP address is not valid: " + ip);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произашла непредвиденная ошибка: " + e.getMessage());
        }
    }

    //#5
    public static void wordStartingFinder(String s, char c) {
        try {
            Pattern pattern = Pattern.compile("\\b[" + c + "]\\w*", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(s);

            while (matcher.find()) {
                System.out.println("Found: " + matcher.group());
            }
        } catch (IllegalArgumentException e){
            System.out.println("Ошибка:" + e.getMessage());
        }catch (Exception e) {
            System.out.println("Произашла непредвиденная ошибка:" + e.getMessage());
        }
    }
}

