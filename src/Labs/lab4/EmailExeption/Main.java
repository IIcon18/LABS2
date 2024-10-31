package Labs.lab4.EmailExeption;

public class Main {
    public static void main(String[] args) {
        String[] emails = {"valid@example.com", "invalid-email", "another.valid@example.com"};

        for (String email : emails) {
            try {
                EmailValidator.validateEmail(email);
                System.out.println("Email " + email + " прошел проверку.");
            } catch (CustomEmailFormatException e) {
                System.out.println(e.getMessage());
                ExceptionLogger.logException(e);
            }
        }
    }
}
