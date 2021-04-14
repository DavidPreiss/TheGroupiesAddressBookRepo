import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class MainRunner
{
    public static void main(String[] args)
    {
        //main start
        System.out.println("\t MAIN START");
        System.out.println("DAVID PREISS CAN CHANGE THIS FILE >:)");
        System.out.println("Louisa is here, too!");
        //BEWARE!!!!
        //added on git branch

        //Pssst! Liz

        /*
        ********************************************************************************
        This is just Steve's test code for the contacts array. I made a small .csv just
        to check that the data was being read. I can alter the method and the Contact class
        to accommodate any formatting changes to the final .csv.

        This makes a File object, reads the data into an ArrayList<Contact>, and prints
        out the list sorted by name, and then by city.
         */
        File csvFile = new File("src/main/resources/steve_test_contacts.csv");
        ArrayList<Contact> contacts = readData(csvFile);
        displayContacts(contacts, 1);
        System.out.println();
        displayContacts(contacts, 2);
        // ******************************************************************************
    }
    //main end


    /**
     * Reads the CSV file and stores the data into an ArrayList of Contact objects.
     * I would think that this method would eventually end up in an address book class
     * but I just put it here for now as it has nowhere else to go!
     *
     * @param csvFile CSV file containing contact data
     * @return an ArrayList of Contacts
     */
    private static ArrayList<Contact> readData(File csvFile)
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
            System.out.println("Invalid file");
            e.printStackTrace();
        }

        // Sort the list alphabetically after loading
        contactList.sort(new CompareByFirstThenLastName());
        return contactList;
    }


    /**
     * Displays all contacts in a poorly and hastily created format.
     * I would think that this will also be moved to an address book class.
     * It's just here temporarily.
     * Second argument is the sort method. See below.
     *
     * @param contactList List of contacts to display.
     * @param sortMethod  Integer representing sort criteria. Not much to choose from
     *                    for now. 1 = Alphabetical by first, then last name
     *                    2 = Alphabetical by city
     */
    private static void displayContacts(ArrayList<Contact> contactList, int sortMethod)
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
            contact.printAllFieldsInRow();
        }
    }
}
