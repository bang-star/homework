
public class Vehicle {
    private int fee;                // 기본 요금
    private int fuel;               // 주유량
    private int routeNum;           // 버스 번호, 택시 번호
    private int curSpeed;           // 현재 속도
    private Status status;          // 상태
    private int curPassenger;       // 현재 승객수
    private int maxPassenger;       // 최대 승객수
    private int profit;             // 수익

    public void setProfit(int profit) {
        this.profit += profit;
    }

    public Vehicle(int fee, int fuel, int curSpeed, int curPassenger, int maxPassenger) {
        this.fee = fee;
        this.fuel = fuel;
        this.routeNum = (int)(Math.random()*1000)+1;
        this.curSpeed = curSpeed;
        this.curPassenger = curPassenger;
        this.maxPassenger = maxPassenger;
        this.profit = 0;
    }

    public int getProfit() {
        return profit;
    }

    public int getRouteNum() {
        return routeNum;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public void setCurPassenger(int curPassenger) {
        this.curPassenger = curPassenger;
    }

    public int getCurPassenger() {
        return this.curPassenger;
    }

    public int getCurSpeed() {
        return curSpeed;
    }

    public void setCurSpeed(int curSpeed) {
        this.curSpeed = curSpeed;
    }

    public int getFuel() {
        return fuel;
    }

    public Status getStatus() {
        return status;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public int getFee() {
        return fee;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    void getOn(int count){}
    void getOn(int count, String destination, int toDestination){}
    void getOff(){}
    void getOff(int count){}
}
