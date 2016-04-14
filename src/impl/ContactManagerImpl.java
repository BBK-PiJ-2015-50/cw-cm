import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chris on 11/04/2016.
 *
 * @see ContactManager
 */
public class ContactManagerImpl implements ContactManager {
    private Set<Contact> contactSet;
    private int contactId;
    private Calendar currentTime;

    public ContactManagerImpl() {
        contactSet = new HashSet<>();
        contactId = 1;
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
        if (name.equals("") || notes.equals("")) {
            throw new IllegalArgumentException();
        }
        if (name == null || notes == null) {
            throw new NullPointerException();
        }
        contactSet.add(new ContactImpl(contactId, name, notes));
        int id = contactId;
        contactId++;
        return id;
    }

    @Override
    public Set<Contact> getContacts(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        if (name.equals("")) {
            return contactSet;
        }
        return contactSet.parallelStream().filter(c -> c.getName().contains(name)).collect(Collectors.toSet());
    }

    @Override
    public Set<Contact> getContacts(int... ids) {
        if (ids.length == 0) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public void flush() {

    }
}
