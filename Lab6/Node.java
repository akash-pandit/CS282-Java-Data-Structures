public class Node {
    private Contact val;
    private Node next;

    Node(Contact val) {
        this.val = val;
        this.next = null;
    }

    Node(Contact val, Node next) {
        this.val = val;
        this.next = next;
    }

    Contact getContact() {
        return val;
    }

    Node getNext() {
        return this.next;
    }

    void setContact(Contact contact) {
        this.val = contact;
    }

    void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public String toString() {
        return String.format("%s -> %s", val, next);
    }
}
