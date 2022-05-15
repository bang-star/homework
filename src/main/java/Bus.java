public class Bus extends Vehicle implements Runnable, Stoppable, Drivable{


    public Bus(int fee, int fuel, int routeNum, int curSpeed, int curPassenger, int maxPassenger) {
        super(fee, fuel, routeNum, curSpeed, curPassenger, maxPassenger);
        run();
        setProfit(curPassenger*fee);
    }

    @Override
    public void run() {
        if(getFuel() < 10){
            System.out.println("주유가 필요합니다.");
        }else {
            setStatus(Status.RUN);
            System.out.println("**운행중**");
        }
    }

    @Override
    public void stop() {
        setStatus(Status.STOP);
        System.out.println("운행을 중단합니다.");
    }

    @Override
    public void getOn(int count) {
        if (getStatus() == Status.STOP)
        {
            System.out.println("운행 중단된 버스입니다.");
            return;
        }else{
            int profit = getFee() * count;
            setProfit(profit);

            int cur = count + getCurPassenger();
            if(cur > getMaxPassenger()){
                int over = cur - getMaxPassenger()-getCurPassenger();
                System.out.println("현재 인원 FULL이고 "+over+"명은 탑승하지 못했습니다.");
                setCurPassenger(getMaxPassenger());
            }else{
                setCurPassenger(cur);
            }

        }
    }

    @Override
    public void getOff(int count) {
        int cur = getCurPassenger() - count;
        if(cur < 0){
            setCurPassenger(0);
        }else{
            setCurPassenger(cur);
        }
    }

    @Override
    public void speedUp(int speed) {
        int left = getFuel() - 20;
        int cur = getCurSpeed() + speed > 120? 120: getCurSpeed()+speed;
        if(left < 10){
            System.out.println("[경고 메시지]");
            System.out.println("주유가 필요하다.");;
            stop();
            setCurSpeed(0);
        }else{
            setFuel(left);
            setCurSpeed(cur);
        }
    }

    @Override
    public void speedDown(int speed) {
        int left = getFuel() - 50;
        int cur = getCurSpeed() - speed;
        if(cur<=0){
            setCurSpeed(0);
            stop();
        }else{
            if(left < 10){
                System.out.println("[경고 메시지]");
                System.out.println("주유가 필요하다.");;
                stop();
                setCurSpeed(0);
                if(left < 0)
                    setFuel(0);
                else
                    setFuel(left);
            }else{
                setFuel(left);
                setCurSpeed(getCurSpeed() - speed);
            }
        }
    }


    public void showInfo() {
        System.out.println("Bus : "+this.getRouteNum()+"번 버스는 승객 수 : "+this.getCurPassenger()+"명 수익 : "+this.getProfit());
        System.out.println("현재 속도 : "+this.getCurSpeed()+" 현재 연료량"+getFuel()+" 현상 상태 :"+getStatus());
    }
}
