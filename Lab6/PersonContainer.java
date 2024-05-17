public class PersonContainer {
    private Node head;

    public PersonContainer() {
        head = null;
    }

    public PersonContainer(Node node) {
        head = node;
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        if (node.getNext() != null) {
            System.out.println("ERROR: Please add only 1 contact at a time.");
            return;
        }

        node.setNext(head);
        // System.out.println(node);
        head = node;

        Contact contact = node.getContact();
        Contact nextContact = node.getNext().getContact();

        while (contact.greaterThan(nextContact)) {
            node.setContact(nextContact);
            node.getNext().setContact(contact);

            node = node.getNext();
            if (node.getNext() == null)
                return;
            contact = node.getContact();
            nextContact = node.getNext().getContact();
        }
    }

    public String toString() {
        return head.toString();
    }
}
