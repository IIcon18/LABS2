package Labs.lab3;

public class Main {
    public static void main(String[] args) {

        HashTable<Integer, String> table = new HashTable<>();
        table.put(1, "one");
        table.put(2, "two");
        table.put(3, "three");

        System.out.println(table.get(2));
        System.out.println(table.toString());
        System.out.println(table.isEmpty());
    }
}
