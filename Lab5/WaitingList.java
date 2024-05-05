import java.util.InputMismatchException;
import java.util.Scanner;

public class WaitingList {
    static PersonQueue queue = new PersonQueue();
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int menuChoice;

        do {
            menuChoice = displayMenu();
            Person nextPerson;

            switch (menuChoice) {
                case 1:
                    nextPerson = getPerson();
                    System.out.printf("Added %s to the line.\n", nextPerson.toString());
                    queue.add(nextPerson);
                    break;
                case 2:
                    if (queue.getLength() == 0) {
                        System.out.println("The line is empty, there is no one to serve.");
                        break;
                    }
                    nextPerson = queue.view();
                    System.out.printf("The next person in line is %s.\n", nextPerson.toString());
                    break;
                case 3:
                    if (queue.getLength() == 0) {
                        System.out.println("The line is empty, there is no one to serve.");
                        break;
                    }
                    nextPerson = queue.pop();
                    System.out.printf("Now serving %s.\n", nextPerson.toString());
                    
                    break;
                case 4:
                    System.out.println("Exiting the DMV...");
                    break;
                default:
                    System.out.println("Error: Please select a valid menu option.");
                    break;
            }
        } while (menuChoice != 4);
        scan.close();
    }

    static int displayMenu() {
        System.out.println("" + 
        "============ DMV Line ============\n" +
        "1 - Add a person to the line\n" +
        "2 - View the next person in line\n" +
        "3 - Assist the next person in line\n" +
        "4 - Exit\n" + 
        "==================================");
        int choice;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            return 4;
        }

        while (choice > 4 || choice < 1) {
            System.out.println("Error: Please select a valid menu option.");
            choice = scan.nextInt();
        }
        return choice;        
    }

    static Person getPerson() {
        String firstName, lastName;
        scan.nextLine();

        System.out.print("First name: ");
        firstName = scan.nextLine();
        System.out.print("Last name: ");
        lastName = scan.nextLine();

        return new Person(firstName, lastName);        
    }
}

