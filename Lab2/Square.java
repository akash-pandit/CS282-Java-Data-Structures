/**
 * Defines the structure of a square object. Default constructor initalizes all side lengths to 0.
 */
public class Square extends Quadrilateral {
    public final boolean isNormal = true;

    public Square() {
        super();
        super.setBase(0);
        super.setHeight(0);
    }

    public Square(double side) {
        super();
        super.setBase(side);
        super.setHeight(side);
    }

    /**
     * Sets square object sides to the given double.
     */
    public void setBase(double side) {
        super.setBase(side);
        super.setHeight(side);
    }

    /**
     * Sets square object sides to the given double.
     * NOTE: functionally identical to setBase().
     */
    public void setHeight(double side) {
        setBase(side);
        setHeight(side);
    }

    // area & perimeter defined in Quadrilateral parent class & works here
}
