package Labs.lab8.app;

public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();

        // Регистрируем обработчики
        manager.registerDataProcessor(new DataFilter());
        manager.registerDataProcessor(new DataTransformer());
        manager.registerDataProcessor(new DataAggregator());

        // Загружаем данные из файла input.txt
        manager.loadData();

        // Обрабатываем данные
        manager.processData();

        // Сохраняем результат
        manager.saveData();
    }
}

