/**
 * Defines the structure of a regular pentagon (one where all the sides are the same length)
 */
public class Pentagon implements Polygon, NormalPolygon {
    private double side;
    public final boolean isNormal = true;

    public Pentagon() {
        side = 0;
    }

    public Pentagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double area() {
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }

    public double perimeter() {
        return 5 * side;
    }
}
