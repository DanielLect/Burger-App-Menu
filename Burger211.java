package burger;

import java.util.ArrayList;

class Burger_info {
    String name;
    double price;
    String topping;
}

public abstract class Burger211 {
    // initializing
    private ArrayList<Burger_info> Burger = new ArrayList<>();

    Burger211() {
        Burger_info b1 = new Burger_info();
        b1.name="First burger";
        b1.price=5.0;
        b1.topping="beef patty, tomato, onion, ranch source";

        Burger_info b2 = new Burger_info();
        b2.name="Second burger";
        b2.price=2.0;
        b2.topping="tomato, onion, ranch source";

        Burger_info b3 = new Burger_info();
        b3.name="Third burger";
        b3.price=6.0;
        b3.topping="potato potato potato";

        Burger.add(b1);
        Burger.add(b2);
        Burger.add(b3);
    }


    // get methods
    public String getName(int i) {
        return Burger.get(i).name;
    }
    public double getPrice(int i) {
        return Burger.get(i).price;
    }
    public String getTopping(int i) {
        return Burger.get(i).topping;
    }
    public int getHowManyBurgers() {
        return Burger.size();
    }

    // changing topping
    public void UpdateTopping(String newt, int i) {
        Burger.get(i).topping = newt;
    }

    // abstract methods

    abstract void Promotion(int discountRate, String promote);
    abstract void printMenu();

}
