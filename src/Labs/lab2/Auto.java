package Labs.lab2;

public abstract class Auto {
    private int speed;
    private int doors;
    private int fuel;

    public Auto(){

    }

    public Auto(int speed, int doors, int fuel){
        this.speed = speed;
        this.doors = doors;
        this.fuel = fuel;
    }

    public abstract boolean drive();
    public abstract void refill();


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
