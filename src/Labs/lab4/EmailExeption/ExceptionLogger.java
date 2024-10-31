package Labs.lab4.EmailExeption;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionLogger {
    private static final String LOG_FILE_PATH = "C:\\Users\\ogkri\\IdeaProjects\\LABS2\\src\\Labs\\lab4\\EmailExeption\\exception_log.txt";

    public static void logException(Exception e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy ");
            LocalDateTime now = LocalDateTime.now();
            writer.write("[" + dtf.format(now) + "] " + e.getClass().getName() + ": " + e.getMessage() + "\n");
        } catch (IOException ioException) {
            System.out.println("Ошибка записи в лог-файл: " + ioException.getMessage());
        }
    }
}