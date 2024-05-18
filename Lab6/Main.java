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

        Contact c1 = new Contact(
            "Akash",
            "Pandit",
            8582828788L,
            "wahoo"
            );
        addressBook.addContact(c1);
            
        Contact c2 = new Contact(
            "Alex",
            "Beloiu",
            0,
            "wahoo2"
            );
        addressBook.addContact(c2);
        
        System.out.println(addressBook);
    }
}
