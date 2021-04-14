import java.io.File;
import java.util.ArrayList;


public class MainRunner
{
    public static void main(String[] args)
    {
        //main start


        /*
        ********************************************************************************
        This is a test of the address book class.
        * Creates a File object, passes it to the AddressBook constructor, and tests
        * the displayContacts method.
         */
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
    }
    //main end






}
