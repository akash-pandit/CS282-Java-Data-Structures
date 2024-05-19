import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static AddressBook addressBook = new AddressBook();
    public static void main(String[] args) {
        if (!loadAddressBook())
            return;

        int menuChoice;

        do {
            displayMenu();
            menuChoice = scan.nextInt();
            scan.nextLine();

            switch (menuChoice) {
                case 1:
                    addressBook.addContact(createContact());
                    System.out.println(addressBook.CurrentPosition);
                    System.out.println("Alert: current position has been reset.");
                    break;
                case 2:
                    findContact();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    if (addressBook.PersonContainer == null) {
                        System.err.println("Error: cannot delete a contact from an empty address book.");
                        break;
                    }
                    addressBook.deleteContact(createContact());
                    break;
                case 5:
                    addressBook.getCurrent();
                    break;
                case 6:
                    addressBook.print();
                    break;
                case 7:
                    addressBook.makeEmpty();
                    break;
                case 8:
                    break;
                default:
                    System.err.println("Error: please provide a valid menu option.");
                    break;
            }
        } while (menuChoice != 8);
        System.out.println("Exiting...");
    }


    public static void displayMenu() {
        System.out.println("" + 
        "============ [ Address Book ] ============\n" +
        "1 - Add a contact\n" +
        "2 - Find a contact\n" +
        "3 - Edit a contact\n" +
        "4 - Delete a contact\n" +
        "5 - Display the current contact\n" +
        "6 - Print the entire address book\n" +
        "7 - Empty the address book\n" +
        "8 - Exit\n" +
        "==========================================");
    }


    public static boolean loadAddressBook() {
        try {
            ObjectInputStream oInStream = new ObjectInputStream(
                new FileInputStream(
                    new File("AddressBookBinary")
                    )
                );
            addressBook = (AddressBook) oInStream.readObject();
            oInStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("No address book found, creating new address book...");
            addressBook = new AddressBook();
            addressBook.writeToBinary();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }  catch (InvalidClassException e) {
            System.err.println(e);
            System.err.println("Error reading from the binary, initializing new address book...");
            addressBook = new AddressBook();
            addressBook.writeToBinary();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }


    public static void findContact() {
        if (addressBook.CurrentPosition == 0) {
            System.err.println("Error: cannot find a contact in an empty address book.");
            return;
        }
        
        System.out.print("Enter the name of the contact you wish to find (first last): ");
        String name = scan.nextLine();

        int contactPos = addressBook.findContact(name);
        if (contactPos == 0) {
            System.err.println("Could not find a \"" + name + "\" (case insensitive) in your contacts.");
            return;
        }

        addressBook.CurrentPosition = contactPos;
        System.out.printf("Contact for \"" + name + "\" found at position %d, setting current position...\n", contactPos);
    }


    public static void editContact() {
        
        if (addressBook.CurrentPosition == 0) {
            System.err.println("Error: a contact is not selected.");
            return;
        }
        System.out.println("Re-enter each contact field's values as you would like.");
        addressBook.deleteContact(addressBook.returnCurrent());
        addressBook.addContact(createContact());
    }


    public static Contact createContact() {
        String fn, ln, address;
        long phoneNumber = 0;

        System.out.print("First name: ");
        fn = scan.nextLine();
        while (fn == "") {
            System.err.println("Error: please provide a valid (len > 0) first name.");
            System.out.print("First name: ");
            fn = scan.nextLine();
        }

        System.out.print("Last name: ");
        ln = scan.nextLine();
        while (ln == "") {
            System.err.println("Error: please provide a valid (len > 0) last name.");
            System.out.print("Last name: ");
            ln = scan.nextLine();
        }

        while (phoneNumber == 0) {
            try {
                System.out.print("Phone number: ");
                phoneNumber = scan.nextLong();
            } catch (InputMismatchException e) {
                System.err.println("Error: please provide a valid phone number.");
                scan.nextLine();
                phoneNumber = 0;
            }
        }
        scan.nextLine(); // clear scan cache/buffer/???

        System.out.print("Address: ");
        address = scan.nextLine();
        while (address == "") {
            System.err.println("Error: please provide a valid address.");
            address = scan.nextLine();
        }

        return new Contact(fn, ln, phoneNumber, address);
    }
}
