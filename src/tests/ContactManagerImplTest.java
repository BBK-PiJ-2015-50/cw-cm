import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by chris on 11/04/2016.
 */
public class ContactManagerImplTest {
    private ContactManager cManager1;
    private Set<Contact> contactSet1, contactSet2;
    private Contact contact01, contact02, contact03, contact04, contact05, contact11, contact12;
    private Calendar currentTime;
    private final Calendar pastTime = new GregorianCalendar(2016, 2, 8);
    private String name01, note01;

    @Before
    public void setUp() {
        cManager1 = new ContactManagerImpl();

        contactSet1 = new HashSet<>();
        contact01 = new ContactImpl(1, "Adam", "Note about Adam");
        contact02 = new ContactImpl(2, "Bruce", "Note about Bruce");
        contact03 = new ContactImpl(3, "Claire", "Note about Claire");
        contact04 = new ContactImpl(4, "Dan", "Note about Dan");
        contact05 = new ContactImpl(5, "Eve", "Note about Eve");
        contactSet1.add(contact01);
        contactSet1.add(contact02);
        contactSet1.add(contact03);
        contactSet1.add(contact04);
        contactSet1.add(contact05);

        name01 = "Adam";
        note01 = "Note about Adam";

        contactSet2 = new HashSet<>();
        contact11 = new ContactImpl(11, "Karl", "Note about Karl");
        contact12 = new ContactImpl(12, "Lisa", "Note about Lisa");
        contactSet1.add(contact11);
        contactSet1.add(contact12);

        currentTime = new GregorianCalendar();
    }

    @Test (expected = NullPointerException.class)
    public void testAddFutureMeetingThrowsNullPointerExceptionForNullContacts() {
        cManager1.addFutureMeeting(null, Calendar.getInstance());
    }

    @Test (expected = NullPointerException.class)
    public void testAddFutureMeetingThrowsNullPointerExceptionForNullDate() {
        cManager1.addFutureMeeting(contactSet1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFutureMeetingThrowsIllegalArgumentExceptionForTimeInPast() {
        cManager1.addFutureMeeting(contactSet1, pastTime);
    }

    @Test
    public void testAddFutureMeetingReturnsPositiveID() {
        assertTrue((cManager1.addFutureMeeting(contactSet1, Calendar.getInstance())) > 0);
    }

    /*@Test (expected = IllegalArgumentException.class)
    public void testAddFutureMeetingAddingUnknownContactsThrowsIllegalArgumentException() {
        cManager1.addFutureMeeting();
    }*/

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

    /**
     * addNewContact tests
     */
    @Test (expected = IllegalArgumentException.class)
    public void testEmptyStringForNameThrowsIllegalArgumentException() {
        cManager1.addNewContact("", note01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyStringForNotesThrowsIllegalArgumentException() {
        cManager1.addNewContact(name01, "");
    }

    @Test (expected = NullPointerException.class)
    public void testNullForNameThrowsNullPointerException() {
        cManager1.addNewContact(null, note01);
    }

    @Test (expected = NullPointerException.class)
    public void testNullForNotesThrowsNullPointerException() {
        cManager1.addNewContact(name01, null);
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