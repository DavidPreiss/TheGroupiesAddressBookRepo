import java.util.Comparator;

/**
 * Comparator that sort the contacts by city
 * ex. list.sort(new CompareByCity());
 * or for a reverse sort list.sort(new CompareByCity().reversed());
 */
public class CompareByCity implements Comparator<Contact>
{


    @Override
    public int compare(Contact o1, Contact o2)
    {
        return Integer.compare(o1.getCity().compareTo(o2.getCity()), 0);
    }

    @Override
    public Comparator<Contact> reversed()
    {
        return Comparator.super.reversed();
    }
}

