package Labs.lab8.app;

public class DataTransformer {
    @DataProcessor
    public String transform(String data) {
        if (data == null) {
            return "";
        }
        return data.toUpperCase();
    }
}

