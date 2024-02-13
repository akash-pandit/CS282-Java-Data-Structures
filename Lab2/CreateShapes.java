import java.util.Scanner;

public class CreateShapes {
    static Scanner scan = new Scanner(System.in);
    static String shapeTypeName;
    
    public static void main(String[] args) {
        boolean runProgram = selectPolygon();

        while (runProgram) {
            runProgram = selectPolygon();
        }
    }  // end main


    // ===============================================================
    //                     Utility Methods
    // ===============================================================


    public static void println(String str) {
        System.out.println(str);
    }


    public static void print(String str) {
        System.out.print(str);
    }  // end print


    public static void titleBlock(String str) {
        println("");
        println("     ==" + "=".repeat(str.length()) + "==");
        println("     | " + str + " |");
        println("=======" + "=".repeat(str.length()) + "=======");
    }  // end titleBlock


    // formatting method for menu options
    public static int selectOption(String[] options) {
        println("[0] - Quit Program");
        for (int i = 0; i < options.length; i++) {
            println("[" + (i+1) + "] - " + options[i]);
        }
        print("\nEnter your option: ");

        while (!scan.hasNextInt()) {
            println("Please pick one of the above choices by its number.");
            print("Enter your option: ");
            scan.next();
        }
        return scan.nextInt();  // choice
    }  // end selectOption


    public static void calcResults(Polygon shape, String shapeTypeName) {
        titleBlock(shapeTypeName + " Created!");
        println(String.format("Area: %f", shape.area()));
        println(String.format("Perimeter: %f", shape.perimeter()));
    }  // end calcResults


    static double scanDouble(Scanner scan) {
        while (!scan.hasNextDouble()) {
            print("Please input a valid number: ");
            scan.next();
            println("");
        }
        return scan.nextDouble();
    } 


    // ===============================================================
    //               Menu Display Methods
    // ===============================================================

    
    static boolean selectPolygon() {
        titleBlock("Shape Selector");
        String[] choices = {
            "Create Triangle",
            "Create Quadrilateral",
            "Create Pentagon",
            "Create Hexagon",
            "Create Octagon"
        };
        
        int choice = selectOption(choices);
        double side;

        // successful shape switch cases follow the pattern:
        // 1. initialize shape
        // 2. set shape parameters
        // 3. calculate results
        switch (choice) {
            case 0:
                println("Bye bye!");
                return false;

            case 1:
                selectTriangle();
                return true;

            case 2:
                selectQuadrilateral();
                return true;

            case 3:
                shapeTypeName = "Pentagon";
                println("===== Build Your " + shapeTypeName + " =====");
                Pentagon pentagon = new Pentagon();

                print("Side length: ");
                side = scanDouble(scan);
                pentagon.setSide(side);

                calcResults(pentagon, shapeTypeName);
                return true;

            case 4:
                shapeTypeName = "Hexagon";
                println("===== Build Your " + shapeTypeName + " =====");
                Hexagon hexagon = new Hexagon();

                print("Side length: ");
                side = scanDouble(scan);
                hexagon.setSide(side);

                calcResults(hexagon, shapeTypeName);
                return true;

            case 5:
                shapeTypeName = "Octagon";
                println("===== Build Your " + shapeTypeName + " =====");
                Octagon octagon = new Octagon();

                print("Side length: ");
                side = scanDouble(scan);
                octagon.setSide(side);

                calcResults(octagon, shapeTypeName);
                return true;

            default:
                println("Error: Please pick one of the above choices by its number.");
                return true;
        }  // end switch
    }  // end selectPolygon


    static void selectTriangle() {
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

                print("Side length: ");
                base = scanDouble(scan);
                eqTriangle.setBase(base);
                
                calcResults(eqTriangle, "Equilateral Triangle");
                break;

            case 2:
                println("===== Build Your Equilateral Triangle =====");
                IsoscelesTriangle isosTriangle = new IsoscelesTriangle();

                print("Base length: ");
                base = scanDouble(scan);
                isosTriangle.setBase(base);

                print("Triangle height: ");
                height = scanDouble(scan);
                isosTriangle.setHeight(height);

                calcResults(isosTriangle, "Isosceles Triangle");
                break;

            case 3:
                selectPolygon();
                break;

            default:
                println("Error: Please pick one of the above choices by its number.");
                break;
        }  // end switch
    }  // end selectTriangle 


    static void selectQuadrilateral() {
        titleBlock("Quadrialteral Selector");
        String[] choices = {
            "Create Square",
            "Create Rectangle",
            "Return to Main Menu"
        };
        int choice = selectOption(choices);
        double base;
        double height;

        switch (choice) {
            case 0:
                break;

            case 1:
                println("===== Build Your Square =====");
                Square square = new Square();

                print("Side length: ");
                base = scanDouble(scan);
                square.setBase(base);

                calcResults(square, "Square");
                break;

            case 2:
                println("===== Build Your Rectangle =====");
                Rectangle rect = new Rectangle();

                print("Base length: ");
                base = scanDouble(scan);
                rect.setBase(base);

                print("Rectangle Height: ");
                height = scanDouble(scan);
                rect.setHeight(height);

                calcResults(rect, "Rectangle");
                break;

            case 3:
                selectPolygon();
                break;

            default:
                println("Error: Please pick one of the above choices by its number.");
                break;
        }  // end switch
    }  // end selectQuadrilateral


}  // end file
