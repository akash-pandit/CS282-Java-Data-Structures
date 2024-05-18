import java.io.Serializable;

public class Node implements Serializable {
    private Contact val;
    private int pos;
    private Node next;

    Node(Contact val) {
        this.val = val;
        this.pos = 0;
        this.next = null;
    }

    Node(Contact val, Node next) {
        this.val = val;
        this.pos = 0;
        this.next = next;
        this.next.setPos(pos);
    }

    int getPos() {
        return pos;
    }

    void setPos(int pos) {
        this.pos = pos;
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
        if (next != null)
            return String.format("%s\n%s", val, next);
        return String.format("%s\n", val);
    }
}
