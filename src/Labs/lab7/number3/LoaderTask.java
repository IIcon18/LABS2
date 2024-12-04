package Labs.lab7.number3;

import java.util.LinkedList;

public class LoaderTask implements Runnable {
    private final Warehouse warehouse;
    private final String name;

    public LoaderTask(Warehouse warehouse, String name) {
        this.warehouse = warehouse;
        this.name = name;
    }

    public void run() {
        while (true) {
            int totalWeight = 0;
            LinkedList<Product> load = new LinkedList<>();

            while (totalWeight < 50) {
                Product product = warehouse.getProduct();
                if (product == null) break;  // Если товаров больше нет
                if (totalWeight + product.getWeight() >= 300) {
                    warehouse.getProduct();  // Положить товар обратно
                    break;
                }
                load.add(product);
                totalWeight += product.getWeight();
            }

            if (load.isEmpty()) break;  // Если товаров больше нет

            System.out.println(name + " перенёс товары: " + load + ". Общий вес: " + totalWeight + " кг");

            try {
                // Имитация времени переноса на другой склад
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
