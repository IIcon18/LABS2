package Labs.lab6.number3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

public class SaleList {
    private LinkedList<String> salesList = new LinkedList<>();
    private HashMap<String, Integer> salesMap = new HashMap<>();
    private ConcurrentHashMap<String, AtomicInteger> concurrentSalesCount = new ConcurrentHashMap<>();
    private ArrayList<Sale> list = new ArrayList<>();

    public void addProduct(Sale sale) {
        list.add (sale);
    }

    public void addSale(String itemName) {
        salesList.add(itemName);
        salesMap.put(itemName, salesMap.getOrDefault(itemName, 0) + 1);
        concurrentSalesCount.computeIfAbsent(itemName, k -> new AtomicInteger(0)).incrementAndGet();

        for (Sale sale : list) {
            if (sale.getItemName().equals(itemName)) {
                sale.setCount(sale.getCount() - 1);
            }
        }
    }

    public ArrayList<Sale> getList() {
        return list;
    }

    public void printSales() {
        for (String sale : salesList) {
            System.out.println(sale);
        }
    }

    public String getMostPopularItem() {
        String popularItem = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                popularItem = entry.getKey();
            }
        }
        return popularItem;
    }

    public int getSalesCount(String itemName) {
        return salesMap.getOrDefault(itemName, 0);
    }
}

