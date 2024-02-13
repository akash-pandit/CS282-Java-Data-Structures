/**
 * Defines the structure of a generic triangle object. Can be instantiated
 * through its child objects, EquilateralTriangle and IsoscelesTriangle
 */
abstract class Triangle implements Polygon {
    protected double base;
    protected double height;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // formula for area of triangle constant among all triangles
    public double area() {
        return (double) 0.5 * base * height;
    }

    // formula for perimeter of triangle varies by triangle type
    public abstract double perimeter();
}
