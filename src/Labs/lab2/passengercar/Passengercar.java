package Labs.lab2.passengercar;

import Labs.lab2.Auto;

public class Passengercar extends Auto {
    private int quantityFuel;
    private int backPassengers;
    private int trunk;
    private String itemsInTrunk;


    public Passengercar() {
        super();
    }

    public Passengercar(int speed, int doors, int fuel, int quantityFuel, int backPassengers, int trunk) {
        super(speed, doors, fuel);
        this.quantityFuel = quantityFuel;
        this.backPassengers = backPassengers;
        this.trunk = trunk;
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
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "l");
            setFuel(i);
        }
    }

    public void openTrunk() {
        System.out.println("trunk is open");
    }

    public void closeTrunk() {
        System.out.println("trunk is closed");
    }

    public void takeItems(String ... items){
        for (int i = 0; i < items.length; i++) {
            if(i == items.length - 1){
                itemsInTrunk += items[i];
            }
            itemsInTrunk += items[i] + ",";
        }
        System.out.println(itemsInTrunk);
    }

    public int getQuantityFuel() {
        return quantityFuel;
    }

    public void setQuantityFuel(int quantityFuel) {
        this.quantityFuel = quantityFuel;
    }

    public int getBackPassengers() {
        return backPassengers;
    }

    public void setBackPassengers(int backPassengers) {
        this.backPassengers = backPassengers;
    }

    public int getTrunk() {
        return trunk;
    }

    public void setTrunk(int trunk) {
        this.trunk = trunk;
    }
}
