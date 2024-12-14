package Labs.lab8.app;

public class DataTransformer {
    @DataProcessor
    public String transform(String data) {
        if (data == null) {
            return ""; // Возвращаем пустую строку, если данные null
        }
        return data.toUpperCase(); // Преобразуем в верхний регистр
    }
}

