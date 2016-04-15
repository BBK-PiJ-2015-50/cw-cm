import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chris on 11/04/2016.
 *
 * @see ContactManager
 */
public class ContactManagerImpl implements ContactManager {
    private Set<Contact> contactSet;
    private List<Meeting> meetingList;
    private int contactId, meetingId;
    private Calendar currentTime;

    public ContactManagerImpl() {
        contactSet = new HashSet<>();
        meetingList =new ArrayList<>();
        contactId = 1;
        meetingId = 1;
        currentTime = Calendar.getInstance();
    }

    @Override
    public int addFutureMeeting(Set<Contact> contacts, Calendar date) {
        currentTime = Calendar.getInstance();
        if (contacts == null || date == null) {
            throw new NullPointerException();
        }
        if (date.before(currentTime)) {
            throw new IllegalArgumentException();
        }
        /**
         * Check for any unknown contacts
         */
        if (!contactSet.containsAll(contacts)) {
            throw new IllegalArgumentException();
        }
        int id = meetingId;
        meetingList.add(new FutureMeetingImpl(id, date,contacts));
        meetingId++;
        return id;
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
        throw new NotImplementedException();
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
        return contactSet.parallelStream()
                .filter(c -> c.getName().contains(name)).collect(Collectors.toSet());
    }

    @Override
    public Set<Contact> getContacts(int... ids) {
        if (ids.length == 0) {
            throw new IllegalArgumentException();
        }
        Set<Integer> distinctSuppliedIds = Arrays.stream(ids).mapToObj(i -> (Integer) i).collect(Collectors.toSet());
        Set<Contact> correspondingContacts = contactSet.parallelStream()
                .filter(c -> distinctSuppliedIds.parallelStream().anyMatch(i -> i == c.getId()))
                .collect(Collectors.toSet());
        if (distinctSuppliedIds.size() != correspondingContacts.size()) {
            throw new IllegalArgumentException();
        }
        return correspondingContacts;
    }

    @Override
    public void flush() {

    }
}
