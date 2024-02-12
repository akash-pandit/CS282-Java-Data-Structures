/**
 * Defines the structure of a rectangle object. Default constructor initalizes all side lengths to 0.
 */
public class Rectangle extends Quadrilateral {
    public final boolean isNormal = false;

    public Rectangle() {
        super();
        super.setBase(0);
        super.setHeight(0);
    }

    public Rectangle(double base, double height) {
        super();
        super.setBase(base);
        super.setHeight(height);
    }

    // all other methods (get/set dims, area, parameter) covered by parent class Quadrilateral
}
