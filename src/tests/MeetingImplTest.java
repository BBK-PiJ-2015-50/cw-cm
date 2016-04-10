import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by chris on 13/03/2016.
 */
public class MeetingImplTest {
    private Meeting meeting1;
    private Set<Contact> contacts;
    private Contact contact1;

    @Before
    public void setUp() {
        contacts = new HashSet<>();
        contact1 = new ContactImpl(1, "John", "VIP" );
        contacts.add(contact1);
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
    public void testGetDate() throws Exception {

    }

    @Test
    public void testGetContacts() throws Exception {

    }
}