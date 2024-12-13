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

            while (totalWeight < 100) {
                Product product = warehouse.getProduct();
                if (product == null) break;
                if (totalWeight + product.getWeight() >= 500) {
                    warehouse.getProduct();
                    break;
                }
                load.add(product);
                totalWeight += product.getWeight();
            }

            if (load.isEmpty()) break;

            System.out.println(name + " перенёс товары: " + load + ". Общий вес: " + totalWeight + " кг");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

