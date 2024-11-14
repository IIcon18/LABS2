package Labs.lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        String password1 = "pAssword123";
        String password2 = "password123";

        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
        Matcher matcher1 = pattern.matcher(password1);
        Matcher matcher2 = pattern.matcher(password2);

        if (matcher1.matches()) {
            System.out.println("Password1 is valid: " + password1);
        } else {
            System.out.println("Password1 is not valid: " + password1);
        }

        if (matcher2.matches()) {
            System.out.println("Password2 is valid: " + password2);
        } else {
            System.out.println("Password2 is not valid: " + password2);
        }
    }
}
