import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;

import java.util.ArrayList;


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
    public static void addContact(Contact inputContact)
    {

        System.out.println("Add Not Yet Implemented");
    }
    public static void deleteContact(Contact inputContact)
    {

        System.out.println("Delete Not Yet Implemented");
    }
    public static void printEveryContact()
    {
        System.out.println("not yet implemented");
    }
    public static void changeContact(Contact inputContact, Scanner scanner)
    {
        Contact newContact = inputContact;
        //change newContact
        System.out.println("\t Enter new info to change field, enter nothing to keep same");

        System.out.println("Input First Name: ");
        String FirstName = scanner.nextLine();
        if (!FirstName.equals("")) inputContact.setFirstName(FirstName);

        System.out.println("Input Last Name: ");
        String LastName = scanner.nextLine();
        if (!LastName.equals("")) inputContact.setLastName(LastName);

        System.out.println("Input Mobile Number: ");
        String Mobile = scanner.nextLine();
        if (!LastName.equals("")) inputContact.setLastName(LastName);

        System.out.println("Input LandLine Phone Number: ");
        String Landline = scanner.nextLine();
        if (!Landline.equals("")) inputContact.setPhoneNumber(Landline);

        System.out.println("Input Email: ");
        String Email = scanner.nextLine();
        if (!Email.equals("")) inputContact.setEmail(Email);

        System.out.println("Input Street Name: ");
        String StreetName = scanner.nextLine();
        if (!StreetName.equals("")) inputContact.setStreetName(StreetName);

        System.out.println("Input Street Number: ");
        String StreetNum = scanner.nextLine();
        if (!StreetNum.equals("")) inputContact.setStreetNumber(StreetNum);

        System.out.println("Input City: ");
        String City = scanner.nextLine();
        if (!City.equals("")) inputContact.setCity(City);

        System.out.println("Input Zip Code: ");
        String Zip = scanner.nextLine();
        if (!Zip.equals("")) inputContact.setZipCode(Zip);

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
            System.out.println("(A)dd - (P)rint All - (S)earch - (E)xit");

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

                    System.out.println("Input First Name: ");
                    String userFirstName = scanner.nextLine();
                    System.out.println("Input First Name: ");
                    String userLastName = scanner.nextLine();
                    System.out.println("Input Mobile Number: ");
                    String userMobile = scanner.nextLine();
                    Contact userContact = new Contact(userFirstName,userLastName,userMobile);
                    addContact(userContact);
                    System.out.println("contact added");

                    break;
                }
                case 'p': //print all contacts
                {

                    printEveryContact();
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
                                MyContact.toString();
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
                                        changeContact(MyContact, scanner);
                                        System.out.println("Contact Changed");
                                        break;
                                    }
                                    case 'd': //delete
                                    {
                                        deleteContact(MyContact);
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
        This is a test of the address book class.
        * Creates a File object, passes it to the AddressBook constructor, and tests
        * the displayContacts method.
         */
  /*
        // Create new AddressBook
        File csvFile = new File("src/main/resources/steve_test_contacts.csv");
        AddressBook testBook = new AddressBook(csvFile);
        // Test display all method
        testBook.displayContacts(1);
        System.out.println();
        // Test search by first name
        ArrayList<Contact> testSearch = testBook.searchByFirstName("David");
        System.out.println("Matching first names: " + testSearch.toString());
        System.out.println();
        // Test search by mobile
        ArrayList<Contact> testMobileSearch = testBook.searchByMobile("39492993");
        System.out.println("Matching phone numbers: " + testMobileSearch);
        System.out.println();
        // Test search by full name
        ArrayList<Contact> testFullNameSearch = testBook.searchByFullName("  Fred   Flintstone  ");
        System.out.println("Matching full names: " + testFullNameSearch);
        System.out.println();
        // Test search by last name
        ArrayList<Contact> testLastNameSearch = testBook.searchByLastName("Flintstone ");
        System.out.println("Matching last name: " + testLastNameSearch);
        // ******************************************************************************
        */
    }
    //main end






}
