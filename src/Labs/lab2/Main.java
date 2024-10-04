package Labs.lab2;

import Labs.lab2.cargocar.Cargocar;
import Labs.lab2.motobike.Motobike;
import Labs.lab2.passengercar.Passengercar;

public class Main {
    public static void main(String[] args) {
        Passengercar passengercar = new Passengercar(120, 4, 35, 45, 3, 20);
        passengercar.refill();
        passengercar.takeItems("Велосипед", "Чемодан", "Аптечка");
        passengercar.openTrunk();
        passengercar.closeTrunk();
        System.out.println(passengercar.toString());

        Cargocar cargocar = new Cargocar(80, 2, 110, true, 120);
        cargocar.refill();
        cargocar.hireEmployee("Михаил");
        cargocar.hireEmployee("Валера", "Виталя");
        cargocar.setTrailer();

        Cargocar cargocar1 = new Cargocar();
        System.out.println(cargocar.toString() + " " + Cargocar.getCount());

        Motobike motobike = new Motobike(250, 0, 10, 2, 2020, 20 );
        motobike.refill();
        motobike.sitPasanger("Катя");
        motobike.sitPasanger("Настя", "Соня");
        motobike.installMode();
        System.out.println(motobike.toString());
    }
}
