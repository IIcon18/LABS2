package Labs.lab8.app;

public class DataFilter {
    @DataProcessor
    public String filter(String data) {
        // Убираем строки, содержащие слово "skip"
        if (data.toLowerCase().contains("skip")) {
            return null; // Отметка для удаления
        }
        return data;
        }
    }
