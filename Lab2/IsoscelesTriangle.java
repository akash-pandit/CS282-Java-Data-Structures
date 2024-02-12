public class IsoscelesTriangle extends Triangle {
    public final boolean isNormal = false;

    public IsoscelesTriangle() {
        super();
        setBase(0);
        setHeight(0);
    }

    public IsoscelesTriangle(double base, double height) {
        super();
        setBase(base);
        setHeight(height);
    }

    public void setBase(double base) {
        super.base = base;
    }

    public void setHeight(double height) {
        super.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double perimeter() {
        // pythagorean theorem
        double sideLen = Math.sqrt(Math.pow(getBase() / 2, 2) + Math.pow(getHeight(), 2));
        return getBase() + (2 * sideLen);
    }
}
