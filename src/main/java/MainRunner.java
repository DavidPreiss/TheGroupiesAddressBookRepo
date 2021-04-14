import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;

import java.util.ArrayList;
import java.util.Scanner;


public class MainRunner
{

    // Method below is implemented in AddressBook
    public static Contact searchByName(String input)
    {
        System.out.println("Not yet implemented!\n"+input);
        Contact VoidLord = new Contact("Void","Lord","6666666666");
        return VoidLord;
    }
    // Method below is implemented in AddressBook
    public static Contact searchByMobile(String input)
    {
        System.out.println("Not yet implemented!\n"+input);
        Contact VoidLord = new Contact("Void","Lord","6666666666");
        return VoidLord;
    }
    public static void addContact(Contact inputContact, AddressBook inputBook)
    {

        System.out.println("Add Not Yet Implemented");
    }
    public static void deleteContact(Contact inputContact, AddressBook inputBook)
    {
        inputBook.deleteContact(inputContact);
    }
    // Method below is implemented in AddressBook
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
        // create address book with csv file
        File csvFile = new File("src/main/resources/steve_test_contacts.csv");
        AddressBook addressBook = new AddressBook(csvFile);

        System.out.println("\t MAIN START");
        Scanner scanner = new Scanner(System.in);
        boolean repeat1 = true; //repeats the main menu
        while (repeat1)
        {

            //Greet the user
            System.out.println("Hello welcome to the address book!");
            //present Main Menu options
            System.out.println("(A)dd - (P)rint All - (S)earch - (E)xit");
            //read user input
            String userInput = scanner.nextLine().toLowerCase(); //ignore case
            if (userInput.equals(""))userInput = " "; //change empty strings to a single space to avoid exception
            char usrInChar = userInput.charAt(0); // read the first character for ease of use
            System.out.println("userInput: "+userInput); //print back what the user typed for confirmation
            switch (usrInChar)
            {

                case 'e': //exit
                {
                    repeat1 = false;
                    //setting repeat1 to false ends the outermost loop and thus ends the program
                    System.out.println("Goodbye!");
                    break;
                }

                case 'a': //add new contact
                {

                    //Read the user input and store as strings
                    System.out.println("Input First Name: ");
                    String userFirstName = scanner.nextLine();
                    System.out.println("Input First Name: ");
                    String userLastName = scanner.nextLine();
                    System.out.println("Input Mobile Number: ");
                    String userMobile = scanner.nextLine();
                    //create a new contact using the strings read from the user
                    Contact userContact = new Contact(userFirstName,userLastName,userMobile);
                    addContact(userContact,addressBook);
                    System.out.println("contact added");

                    break;
                }
                case 'p': //print all contacts
                {


                    addressBook.displayContacts(1); // Method defined in AddressBook
                    break;
                }
                case 's': //search for specific contact
                {


                    boolean repeat2 = true; //repeats the Search Menu
                    boolean haveContact = false; //switches to true when a contact is found
                    //Create a new contact, MyContact will be set to the described contact when it is found,
                    //so the parameters don't matter
                    Contact MyContact = new Contact("Default","Contact","1112223333");

                    while (repeat2)
                    {
                        //present Search Menu Options
                        System.out.println("Search by (P)hone or (N)ame? (E)xit");
                        //Read user input and store as string
                        String userOrder = scanner.nextLine().toLowerCase();
                        if (userOrder.equals(""))userOrder = " "; //handles empty string cornercase
                        //Read first character and store as char for ease of use
                        char orderChar = userOrder.charAt(0);
                        switch (orderChar)
                        {
                            case 'e': //exit
                            {
                                repeat2 = false;//prevents Search Menu from reappearing
                                haveContact = false;//prevents
                                System.out.println("Returning to Main Menu!");
                                break;
                            }

                            case 'p':
                            {

                                    System.out.println("input Mobile number");
                                    String mobileString = scanner.nextLine().toLowerCase();
                                    // MyContact = searchByMobile(mobileString);
                                    // below is equivalent method from AddressBook class
                                    MyContact = addressBook.searchByMobile(mobileString).get(0);
                                    haveContact = true;
                                break;
                            }
                            case 'n':
                            {
                                System.out.println("input Name");
                                String nameString = scanner.nextLine().toLowerCase();
                                // MyContact = searchByName(nameString);
                                // below is equivalent method from AddressBook class
                                MyContact = addressBook.searchByFullName(nameString).get(0);
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
                                System.out.println(MyContact.toString()); // Steve wrapped this in a println
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
                                        deleteContact(MyContact,addressBook);
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
    }
    //main end






}
