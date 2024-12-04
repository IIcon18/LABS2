package Labs.lab7.number3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new LoaderTask(warehouse, "Loader 1"));
        executor.execute(new LoaderTask(warehouse, "Loader 2"));
        executor.execute(new LoaderTask(warehouse, "Loader 3"));

        executor.shutdown();
    }

}
