package Labs.lab3;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {

        HashTable<Integer, String> table = new HashTable<>();
        table.put(1, "one");
        table.put(2, "two");
        table.put(3, "three");

        System.out.println(table.get(2));
        System.out.println(table.toString());
        System.out.println(table.isEmpty());

        Hashtable<Integer, Book> table2 = new Hashtable<>();
        table2.put(325235642, new Book("Война и Мир", "Л.Н.Толстой", 7));
        table2.put(783879342, new Book( "Собачье Сердце", "М.А.Булгаков", 3));
        table2.put(343255432, new Book( "Преступление и наказание", "Ф.М.Достоевский", 6));

        System.out.println(table2.get(783879342));
        System.out.println(table2.toString());
        System.out.println(table2.isEmpty());
        System.out.println(table2.remove(343255432));
        System.out.println(table2.toString());
    }
}
