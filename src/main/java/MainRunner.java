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

        /*
        ********************************************************************************
        This is a test of the address book class.
        * Creates a File object, passes it to the AddressBook constructor, and tests
        * the displayContacts method.
         */
        File csvFile = new File("src/main/resources/steve_test_contacts.csv");
        AddressBook testBook = new AddressBook(csvFile);
        testBook.displayContacts(1);
        // ******************************************************************************
    }
    //main end






}
