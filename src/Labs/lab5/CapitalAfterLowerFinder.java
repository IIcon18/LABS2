package Labs.lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalAfterLowerFinder {
    public static void main(String[] args) {
        String text = "theReDSharkStartsSwiMmiNgInTHeWaTer";

        Pattern pattern = Pattern.compile("(?<=[a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);

        String result = matcher.replaceAll("!$1!");

        System.out.println(result);
    }
}
