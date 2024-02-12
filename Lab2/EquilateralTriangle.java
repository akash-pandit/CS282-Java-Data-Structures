/**
 * Initialize an Equilateral Triangle object. Default constructor values
 * creates an equilateral triangle with all dimensions set to 0.
 */
public class EquilateralTriangle extends Triangle implements NormalPolygon {
    public final boolean isNormal = true;

    public EquilateralTriangle() {
        super();
        super.setBase(0);
        super.setHeight(0);
    }

    public EquilateralTriangle(double base) {
        super();
        super.setBase(base);
        double height = super.getBase() * (Math.sqrt(3) / 2);
        super.setHeight(height);
    }

    // area method covered by Triangle parent class

    public double perimeter() {
        return 3 * super.getBase();
    }
    
}
