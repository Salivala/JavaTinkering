public class Chrome extends Car{
    Car car;

    public Chrome(Car car) {
        this.car = car;
    }

    public String getDescription() {
        return car.getDescription() + ", Chrome";
    }
    @Override
    public int cost() {
        return 400 + car.cost();
    }
}
