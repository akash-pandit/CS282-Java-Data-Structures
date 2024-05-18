import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    
    public static void main(String[] args) {
        AddressBook addressBook;

        try {
            ObjectInputStream oInStream = new ObjectInputStream(
                new FileInputStream(
                    new File("AddressBookBinary")
                    )
                );
            addressBook = (AddressBook) oInStream.readObject();
            oInStream.close();
        } catch (FileNotFoundException e) {
            addressBook = new AddressBook();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return;
        } catch (IOException e) {
            System.out.println(e);
            return;
        }

        Contact c1 = new Contact("A", "B", 0, "C");
        Contact c2 = new Contact("D", "E", 0, "F");
        Contact c3 = new Contact("G", "H", 0, "I");
        Contact c4 = new Contact("J", "K", 0, "L");
        Contact c5 = new Contact("M", "N", 0, "O");

        // addressBook.addContact(c1);
        // addressBook.addContact(c2);
        // addressBook.addContact(c3);
        // addressBook.addContact(c4);
        // addressBook.addContact(c5);

        System.out.println(addressBook.findContact(c4));
        
        System.out.println(addressBook);
    }
}
