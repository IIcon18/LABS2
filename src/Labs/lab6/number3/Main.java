package Labs.lab6.number3;

public class Main {
    public static void main(String[] args) {
        SaleList saleList = new SaleList();

        saleList.addProduct(new Sale("Телефон", 1000.0, 3));
        saleList.addProduct(new Sale("Ноутбук", 2000.0, 5));
        saleList.addProduct(new Sale("Планшет", 500.0, 15));

        saleList.addSale("Телефон");
        saleList.addSale("Телефон");
        saleList.addSale("Ноутбук");
        saleList.addSale("Планшет");

        System.out.println(saleList.getList());

        System.out.println("Самый популярный товар: " + saleList.getMostPopularItem());

        System.out.println("Количество продаж товара Телефон - " + saleList.getSalesCount("Телефон"));

        System.out.println("Количество продаж товара Планшет - " + saleList.getSalesCount("Планшет"));
    }
}