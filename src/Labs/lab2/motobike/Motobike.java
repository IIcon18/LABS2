package Labs.lab2.motobike;

import Labs.lab2.Auto;

import java.util.SortedMap;

public class Motobike extends Auto {
    private int mode;
    private int year;
    private String passenger;
    private int quantityFuel;

    public Motobike(){
        super();
    }

    public Motobike(int speed, int doors, int fuel, int mode, int year, int quantityFuel) {
        super(speed, doors, fuel);
        this.mode = mode;
        this.year = year;
        this.quantityFuel = quantityFuel;
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
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "l");
            setFuel(i);
        }
        System.out.println("Мотоцикл заправлен");
    }

    public void sitPasanger(String name) {
        passenger = name;
        System.out.println("Прокатить " + name);
    }

    public void sitPasanger(String name1, String name2) {
        passenger = name1;
        passenger = name2;
        System.out.println("Прокатить " + name1 + " или " + name2);
    }

    public void installMode() {
        if (mode == 1) {
            System.out.println("Городской режим");
        }
        if (mode == 2) {
            System.out.println("Режим бездорожья");
        }
        if (mode == 3) {
            System.out.println("Гоночный режим");
        }
    }

    public int getQuantityFuel() {
        return quantityFuel;
    }

    public void setQuantityFuel(int quantityFuel) {
        this.quantityFuel = quantityFuel;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passanger) {
        this.passenger = passanger;
    }

    @Override
    public String toString() {
        return "Motobike{" +
                "mode=" + mode +
                ", year=" + year +
                ", passenger='" + passenger + '\'' +
                ", quantityFuel=" + quantityFuel +
                '}';
    }
}
