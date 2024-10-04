package Labs.lab2.cargocar;

import Labs.lab2.Auto;

public class Cargocar extends Auto {
    private boolean trailer;
    private int quantityFuel;
    private String employee;
    private static int count = 0;

    public Cargocar() {
        super();
        count++;
    }

    public Cargocar(int speed, int doors, int fuel, boolean trailer, int quantityFuel) {
        super(speed, doors, fuel);
        this.trailer = trailer;
        this.quantityFuel = quantityFuel;
        count++;
    }


    @Override
    public boolean drive() {
        return getSpeed() >= 0;
    }

    @Override
    public void refill() {
        Thread refill = new Thread();
        refill.start();
        for (int i = getFuel(); i <= quantityFuel ; i++) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "l");
            setFuel(i);
        }
        System.out.println("Грузовой автомобиль заправлен");
    }

    public void setTrailer() {
        if (trailer) {
            System.out.println("Трейлер пристыкован");
        }
        System.out.println("Трейлер отсоединен");
    }

    public void hireEmployee(String name) {
        employee = name;
        System.out.println("Нанят один грузчик " + name);
    }

    public void hireEmployee(String name1, String name2) {
        employee = name1;
        employee = name2;
        System.out.println("Нанято два грузчика " + name1 + " и " + name2);
    }


    public boolean isTrailer() {
        return trailer;
    }

    public void setTrailer(boolean trailer) {
        this.trailer = trailer;
    }

    public int getQuantityFuel() {
        return quantityFuel;
    }

    public void setQuantityFuel(int quantityFuel) {
        this.quantityFuel = quantityFuel;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Cargocar.count = count;
    }

    @Override
    public String toString() {
        return "Cargocar{" +
                "trailer=" + trailer +
                ", quantityFuel=" + quantityFuel +
                ", employee='" + employee + '\'' +
                '}';
    }
}
