public class Taxi extends Vehicle implements Runnable, Stoppable, Drivable {
    private int feePerDistance;         // 거리 당 요금
    private int basicDistance;          // 기본거리
    private int toDestination;          // 목적지까지 거리
    private String destination;         // 목적지

    public Taxi(int fee, int fuel, int curSpeed, int maxPassenger, int basicDistance, int feePerDistance) {
        super(fee, fuel, curSpeed, 0, maxPassenger);
        this.feePerDistance = feePerDistance;
        this.basicDistance = basicDistance;
        this.toDestination = 0;
        this.destination = null;
        stop();
    }


    @Override
    public void run() {
        if (getFuel() < 10) {
            System.out.println("주유가 필요합니다.");
        } else {
            setStatus(Status.RUN);
            System.out.println("**운행중**");
            speedUp(50);
        }
    }

    @Override
    public void stop() {
        setStatus(Status.NORMAL);
    }

    @Override
    public void speedUp(int speed) {
        int left = getFuel() - 50;
        int cur = getCurSpeed() + speed > 200 ? 200 : getCurSpeed() + speed;

        if (left < 10) {
            System.out.println("[경고 메시지]");
            System.out.println("주유가 필요하다.");
            ;
            stop();
            setCurSpeed(0);
        } else {
            setFuel(left);
            setCurSpeed(cur);
        }
    }

    @Override
    public void speedDown(int speed) {
        int left = getFuel() - 50;
        int cur = getCurSpeed() - speed;

        if (cur <= 0) {
            setCurSpeed(0);
            stop();
        } else {
            if (left < 10) {
                System.out.println("[경고 메시지]");
                System.out.println("주유가 필요하다.");
                ;
                stop();
                setCurSpeed(0);

                if (left < 0)
                    setFuel(0);
                else
                    setFuel(left);
            } else {
                setFuel(left);
                setCurSpeed(getCurSpeed() - speed);
            }
        }
    }

    @Override
    public void getOn(int count, String destination, int toDestination) {
        if (getStatus() == Status.NORMAL) {
            int cur = getCurPassenger() + count > getMaxPassenger() ? getMaxPassenger() : getCurPassenger() + count;

            setCurPassenger(cur);
            run();
            this.destination = destination;
            this.toDestination = toDestination;
            System.out.println("고객 " + count + "명은 현재 " + destination + "으로 이동하고 있습니다.");
        } else {
            System.out.println("탑승 불가 상태입니다.");
        }
    }

    @Override
    public void getOff() {
        if (this.toDestination == 0 || getStatus() == Status.NORMAL) {
            System.out.println("현재 고객이 탑승중이지 않습니다.");
            return;
        }
        stop();
        int profit = calculate();
        setProfit(profit);
        System.out.println("목적지 :" + this.destination + "도착 ! \n최종 요금은 : " + profit + "원 입니다.");
        this.destination = null;
        this.toDestination = 0;
        setCurPassenger(0);
    }

    private int calculate() {
        if (this.toDestination == 0 || getCurPassenger() == 0) {
            System.out.println("현재 고객이 탑승하지 않았습니다.");
            return 0;
        }
        if (this.toDestination > this.basicDistance) {
            int count = this.toDestination / this.basicDistance;
            return count * (2 * getFee() + (count - 1) * this.feePerDistance) / 2;
        } else {
            return getFee();
        }
    }

    public void showInfo() {
        System.out.println("Taxi : " + this.getRouteNum() + " - 승객 수 : " + this.getCurPassenger() + " - 수익 : " + this.getProfit());
        System.out.println("현재 속도 : " + this.getCurSpeed() + " 현상 상태 :" + getStatus());
    }
}
