package Labs.lab4.FileCopy;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String ReaderPath = "C:\\Users\\ogkri\\IdeaProjects\\LABS2\\src\\Labs\\lab4\\FileCopy\\Reader.txt";
        String WriterPath = "C:\\Users\\ogkri\\IdeaProjects\\LABS2\\src\\Labs\\lab4\\FileCopy\\Writer.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(ReaderPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(WriterPath))) {
            //throw new IOException("Намеренно вызванное исключение ввода-вывода");

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Файл успешно скопирован.");

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}
