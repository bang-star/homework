public class Main {
    public static void main(String[] args){
        Bus bus = new Bus(1000, 1000, 0, 0, 40);
        bus.showInfo();

        bus.speedUp(50);
        bus.speedUp(50);
        bus.speedUp(50);
        bus.speedUp(50);
        bus.speedUp(50);

        bus.getOn(50);

        bus.showInfo();

        Taxi taxi = new Taxi(2000, 800, 0, 5, 100, 500);
        taxi.showInfo();
        taxi.getOn(100, "서울", 500);
        taxi.showInfo();
        taxi.getOff();

    }
}
