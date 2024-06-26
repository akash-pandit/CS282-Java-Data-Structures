import java.io.Serializable;

public class Contact implements Serializable {
    public String firstName;
    public String lastName;
    public long phoneNumber;
    public String address;

    Contact(String firstName, String lastName, long phoneNumber, String address) {
        if (firstName.equals(""))
            this.firstName = "none";
        if (lastName.equals(""))
            this.lastName = "none";

        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean greaterThan(Contact contact) {
        // System.out.printf("greater than? %s vs %s: %b\n", this.lastName, contact.lastName, this.lastName.compareTo(contact.lastName) > 0);
        return this.lastName.compareTo(contact.lastName) > 0;
    }

    public boolean isDuplicate(Contact contact) {
        return this.lastName.equals(contact.lastName) && 
        this.firstName.equals(contact.firstName) &&
        this.phoneNumber == contact.phoneNumber &&
        this.address.equals(contact.address);
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String printFull() {
        String fn = this.firstName;
        String ln = this.lastName;

        fn = fn.substring(0, 1).toUpperCase() + fn.substring(1);
        ln = ln.substring(0, 1).toUpperCase() + ln.substring(1);

        return "- = [ Current Contact ] = -" +
        "\n    Name: " + fn + " " + ln +
        "\n    Address: " + this.address +
        "\n    Phone Number: " + this.phoneNumber + 
        "\n - = [ = - = <> = - = ] = -";
    }

    public String toString() {
        return String.format("%s, %s (%d)", lastName, firstName, phoneNumber);
    }
}
