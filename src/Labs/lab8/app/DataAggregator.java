package Labs.lab8.app;

public class DataAggregator {
    @DataProcessor
    public String aggregate(String data) {
        if (data == null || data.trim().isEmpty()) {  // Проверка на null и пустую строку
            return "";  // Пропускаем пустые строки или null
        }
        return data + " [Length: " + data.length() + "]";
    }
}


