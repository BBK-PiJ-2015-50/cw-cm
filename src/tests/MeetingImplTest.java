import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by chris on 13/03/2016.
 */
public class MeetingImplTest {
    private Meeting meeting1;
    private Set<Contact> contacts;
    private Contact contact1;
    private Calendar date;
    private String notes;

    @Before
    public void setUp() {
        contacts = new HashSet<>();
        contact1 = new ContactImpl(1, "John", "VIP" );
        contacts.add(contact1);
        date = new GregorianCalendar(2016, 3, 8);
        notes = "Note 1";
    }

    // Tests use FutureMeetingImpl as MeetingImpl is an abstract class
    @Test (expected = IllegalArgumentException.class)
    public void testMeetingImplConstructorThrowsIllegalArgumentExceptionForNegativeID() {
        meeting1 = new FutureMeetingImpl(-1, Calendar.getInstance(), contacts);
     }

    @Test (expected = IllegalArgumentException.class)
    public void testMeetingImplConstructorThrowsIllegalArgumentExceptionForZeroID() {
        meeting1 = new FutureMeetingImpl(0, Calendar.getInstance(), contacts);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMeetingImplConstructorThrowsIllegalArgumentExceptionForEmptyContacts() {
        meeting1 = new FutureMeetingImpl(1, Calendar.getInstance(), Collections.emptySet());
    }

    @Test (expected = NullPointerException.class)
    public void testMeetingImplConstructorThrowsNullPointerExceptionForNullDate() {
        meeting1 = new FutureMeetingImpl(1, null, contacts);
    }

    @Test (expected = NullPointerException.class)
    public void testMeetingImplConstructorThrowsNullPointerExceptionForNullContacts() {
        meeting1 = new FutureMeetingImpl(1, Calendar.getInstance(), null);
    }

    @Test
    public void testGetIdReturnsCorrectID() {
        meeting1 = new FutureMeetingImpl(1, Calendar.getInstance(), contacts);
        assertEquals(1, meeting1.getId());
    }

    @Test
    public void testGetDateReturnsCorrectDate() throws Exception {
        meeting1 = new FutureMeetingImpl(1, new GregorianCalendar(2016, 3, 8), contacts);
        assertEquals(new GregorianCalendar(2016, 3, 8), meeting1.getDate());
    }

    @Test
    public void testGetContactsReturnsCorrectContacts() {
        meeting1 = new FutureMeetingImpl(1, Calendar.getInstance(), contacts);
        assertEquals(contacts, meeting1.getContacts());
    }

    /**
     * Previous tests now duplicated for PastMeetingImpl with 4th parameter: String notes
     */
    @Test (expected = IllegalArgumentException.class)
    public void testPastMeetingImplConstructorThrowsIllegalArgumentExceptionForNegativeID() {
        meeting1 = new PastMeetingImpl(-1, Calendar.getInstance(), contacts, notes);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPastMeetingImplConstructorThrowsIllegalArgumentExceptionForZeroID() {
        meeting1 = new PastMeetingImpl(0, Calendar.getInstance(), contacts, notes);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPastMeetingImplConstructorThrowsIllegalArgumentExceptionForEmptyContacts() {
        meeting1 = new PastMeetingImpl(1, Calendar.getInstance(), Collections.emptySet(), notes);
    }

    @Test (expected = NullPointerException.class)
    public void testPastMeetingImplConstructorThrowsNullPointerExceptionForNullDate() {
        meeting1 = new PastMeetingImpl(1, null, contacts, notes);
    }

    @Test (expected = NullPointerException.class)
    public void testPastMeetingImplConstructorThrowsNullPointerExceptionForNullContacts() {
        meeting1 = new PastMeetingImpl(1, Calendar.getInstance(), null, notes);
    }

    @Test
    public void testPastMeetingGetIdReturnsCorrectID() {
        meeting1 = new PastMeetingImpl(1, Calendar.getInstance(), contacts, notes);
        assertEquals(1, meeting1.getId());
    }

    @Test
    public void testPastMeetingGetDateReturnsCorrectDate() throws Exception {
        meeting1 = new PastMeetingImpl(1, new GregorianCalendar(2016, 3, 8), contacts, notes);
        assertEquals(new GregorianCalendar(2016, 3, 8), meeting1.getDate());
    }

    @Test
    public void testPastMeetingGetContactsReturnsCorrectContacts() {
        meeting1 = new PastMeetingImpl(1, Calendar.getInstance(), contacts, notes);
        assertEquals(contacts, meeting1.getContacts());
    }

    /**
     * Additional PastMeeting tests
     */
    @Test (expected = NullPointerException.class)
    public void testPastMeetingImplConstructorThrowsNullPointerExceptionForNullNotes() {
        meeting1 = new PastMeetingImpl(1, Calendar.getInstance(), contacts, null);
    }

    @Test
    public void testPastMeetingGetContactsReturnsCorrectNotes() {
        meeting1 = new PastMeetingImpl(1, Calendar.getInstance(), contacts, notes);
        assertEquals(notes, meeting1.getNotes());
    }

}