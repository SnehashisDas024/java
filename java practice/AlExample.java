import java.util.ArrayList;
import java.util.Collections;

public class AlExample {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");

        cars.add(1, "Mazda");
        Collections.sort(cars);
        System.out.println(cars);
    }
}
