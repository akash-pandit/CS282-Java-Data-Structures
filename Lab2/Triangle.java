/**
 * Defines the structure of a generic triangle object. Can be instantiated
 * through its child objects, EquilateralTriangle and IsoscelesTriangle
 */
abstract class Triangle implements Polygon {
    protected double base;
    protected double height;

    // formula for area of triangle constant among all triangles
    public double area() {
        return (double) 0.5 * base * height;
    }

    // formula for perimeter of triangle varies by triangle type
    public abstract double perimeter();
}
