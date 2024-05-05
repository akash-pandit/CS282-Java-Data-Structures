public class Contact {
    public String firstName;
    public String lastName;
    public int phoneNumber;
    public String address;

    Contact(String firstName, String lastName, int phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String toString() {
        return firstName;
    }
}
