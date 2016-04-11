import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

/**
 * Created by chris on 11/04/2016.
 *
 * @see ContactManager
 */
public class ContactManagerImpl implements ContactManager {
    private Calendar currentTime;

    public ContactManagerImpl() {
        currentTime = new GregorianCalendar();
    }

    @Override
    public int addFutureMeeting(Set<Contact> contacts, Calendar date) {
        if (contacts == null || date == null) {
            throw new NullPointerException();
        }
        if (date.before(new GregorianCalendar())) {
            throw new IllegalArgumentException();
        }
        return -1;
    }

        @Override
    public PastMeeting getPastMeeting(int id) {
        return null;
    }

        @Override
    public FutureMeeting getFutureMeeting(int id) {
        return null;
    }

        @Override
    public Meeting getMeeting(int id) {
        return null;
    }

        @Override
    public List<Meeting> getFutureMeetingList(Contact contact) {
        return null;
    }

        @Override
    public List<Meeting> getMeetingListOn(Calendar date) {
        return null;
    }

        @Override
    public List<PastMeeting> getPastMeetingListFor(Contact contact) {
        return null;
    }

        @Override
    public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {

    }

        @Override
    public PastMeeting addMeetingNotes(int id, String text) {
        return null;
    }

        @Override
    public int addNewContact(String name, String notes) {
        return 0;
    }

        @Override
    public Set<Contact> getContacts(String name) {
        return null;
    }

        @Override
    public Set<Contact> getContacts(int... ids) {
        return null;
    }

        @Override
    public void flush() {

    }
}
