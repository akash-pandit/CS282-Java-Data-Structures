/**
 * Initialize an Equilateral Triangle object. Default constructor values
 * creates an equilateral triangle with all dimensions set to 0.
 */
public class EquilateralTriangle extends Triangle {
    public final boolean isNormal = true;

    public EquilateralTriangle() {
        super();
        super.setBase(0);
        super.setHeight(0);
    }

    public EquilateralTriangle(double base) {
        super();
        super.setBase(base);
        double height = base * (Math.sqrt(3) * 0.5);
        System.out.println(height);
        super.setHeight(height);
    }

    public void setBase(double base) {
        super.setBase(base);
        super.setHeight(base * (Math.sqrt(3) * 0.5));
    }

    public void setHeight(double height) {
        super.setHeight(height);
        super.setBase(height / (Math.sqrt(3) * 0.5));
    }

    // area method covered by Triangle parent class

    public double perimeter() {
        return 3 * super.getBase();
    }
    
}
