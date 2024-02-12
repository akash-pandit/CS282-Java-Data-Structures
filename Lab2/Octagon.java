/**
 * Defines the structure of a regular octagon (one where all the sides are the same length)
 */
public class Octagon implements Polygon, NormalPolygon {
    private double side;
    public final boolean isNormal = true;

    public Octagon() {
        side = 0;
    }

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double area() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }

    public double perimeter() {
        return 8 * side;
    }
}
