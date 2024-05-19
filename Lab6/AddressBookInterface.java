public interface AddressBookInterface {
    /**
     * add a contact to the address book.
     * The contact will be autosorted into the address book
     * @param contact the contact to add
     */
    public void addContact(Contact contact);

    public void deleteContact(Contact contact);

    public int findContact(String name);

    public void getCurrent();

    public void makeEmpty();
}
