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
    private ContactManager cManager1, cManager2;
    private Set<Contact> contactSet1, contactSet2;
    private Calendar currentTime;
    private final Calendar pastTime = new GregorianCalendar(2016, 2, 8);

    private Contact contact01, contact02, contact03, contact04, contact05, contact06, contact11, contact12;
    private int id01,id02, id03, id04, id05, id06, id11, id12;
    private String name01, name02, name03, name04, name05, name06, name11, name12;
    private String note01, note02, note03, note04, note05, note06, note11, note12;

    @Before
    public void setUp() {
        cManager1 = new ContactManagerImpl();

        id01 = 1;
        name01 = "Adam";
        note01 = "Note about Adam";
        id02 = 2;
        name02 = "Bruce";
        note02 = "Note about Bruce";
        id03 = 3;
        name03 = "Claire";
        note03 = "Note about Claire";
        id04 = 4;
        name04 = "Dan";
        note04 = "Note about Dan";
        id05 = 5;
        name05 = "Eve";
        note05 = "Note about Eve";
        id06 = 6;
        name06 = "Lucette";
        note06 = "Note about Lucette";
        id11 = 11;
        name11 = "Karl";
        note11 = "Note about Karl";
        id12 = 12;
        name12 = "Lisa";
        note12 = "Note about Lisa";

        contact01 = new ContactImpl(id01, name01, note01);
        contact02 = new ContactImpl(id02, name02, note02);
        contact03 = new ContactImpl(id03, name03, note03);
        contact04 = new ContactImpl(id04, name04, note04);
        contact05 = new ContactImpl(id05, name05, note05);
        contact06 = new ContactImpl(id06, name06, note06);
        contact11 = new ContactImpl(id11, name11, note11);
        contact12 = new ContactImpl(id12, name12, note12);

        contactSet1 = new HashSet<>();
        contactSet1.add(contact01);
        contactSet1.add(contact02);
        contactSet1.add(contact03);
        contactSet1.add(contact04);
        contactSet1.add(contact05);

        contactSet2 = new HashSet<>();
        contact11 = new ContactImpl(id11, name11, note11);
        contact12 = new ContactImpl(id12, name12, note12);
        contactSet2.add(contact11);
        contactSet2.add(contact12);

        cManager2 = new ContactManagerImpl();
        cManager2.addNewContact(name01, note01);
        cManager2.addNewContact(name02, note02);
        cManager2.addNewContact(name03, note03);
        cManager2.addNewContact(name04, note04);
        cManager2.addNewContact(name05, note05);

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
    public void testAddNewContactEmptyStringForNameThrowsIllegalArgumentException() {
        cManager1.addNewContact("", note01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNewContactEmptyStringForNotesThrowsIllegalArgumentException() {
        cManager1.addNewContact(name01, "");
    }

    @Test (expected = NullPointerException.class)
    public void testAddNewContactNullNameThrowsNullPointerException() {
        cManager1.addNewContact(null, note01);
    }

    @Test (expected = NullPointerException.class)
    public void testAddNewContactNullNotesThrowsNullPointerException() {
        cManager1.addNewContact(name01, null);
    }

    @Test
    public void testAddNewContactAdd2NewContactsReturnsCorrectIDs() {
        assertEquals(1, cManager1.addNewContact(name01, note01));
        assertEquals(2, cManager1.addNewContact(name02, note02));
        Set<Contact> testContactSet;
        testContactSet = cManager1.getContacts("");
        System.out.println("Size of testContactSet = " + testContactSet.size());
    }

    /**
     * getContacts(String name) tests
     */
    @Test (expected = NullPointerException.class)
    public void testGetContactsNullNameThrowsNullPointerException() {
        String nullString = null;
        cManager1.getContacts(nullString);
    }

    @Test
    public void testGetContactsEmptyStringReturnsAllCurrentContacts() {
        Set<Contact> testContactSet;
        testContactSet = cManager1.getContacts("");
        assertEquals(testContactSet.size(), 0);

        cManager1.addNewContact(name01, note01);
        testContactSet = cManager1.getContacts("");
        assertEquals(testContactSet.size(), 1);

        cManager1.addNewContact(name02, note02);
        testContactSet = cManager1.getContacts("");
        assertEquals(testContactSet.size(), 2);
    }

    @Test
    public void testGetContactsReturnsContactsWithNamesContainingSpecifiedString() {
        /**
         * Looking for String "uce" in Adam, Bruce & Claire
         */
        cManager1.addNewContact(name01, note01);
        cManager1.addNewContact(name02, note02);
        cManager1.addNewContact(name03, note03);
        Set<Contact> testContactSet = cManager1.getContacts("uce");
        assertEquals(testContactSet.size(), 1);
        /**
         * Adding Lucette and looking again for "uce"
         */
        cManager1.addNewContact(name06, note06);
        testContactSet = cManager1.getContacts("uce");
        assertEquals(testContactSet.size(), 2);
    }

    /**
     * getContacts(int... ids) tests
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetContacts1NoIDsProvidedThrowsIllegalArgumentException() {
        int[] ids = new int[0];
        cManager1.getContacts(ids);
    }

    @Test
    public void testGetContacts1ReturnsCorrespondingNumberOfContactsForSuppliedIDs() {
        assertEquals(2, cManager2.getContacts(2, 4).size());
        assertEquals(5, cManager2.getContacts(1,2,3,4,5).size());
        assertEquals(5, cManager2.getContacts(5,4,3,2,1).size());
        assertEquals(1, cManager2.getContacts(3).size());
    }

    @Test
    public void testGetContacts1IgnoresDuplicateSuppliedIDs() {
        assertEquals(3, cManager2.getContacts(1,2,2,4,4).size());
        assertEquals(1, cManager2.getContacts(3,3,3,3,3,3).size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetContacts1ThrowsIllegalArgumentExceptionForUnknownIDs() {
        cManager2.getContacts(37);
    }

    @Test
    public void testFlush() throws Exception {

    }
}