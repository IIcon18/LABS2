package Labs.lab7.number3;

import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {
    private final Queue<Product> products = new LinkedList<>();

    public Warehouse() {
        products.add(new Product("Молоко", 100));
        products.add(new Product("Сыр", 150));
        products.add(new Product("Хлеб", 50));
        products.add(new Product("Кола", 200));
        products.add(new Product("Сок", 300));
        products.add(new Product("Печенье", 100));
        products.add(new Product("Конфеты", 80));
        products.add(new Product("Консервы", 120));
    }

    public synchronized Product getProduct() {
        return products.poll();
    }

    public synchronized boolean isEmpty() {
        return products.isEmpty();
    }
}
