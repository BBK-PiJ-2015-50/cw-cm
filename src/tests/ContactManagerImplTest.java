import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by chris on 11/04/2016.
 */
public class ContactManagerImplTest {
    private ContactManager cm1;

    @Before
    public void setUp() {
        cm1 = new ContactManagerImpl();
    }

    @Test (expected = NullPointerException.class)
    public void testAddFutureMeetingThrowsNullPointerExceptionForNullContacts() {
        cm1.addFutureMeeting(null, Calendar.getInstance());
    }

    @Test
    public void testGetPastMeeting() throws Exception {

    }

    @Test
    public void testGetFutureMeeting() throws Exception {

    }

    @Test
    public void testGetMeeting() throws Exception {

    }

    @Test
    public void testGetFutureMeetingList() throws Exception {

    }

    @Test
    public void testGetMeetingListOn() throws Exception {

    }

    @Test
    public void testGetPastMeetingListFor() throws Exception {

    }

    @Test
    public void testAddNewPastMeeting() throws Exception {

    }

    @Test
    public void testAddMeetingNotes() throws Exception {

    }

    @Test
    public void testAddNewContact() throws Exception {

    }

    @Test
    public void testGetContacts() throws Exception {

    }

    @Test
    public void testGetContacts1() throws Exception {

    }

    @Test
    public void testFlush() throws Exception {

    }
}