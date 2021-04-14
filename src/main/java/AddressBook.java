import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Represents an address book
 */
public class AddressBook
{
    private ArrayList<Contact> contactList;

    /*
    Constructor
     */
    public AddressBook(File contactCsv)
    {
        this.contactList = readData(contactCsv);
    }



    /**
     * Reads the CSV file and stores the data into an ArrayList of Contact objects.
     * I would think that this method would eventually end up in an address book class
     * but I just put it here for now as it has nowhere else to go!
     *
     * @param csvFile CSV file containing contact data
     * @return an ArrayList of Contacts
     */
    private ArrayList<Contact> readData(File csvFile)
    {
        // ArrayList for Contacts
        ArrayList<Contact> contactList = new ArrayList<>();

        try
        {
            Scanner scanner = new Scanner(csvFile);
            scanner.nextLine(); // Discard the header row

            /*
            Read row, split on comma, create new Contact
            and add to the ArrayList
             */
            while (scanner.hasNextLine())
            {
                String entry = scanner.nextLine();
                String[] entryFields = entry.split(",");
                // If a row is not formed correctly or blank, skip the line
                if (entryFields.length != 9)
                {
                    continue;
                }
                contactList.add(new Contact(entryFields));
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

        // Sort the list alphabetically after loading
        contactList.sort(new CompareByFirstThenLastName());
        return contactList;
    }

/*
SEARCHING METHODS***************************************************
 */
    /**
     * Searches the contactList for matching first names and returns
     * all Contacts with that first name. Ignores case.
     * @param firstName name to search for
     * @return list of matching contacts or an empty array if no contacts are found
     */
    public ArrayList<Contact> searchByFirstName(String firstName)
    {
        // List to store matches
        ArrayList<Contact> matchingContacts = new ArrayList<>();

        // Search the list
        Iterator<Contact> iterator = contactList.listIterator();
        while (iterator.hasNext())
        {
            Contact next = iterator.next();
            if (next.getFirstName().trim().equalsIgnoreCase(firstName.trim()))
            {
                matchingContacts.add(next);
            }
        }
        return matchingContacts;
    }

    /**
     * Searches the contactList for matching last names and returns
     * all Contacts with that first name. Ignores case.
     * @param lastName name to search for
     * @return list of matching contacts or an empty array if no contacts are found
     */
    public ArrayList<Contact> searchByLastName(String lastName)
    {
        // List to store matches
        ArrayList<Contact> matchingContacts = new ArrayList<>();

        // Search the list
        Iterator<Contact> iterator = contactList.listIterator();
        while (iterator.hasNext())
        {
            Contact next = iterator.next();
            if (next.getLastName().trim().equalsIgnoreCase(lastName.trim()))
            {

                matchingContacts.add(next);
            }
        }
        return matchingContacts;
    }

    /**
     * Searches the contactList for Contacts matching the given
     * mobile number.
     * @param mobile number to search for
     * @return ListArray of matching Contacts or empty array if none are found.
     */
    public ArrayList<Contact> searchByMobile(String mobile)
    {
        ArrayList<Contact> matchingContacts = new ArrayList<>();

        Iterator<Contact> iterator = contactList.listIterator();
        while (iterator.hasNext())
        {
            Contact next = iterator.next();
            if (next.getMobileNumber().trim().equals(mobile.trim()))
            {
                matchingContacts.add(next);
            }
        }
        return matchingContacts;
    }


    /**
     * Searches the contactList for Contacts matching the given
     * full name. Case is ignored
     * @param fullName first and last name to search for
     * @return ListArray of matching Contacts or empty array if none are found.
     */
    public ArrayList<Contact> searchByFullName(String fullName)
    {
        // Split name
        String trimmedName = fullName.trim();
        int splitPoint = trimmedName.indexOf(' ');
        String firstName = trimmedName.substring(0, splitPoint);
        String lastName = trimmedName.substring(splitPoint + 1);

        ArrayList<Contact> matchingContacts = new ArrayList<>();

        Iterator<Contact> iterator = contactList.listIterator();
        while (iterator.hasNext())
        {
            Contact next = iterator.next();
            if (next.getFirstName().trim().equalsIgnoreCase(firstName.trim()) && next.getLastName().trim().equalsIgnoreCase(lastName.trim()))
            {
                matchingContacts.add(next);
            }
        }
        return matchingContacts;
    }





    /**
     * Displays all contacts in a poorly and hastily created format.
     * I would think that this will also be moved to an address book class.
     * It's just here temporarily.
     * Second argument is the sort method. See below.
     *
     * @param sortMethod  Integer representing sort criteria. Not much to choose from
     *                    for now. 1 = Alphabetical by first, then last name
     *                    2 = Alphabetical by city
     */
    public void displayContacts(int sortMethod)
    {
        // Determine sorting
        Comparator<Contact> comparator;
        switch (sortMethod)
        {
            case 1:
                comparator = new CompareByFirstThenLastName();
                break;
            case 2:
                comparator = new CompareByCity();
                break;
            default:
                comparator = new CompareByFirstThenLastName();
        }

        // Sort list
        contactList.sort(comparator);

        // Display the data
        Iterator<Contact> iterator = contactList.iterator();
        System.out.println("Name                  |   Mobile   |   Phone    |        email         |" +
                           " Street Address       |     City        |   Zip Code");
        System.out.println("------------------------------------------------------------------------" +
                           "----------------------------------------------------");
        while (iterator.hasNext())
        {
            Contact contact = iterator.next();
            System.out.println(contact.toString());
        }
    }
}
