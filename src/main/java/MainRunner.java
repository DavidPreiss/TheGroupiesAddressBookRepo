import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class MainRunner
{

    public static Contact searchByName(String input)
    {
        System.out.println("Not yet implemented!\n"+input);
        Contact VoidLord = new Contact("Void","Lord","6666666666");
        return VoidLord;
    }
    public static Contact searchByMobile(String input)
    {
        System.out.println("Not yet implemented!\n"+input);
        Contact VoidLord = new Contact("Void","Lord","6666666666");
        return VoidLord;
    }
    public static void main(String[] args)
    {
        //main start
        System.out.println("\t MAIN START");
        Scanner scanner = new Scanner(System.in);
        boolean repeat1 = true;
        while (repeat1)
        {

            System.out.println("Hello welcome to the address book!");
            System.out.println("(A)dd - (P)rint - (S)earch - (E)xit");

            String userInput = scanner.nextLine().toLowerCase();
            if (userInput.equals(""))userInput = " ";
            char usrInChar = userInput.charAt(0);
            System.out.println("userInput: "+userInput);
            switch (usrInChar)
            {

                case 'e': //exit
                {
                    repeat1 = false;
                    System.out.println("Goodbye!");
                    break;
                }

                case 'a': //add new contact
                {

                    System.out.println("Add not yet implemented!");
                    break;
                }
                case 'r': //remove contact
                {

                    System.out.println("Remove not yet implemented!");
                    break;
                }
                case 'p': //print all contacts
                {

                    System.out.println("Print All not yet implemented!");
                    break;
                }
                case 's': //search for specific contact
                {

                    //System.out.println("Search not yet implemented!");
                    boolean repeat2 = true;
                    boolean haveContact = false;
                    Contact MyContact = new Contact("Default","Contact","1112223333");
                    while (repeat2)
                    {
                        System.out.println("Search by (P)hone or (N)ame? (E)xit");
                        String userOrder = scanner.nextLine().toLowerCase();
                        if (userOrder.equals(""))userOrder = " ";
                        char orderChar = userOrder.charAt(0);
                        switch (orderChar)
                        {
                            case 'e': //exit
                            {
                                repeat2 = false;
                                haveContact = false;
                                System.out.println("Returning to Main Menu!");
                                break;
                            }

                            case 'p':
                            {

                                    System.out.println("input Mobile number");
                                    String mobileString = scanner.nextLine().toLowerCase();
                                    MyContact = searchByMobile(mobileString);
                                    haveContact = true;
                                break;
                            }
                            case 'n':
                            {
                                System.out.println("input Name");
                                String nameString = scanner.nextLine().toLowerCase();
                                MyContact = searchByName(nameString);
                                haveContact = true;
                                break;
                            }
                            default:
                            {
                                System.out.println("invalid input");
                                break;
                            }
                        }
                        if(haveContact)
                        {

                            boolean repeat3 = true;
                            while (repeat3)
                            {
                                System.out.println("Contact info: ");
                                MyContact.printAllFieldsInRow();
                                System.out.println("\n (C)hange - (D)elete - (E)xit");

                                String userCDE = scanner.nextLine().toLowerCase();
                                if (userCDE.equals(""))userCDE = " ";
                                char cdeChar = userCDE.charAt(0);
                                switch (cdeChar)
                                {

                                    case 'e': //exit
                                    {
                                        repeat3 = false;
                                        System.out.println("Goodbye!");
                                        break;
                                    }

                                    case 'c': //change
                                    {
                                        System.out.println("Change Not yet implemented!\n" +
                                                "replace this print statement with a method call!");
                                        System.out.println("");
                                        break;
                                    }
                                    case 'd': //delete
                                    {
                                        System.out.println("Delete Not yet implemented!\n" +
                                        "replace this print statement with a method call!");

                                        System.out.println("Contact Deleted");
                                        repeat3 = false;
                                        break;
                                    }

                                    default:
                                    {
                                        System.out.println("invalid input");
                                        break;
                                    }
                                }
                            }

                        }
                    }

                    break;
                }
                default:
                {
                    System.out.println("invalid input");
                    break;
                }


            }
        }


        /*
        ********************************************************************************
        This is just Steve's test code for the contacts array. I made a small .csv just
        to check that the data was being read. I can alter the method and the Contact class
        to accommodate any formatting changes to the final .csv.

        This makes a File object, reads the data into an ArrayList<Contact>, and prints
        out the list sorted by name, and then by city.
         */
        /*
        File csvFile = new File("src/main/resources/steve_test_contacts.csv");
        ArrayList<Contact> contacts = readData(csvFile);
        displayContacts(contacts, 1);
        System.out.println();
        displayContacts(contacts, 2);

         */
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
            System.out.println("File not found");
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
            System.out.println(contact.toString());
        }
    }
}
