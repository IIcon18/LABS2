package Labs.lab8.app;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DataManager {
    private List<Method> dataProcessors = new ArrayList<>();
    private List<Object> processorInstances = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        for (Method method : processor.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(DataProcessor.class)) {
                dataProcessors.add(method);
                processorInstances.add(processor);
            }
        }
    }

    public void loadData() {
        String filePath = "src\\Labs\\lab8\\data\\input.txt";
        try {
            data = Files.readAllLines(Paths.get(filePath));
            System.out.println("Данные успешно загружены из файла: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + filePath);
            e.printStackTrace();
        }
    }

    public void processData() {
        data = data.parallelStream()
                .map(item -> {
                    if (item != null) {
                        String current = item;
                        for (int i = 0; i < dataProcessors.size(); i++) {
                            try {
                                Method method = dataProcessors.get(i);
                                Object processor = processorInstances.get(i);
                                current = (String) method.invoke(processor, current);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        return current;
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public void saveData() {
        String filePath = "C:\\Users\\ogkri\\IdeaProjects\\LABS2\\src\\Labs\\lab8\\data\\output.txt";
        try {
            Files.write(Paths.get(filePath), data);
            System.out.println("Данные успешно сохранены в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + filePath);
            e.printStackTrace();
        }
    }
}
