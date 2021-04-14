import java.util.Comparator;

/**
 * Comparator for sorting the contacts by first then last name.
 * ex. list.sort(new CompareByFirstThenLastName());
 * or for a reverse sort list.sort(new CompareByFirstThenLastName().reversed());
 */
public class CompareByFirstThenLastName implements Comparator<Contact>
{


    @Override
    public int compare(Contact o1, Contact o2)
    {
        if (o1.getFirstName().compareTo(o2.getFirstName()) > 0)
        {
            return 1;
        }
        else if (o1.getFirstName().compareTo(o2.getFirstName()) < 0)
        {
            return -1;
        }
        else return Integer.compare(o1.getLastName().compareTo(o2.getLastName()), 0);
    }

    @Override
    public Comparator<Contact> reversed()
    {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Contact> thenComparing(Comparator<? super Contact> other)
    {
        return Comparator.super.thenComparing(other);
    }
}
