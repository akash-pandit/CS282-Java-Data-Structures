public class AddressBook {
    public static void main(String[] args) {
        Contact c1 = new Contact("A", "B", 0, "C");
        Contact c2 = new Contact("D", "E", 0, "F");
        ListNode llist = new ListNode(c1, new ListNode(c2));

        llist.swapNext();

        System.out.println(llist);
    }
}