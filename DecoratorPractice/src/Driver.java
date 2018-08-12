public class Driver {
    public static void main(String[] args){
        Car car = new Sedan();
        car = new Chrome(car);
        car = new Chrome(car);
        car = new Chrome(car);
        car = new Chrome(car);
        car = new Chrome(car);
        car = new Chrome(car);
        car = new Chrome(car);
        System.out.println(car.getDescription());
        System.out.println(car.cost());
    }
}
