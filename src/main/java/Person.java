public class Person {
    private String name;
    private int money;

    public Person(String name){
        this.name = name;
        this.money = 0;
    }

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
