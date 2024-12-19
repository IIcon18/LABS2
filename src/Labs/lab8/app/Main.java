package Labs.lab8.app;

public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();

        manager.registerDataProcessor(new DataFilter());
        manager.registerDataProcessor(new DataTransformer());
        manager.registerDataProcessor(new DataAggregator());

        manager.loadData();

        manager.processData();

        manager.saveData();
    }
}

