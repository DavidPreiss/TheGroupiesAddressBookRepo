/**
 * Represents one contact in an address book.
 */
public class Contact
{
    // Fields for a contact
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String phoneNumber;
    private String email;
    private String streetName;
    private String streetNumber;
    private String city;
    private String zipCode;

    // Constructor for creating new contact with the minimum required data
    public Contact(String firstName, String lastName, String mobileNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }

    /*
    This constructor is intended to be used for creating Contact objects
    when reading the data from the .csv file. It takes an array of all
    fields in a Contact in the order listed.
     */
    public Contact(String[] fields)
    {
        this.firstName = fields[0];
        this.lastName = fields[1];
        this.mobileNumber = fields[2];
        this.phoneNumber = fields[3];
        this.email = fields[4];
        this.streetName = fields[5];
        this.streetNumber = fields[6];
        this.city = fields[7];
        this.zipCode = fields[8];
    }

    // Getters and setters
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public String getStreetNumber()
    {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
    // End Getters and Setters


    @Override
    public String toString()
    {
        String fullName = firstName + " " + lastName;
        String fullAddress = streetNumber + " " + streetName;
        return String.format("%-21s | %-10s | %-10s | %-20s | %-20s | %-15s | %-10s\n", fullName, mobileNumber, phoneNumber, email,
                      fullAddress, city, zipCode);
    }

    /**
     * Prints all data for a contact in a single row to the terminal
     */
    public void printAllFieldsInRow()
    {
        String fullName = firstName + " " + lastName;
        String fullAddress = streetNumber + " " + streetName;
        System.out.printf("%-21s | %-10s | %-10s | %-20s | %-20s | %-15s | %-10s", fullName, mobileNumber, phoneNumber, email,
                          fullAddress, city, zipCode);
    }
} // end class
