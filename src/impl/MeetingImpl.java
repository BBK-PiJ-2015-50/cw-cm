import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by chris on 13/03/2016.
 *
 * @see Meeting
 */
public class MeetingImpl implements Meeting {
    private int id;
    private Calendar date;
    private Set<Contact> contacts;

    public MeetingImpl(int id, Calendar date, Set<Contact> contacts){
        this.id = id;
        this.date = date;
        this.contacts = contacts;
    }

    @Override
    public int getId() {
        throw new NotImplementedException();
    }

    @Override
    public Calendar getDate() {
        throw new NotImplementedException();
    }

    @Override
    public Set<Contact> getContacts() {
        throw new NotImplementedException();
    }
}
