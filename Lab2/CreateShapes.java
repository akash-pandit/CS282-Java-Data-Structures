import java.util.Scanner;

public class CreateShapes {
    static Scanner scan = new Scanner(System.in);
    static String shapeType;
    
    public static void main(String[] args) {
        titleBlock("Shape Selector");
        String[] choices = {
            "Create Triangle",
            "Create Quadrilateral",
            "Create Pentagon",
            "Create Hexagon",
            "Create Octagon"
        };
        
        int choice = selectOption(choices);

        // successful shape switch cases follow the pattern:
        // 1. initialize shape
        // 2. set shape parameters
        // 3. calculate results
        switch (choice) {
            case 0:
                println("Bye bye!");
                break;

            case 1:
                selectTriangle();
                break;

            case 2:
                selectQuadrilateral();
                break;

            case 3:
                shapeType = "Pentagon";
                println("===== Build Your " + shapeType + " =====");
                Pentagon pentagon = new Pentagon();

                print("Side length: ");
                side = scan.nextDouble();
                pentagon.setSide(side);

                calcResults(pentagon, shapeType);
                break;

            case 4:
                shapeType = "Hexagon";
                println("===== Build Your " + shapeType + " =====");
                Hexagon hexagon = new Hexagon();

                print("Side length: ");
                side = scan.nextDouble();
                hexagon.setSide(side);

                calcResults(hexagon, shapeType);
                break;

            case 5:
                shapeType = "Octagon";
                println("===== Build Your " + shapeType + " =====");
                Octagon octagon = new Octagon();

                print("Side length: ");
                side = scan.nextDouble();
                octagon.setSide(side);

                calcResults(octagon, shapeType);
                break;

            default:
                println("Error: Please pick an appropriate integer choice.");
                main(args);
        }
    }

    // ===============================================================
    //                     Utility Methods
    // ===============================================================

    public static void println(String str) {
        System.out.println(str);
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void titleBlock(String str) {
        println("");
        println("     ==" + "=".repeat(str.length()) + "==");
        println("     | " + str + " |");
        println("=======" + "=".repeat(str.length()) + "=======");
    }

    public static int selectOption(String[] options) {
        println("[0] - Quit Program");
        for (int i = 0; i < options.length; i++) {
            println("[" + (i+1) + "] - " + options[i]);
        }
        print("\nEnter your option: ");

        int choice = scan.nextInt();
        return choice;
    }

    public static void calcResults(Polygon shape, String shapeType) {
        titleBlock(shapeType + " Created!");
        println(String.format("Area: %f", shape.area()));
        println(String.format("Perimeter: %f", shape.perimeter()));
    }

    @SuppressWarnings("static-access")
    public static void constructPolygon(Polygon shape, String shapeType) {
        
        println("===== Build Your " + shapeType + " =====");
        if (shape instanceof NormalPolygon) {
            double side;

            print("Side length: ");
            side = scan.nextDouble();
            shape.setSide(side);
        }
    }

    // ===============================================================
    //               Quad/Triangle Submenu Methods
    // ===============================================================

    public static void selectTriangle() {
        titleBlock("Triangle Selector");
        String[] choices = {
            "Create Equilateral Triangle",
            "Create Isosceles Triangle",
            "Return to Main Menu"
        };
        int choice = selectOption(choices);
        double base;
        double height;

        switch (choice) {
            case 0:
                break;
            
            case 1:
                println("===== Build Your Equilateral Triangle =====");
                EquilateralTriangle eqTriangle = new EquilateralTriangle();

                print("Base length: ");
                base = scan.nextDouble();
                eqTriangle.setBase(base);
                

                calcResults(eqTriangle, "Equilateral Triangle");
                break;

            case 2:
                
        }

    }

    private static void selectQuadrilateral() {
        titleBlock("Quadrialteral Selector");
        String[] choices = {
            "Create Square",
            "Create Rectangle",
            "Return to Main Menu"
        };
        int choice = selectOption(choices);
    }
}
