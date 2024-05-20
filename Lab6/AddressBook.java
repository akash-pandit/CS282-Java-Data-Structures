import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AddressBook implements AddressBookInterface, Serializable {
    Node PersonContainer;
    int CurrentPosition;


    public AddressBook() {
        PersonContainer = null;
        CurrentPosition = 0;
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
            CurrentPosition = 1;
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
            // System.out.printf("[LOG] swapping contacts\n");
            // System.out.printf("[LOG] pre swap: node: %s", node);
            node.setContact(nextContact);
            node.getNext().setContact(contact);
            // System.out.printf("[LOG] post swap: node: %s", node);
            node = node.getNext();
            // System.out.println(node);
            if (node.getNext() == null)
                break;
            contact = node.getContact();
            nextContact = node.getNext().getContact();
        }
        // Save changes to address book in a file
        writeToBinary();
    }  // end addContact


    public void deleteContact(Contact contact) {
        if (PersonContainer == null) {
            System.out.println("Error while removing: address book is empty.");
            return;
        }

        Node node = PersonContainer;
        boolean listLen1 = node.getNext() == null;
        
        // only 1 node & its a duplicate
        // log(node.toString());
        // log(node.getContact().getName());
        // log(((Boolean) node.getContact().isDuplicate(contact)).toString());
        if (node.getContact().isDuplicate(contact)) {
            PersonContainer = PersonContainer.getNext();
            CurrentPosition = 1;
            if (listLen1)
                CurrentPosition = 0;
            System.out.printf("Removed contact %s.\n", contact);
            writeToBinary();
            return;
        }

        Contact nextContact;
        // while node points to the next node:
        while (node.getNext() != null) {
            // node -> node -> ...
            // cur     nxt
            nextContact = node.getNext().getContact();
            // System.out.println(nextContact.getName() + " vs " + contact.getName());

            if (nextContact.isDuplicate(contact)) {
                if (findContact(nextContact.getName()) == CurrentPosition) {
                    System.out.println("Removing the current contact, current position resetting.");
                    CurrentPosition = 1;
                }
                node.setNext(node.getNext().getNext()); // node -> ...
                writeToBinary(); // save changes

                System.out.printf("Removed contact %s.\n", contact);
            }
            // log(node.toString());
            node = node.getNext();
            if (node == null) {
                System.out.println("Contact could not be deleted: does not exist.");
                break;
            }
        }
        if (PersonContainer == null)
            CurrentPosition = 0;
    }


    public int findContact(String name) {
        if (CurrentPosition == 0)
            return 0;

        Node node = PersonContainer;
        int iterPos = 1;
        while (node != null) {
            String contactName = node.getContact().getName();
            // System.out.printf("[LOG] findContact: name %s vs contactName %s\n", name, contactName);
            if (name.equalsIgnoreCase(contactName))
                return iterPos;

            iterPos++;
            node = node.getNext();
        }
        return 0; // not found
    }


    public void getCurrent() {
        Contact contact = returnCurrent();
        if (contact != null)
            System.out.println(contact.printFull());
    }

    
    public Contact returnCurrent() {
        // handle empty linked list
        if (CurrentPosition == 0) {
            System.err.println("Error: There is no current contact as the address book is empty.");
            return null;
        }

        Node node = PersonContainer;

        // traverse to current node
        for (int i = 1; i < CurrentPosition; i++) {
            node = node.getNext();
        }
        return node.getContact();
    }


    public void makeEmpty() {
        if (PersonContainer == null) {
            System.err.println("Address book is already empty.");
            if (CurrentPosition != 0) {
                System.err.printf("Error: CurrentPosition is %d instead of 0\n", CurrentPosition);
            }
            return;
        }
        PersonContainer = null;
        CurrentPosition = 0;
        System.out.println("Address book has been emptied.");
        writeToBinary();
    }


    public void writeToBinary() {
        try {
            ObjectOutputStream oOutStream = new ObjectOutputStream(
                new FileOutputStream("AddressBookBinary")
            );
            oOutStream.writeObject(this);
            // System.out.println("Wrote file to binary");
            oOutStream.close();
        } catch (IOException e) {
            System.err.println(e);
            System.out.println("Failed to save change to address book");
        } 
    }


    public void print() {
        Node node = PersonContainer;
        int currentPos = 1;
        
        System.out.println("- = [ Address Book ] = -");
        if (node == null)
            System.out.println("(Empty Address Book)");

        while (node != null) {
            if (currentPos == CurrentPosition) {
                System.out.print("-> ");
            } else
                System.out.print("   ");
            System.out.println(node.getContact().getName());
            currentPos++;
            node = node.getNext();
        }
    }


    private void log(String message) {
        System.out.println("[LOG] " + message);
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
