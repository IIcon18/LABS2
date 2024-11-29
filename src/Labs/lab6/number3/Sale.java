package Labs.lab6.number3;

public class Sale {
    private String itemName;
    private double price;
    private int count;

    public Sale(String itemName, double price, int count) {
        this.itemName = itemName;
        this.price = price;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" + itemName + ", " + price + ", " + count + '}';
    }
}



