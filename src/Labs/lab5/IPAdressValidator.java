package Labs.lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAdressValidator {
    public static void main(String[] args) {
        String ip1 = "38.0.101.76";
        String ip2 = "192.1.279.2";

        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher matcher1 = pattern.matcher(ip1);
        Matcher matcher2 = pattern.matcher(ip2);

        if (matcher1.matches()) {
            System.out.println("IP address is valid: " + ip1);
        } else {
            System.out.println("IP address is not valid: " + ip1);
        }

        if (matcher2.matches()) {
            System.out.println("IP address is valid: " + ip2);
        } else {
            System.out.println("IP address is not valid: " + ip2);
        }
    }
}