package Labs.lab2;

import Labs.lab2.passengercar.Passengercar;

public class Main {
    public static void main(String[] args) {
        Passengercar passengercar = new Passengercar(120, 4, 5, 45, 3, 20);
        passengercar.refill();
        passengercar.takeItems("Велосипед", "Чемодан", "Кофта", "Рюкзак", "Аптечка");
    }
}
