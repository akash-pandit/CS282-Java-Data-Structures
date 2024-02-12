/**
 * Defines the structure of a generic quadrilateral. Quadrilaterals may be initialized through
 * their child classes, Square and Rectangle.
 */
public class Quadrilateral implements Polygon {
    private double base;
    private double height;

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    protected void setBase(double base) {
        this.base = base;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    public double area() {
        return base * height;
    }

    public double perimeter() {
        return 2 * base + 2 * height;
    }
}
