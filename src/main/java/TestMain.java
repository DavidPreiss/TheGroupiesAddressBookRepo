import java.io.File;
import java.util.*;

public class TestMain
{
    public static void main(String[] args)
    {
        ArrayList<Contact> contactList = new ArrayList<>();
        File csv = new File("src/main/resources/steve_test_contacts.csv");
        try
        {
            Scanner scanner = new Scanner(csv);
            scanner.nextLine();
            while (scanner.hasNextLine())
            {
                String entry = scanner.nextLine();
                String[] entries = entry.split(",");
                contactList.add(new Contact(entries));
            }
            scanner.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        contactList.sort(new CompareByCity());

        Iterator<Contact> iterator = contactList.iterator();

        while (iterator.hasNext())
        {
            Contact person = iterator.next();
            System.out.println(person.getFirstName() + " " + person.getLastName());
            System.out.println(person.getCity());
        }





    }
}
