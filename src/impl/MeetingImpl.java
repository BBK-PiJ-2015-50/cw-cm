import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by chris on 13/03/2016.
 *
 * @see Meeting
 */
public abstract class MeetingImpl implements Meeting {
    private int id;
    private Calendar date;
    private Set<Contact> contacts;

    public MeetingImpl(int id, Calendar date, Set<Contact> contacts) {
        if (id <= 0 || contacts.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (date == null || contacts == null) {
            throw new NullPointerException();
        }
        this.id = id;
        this.date = date;
        this.contacts = contacts;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public Set<Contact> getContacts() {
        throw new NotImplementedException();
    }
}
