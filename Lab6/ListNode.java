public class ListNode {
    private Contact val;
    private ListNode next;

    ListNode(Contact val) {
        this.val = val;
        this.next = null;
    }

    ListNode(Contact val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void swapNext() {
        if (!(this.next instanceof ListNode)) {
            System.out.printf("%s %s", this, this.next);
            return;
        }
        System.out.printf("this %s\n", this);
        ListNode temp = this.next;
        System.out.printf("this.next & temp %s\n", this.next);
        this.next = this.next.next;
        System.out.printf("this.next & temp %s %s\n", this.next, temp);
        temp.next = this;
        System.out.printf("temp & this %s %s\n", temp, this);
    }

    public String toString() {
        return String.format("%s -> %s", val, next);
    }
}
