package Labs.lab8.app;

public class DataFilter {
    @DataProcessor
    public String filter(String data) {
        if (data.toLowerCase().contains("skip")) {
            return null;
        }
        return data;
        }
    }
