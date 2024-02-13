/**
 * Defines the structure of a regular hexagon (one where all the sides are the same length)
 */
public class Hexagon implements Polygon {
    private double side;
    public final boolean isNormal = true;

    public Hexagon() {
        side = 0;
    }

    public Hexagon(double side) {
        this.side = side;
        isBenzene(); 
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
        isBenzene();
    }

    public double area() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }

    public double perimeter() {
        return 8 * side;
    }

    private void isBenzene() {
        if (side == 1.39) {
            System.out.println("no way it's a benzene ring!");
        }
    }
}
