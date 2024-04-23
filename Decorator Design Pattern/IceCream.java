// Decorator Design Pattern

//The Decorator Design Pattern is a structural pattern that allows to add new behavior to an object dynamically, without altering its structure.


public abstract class IceCream {
    String description;

    String getDescription(){
        return description;
    }

    abstract int cost();
}

public class ChocolateIceCream extends IceCream {

    @Override
    String getDescription(){
        return "Chocolate";
    }

    int cost(){
        return 70;
    }
}

public class VanillaIceCream extends IceCream {

    @Override
    String getDescription() {
        return "Vanilla";
    }

    int cost() {
        return 100;
    }
}

public abstract class IceCreamDecorator extends IceCream {
    abstract int cost();
} 

public class RainbowSprinkleDecorator extends IceCreamDecorator {
    IceCream iceCream;

    RainbowSprinkleDecorator(IceCream iceCream){
        this.iceCream = iceCream;
    }

    @Override
    String getDescription(){
        return iceCream.getDescription() + "with Rainbow Sprinkler";
    }

    @Override
    int cost(){
        return iceCream.cost() + 30;
    }
}

public class WippedCreamDecorator extends IceCreamDecorator {
    IceCream iceCream;

    WippedCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    String getDescription() {
        return iceCream.getDescription() + "with WippedCream";
    }

    @Override
    int cost() {
        return iceCream.cost() + 30;
    }
}



public class Main {
    public static main(String[] arg){
        IceCream iceCream = new ChocolateIceCream();
        iceCream = new WippedCreamDecorator( new RainbowSprinkleDecorator(iceCream));
    }
}
