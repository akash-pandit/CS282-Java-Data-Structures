import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AddressBook implements Serializable {
    private Node PersonContainer;
    private int CurrentPosition;

    public AddressBook() {
        PersonContainer = null;
    }

    public AddressBook(Node head) {
        this.PersonContainer = head;
    }
    
    public void addContact(Contact contact) {
        Node node = new Node(contact);
        
        // handle empty book
        if (PersonContainer == null) {
            PersonContainer = node;
            return;
        }

        node.setNext(PersonContainer);
        PersonContainer = node;
        Contact nextContact = node.getNext().getContact();

        // Check for duplicates
        if (contact.equals(nextContact)) {
            System.out.println("Contact is already present.");
            return;
        }
        
        // Sort new addition into contact
        while (contact.greaterThan(nextContact)) {
            node.setContact(nextContact);
            node.getNext().setContact(contact);

            node = node.getNext();
            if (node.getNext() == null)
                return;
            contact = node.getContact();
            nextContact = node.getNext().getContact();
        }
        
        // Save changes to addressbook in a file
        try {
            ObjectOutputStream oOutStream = new ObjectOutputStream(
                new FileOutputStream("AddressBookBinary")
            );
            oOutStream.writeObject(this);
            System.out.println("Wrote file to binary");
            oOutStream.close();
        } catch (IOException e) {
            System.err.println(e);
            System.out.println("Failed to save change to address book");
        }
    }  // end addContact

    public int removeContact(Contact contact) {
        if (PersonContainer == null) {
            System.out.println("Error while removing: address book is empty.");
            return -1;
        }

        Node node = PersonContainer;
        if (PersonContainer.getContact().equals(contact)) {
            PersonContainer = PersonContainer.getNext();
            System.out.println(String.format("Removed contact %s.", contact));
            return 0;
        }
        while (node.getNext() != null) {
            node = node.getNext();
            CurrentPosition++;
            if (node.getContact().equals(contact))
                System.out.println(String.format("Removed contact %s.", contact));
                return CurrentPosition;
        }
        return -1;
    }

    public String toString() {
        Node node = PersonContainer;
        if (node == null)
            return null;

        while (node.getNext() != null) {
            node = node.getNext();
        }
        return PersonContainer.toString();
    }
}
