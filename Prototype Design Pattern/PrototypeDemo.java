// Prototype Design Pattern

// Creational Pattern
// new Object by cloning existing one
// Avoid Expensive cost of creating new objects 

interface Prototype{
    Prototype clone();
}

class Shape implements Prototype{
    private int x, y;

    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public Prototype clone() {
        return new Shape(x, y);
    }
}

class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius){
        super(x, y);
        this.radius = radius;
    }
    
    @Override
    public Prototype clone(){
        return new Circle(getX(), getY(), radius);
    }
}

public class PrototypeDemo {
    public static void main(String [] arg){
        Circle circleprototype = new Circle(10, 20, 50);
        Circle redCircle = (Circle) circleprototype.clone();
        Circle greenCircle = (Circle) circleprototype.clone();
    }
}


