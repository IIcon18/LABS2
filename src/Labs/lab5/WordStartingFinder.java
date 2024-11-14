package Labs.lab5;

import java.util.regex.*;

public class WordStartingFinder {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog. This sentence contains several words that start with some letter. For example, the words 'the', 'this', 'that', and 'there'";
        char c = 't';

        Pattern pattern = Pattern.compile("\\b[" + c + "]\\w*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found: " + matcher.group());
        }
    }
}
