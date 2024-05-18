import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AddressBook implements Serializable {
    private Node PersonContainer;
    // private int CurrentPosition;


    public AddressBook() {
        PersonContainer = null;
    }


    public AddressBook(Node head) {
        this.PersonContainer = head;
    }
    
    private boolean checkForDupes(Contact contact) {
        if (PersonContainer == null)
            return false;
        
        Node node = PersonContainer;
        while (node != null) {
            if (node.getContact().isDuplicate(contact))
                return true;
            node = node.getNext();
        }
        return false;
    }

    public void addContact(Contact contact) {
        Node node = new Node(contact);
        
        // handle empty book
        if (PersonContainer == null) {
            PersonContainer = node;
            return;
        }

        Contact nextContact = PersonContainer.getContact();

        // Check for duplicates
        if (checkForDupes(contact)) {
            System.out.println("Contact " + contact + " is a duplicate.");
            return;
        }

        node.setNext(PersonContainer);
        PersonContainer = node;
        
        
        // Sort new addition into contact
        while (contact.greaterThan(nextContact)) {
            if (node.getNext() == null)
                break;
            contact = node.getContact();
            nextContact = node.getNext().getContact();

            node.setContact(nextContact);
            node.getNext().setContact(contact);

            node = node.getNext();
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


    public void deleteContact(Contact contact) {
        if (PersonContainer == null) {
            System.out.println("Error while removing: address book is empty.");
            return;
        }

        Node node = PersonContainer;

        if (PersonContainer.getContact().isDuplicate(contact)) {
            PersonContainer = PersonContainer.getNext();
            System.out.println(String.format("Removed contact %s.", contact));

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
                return;
            }
        }

        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getContact().isDuplicate(contact)) {
                System.out.println(String.format("Removed contact %s.", contact));

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
                    return;
                }
            }
        }
    }


    public int findContact(Contact contact) {
        int contactInd = 0;
        Node node = PersonContainer;

        if (node == null)
            return -1;
        
        while (node != null) {
            if (contact.isDuplicate(node.getContact())) {
                return contactInd;
            }
            contactInd++;
            node = node.getNext();
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
