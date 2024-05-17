public class Contact {
    public String firstName;
    public String lastName;
    public int phoneNumber;
    public String address;

    Contact(String firstName, String lastName, int phoneNumber, String address) {
        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean greaterThan(Contact contact) {
        if (this.lastName.compareTo(contact.lastName) > 0)
            // this lastname greater, should go after contact
            return true;
        
        if (this.lastName.equals(contact.lastName)) {
            // last names match, comparing first names
            if (this.firstName.compareTo(contact.firstName) > 0)
                return true;
        }
        return false;
    }

    public String toString() {
        return String.format("%s, %s (%d)", lastName, firstName, phoneNumber);
    }
}
