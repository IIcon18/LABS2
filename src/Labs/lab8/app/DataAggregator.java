package Labs.lab8.app;

public class DataAggregator {
    @DataProcessor
    public String aggregate(String data) {
        if (data == null || data.trim().isEmpty()) {
            return "";
        }
        return data + " [Length: " + data.length() + "]";
    }
}


