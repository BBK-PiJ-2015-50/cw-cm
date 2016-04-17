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
    private Set<Contact> contactSet1, contactSet2, contactSet3, emptyContactSet;
    private Calendar testTime, futureTime, pastTime;

    private Contact contact01, contact02, contact03, contact04, contact05, contact12, contact21, contact22;
    private int id01,id02, id03, id04, id05, id12, id21, id22;
    private String name01, name02, name03, name04, name05, name12, name21, name22;
    private String note01, note02, note03, note04, note05, note12, note21, note22;
    private String text01, text02, textAdded;

    @Before
    public void setUp() {

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
        id12 = 12;
        name12 = "Lucette";
        note12 = "Note about Lucette";

        id21 = 21;
        name21 = "Uma";
        note21 = "Note about Uma";
        id22 = 22;
        name22 = "Victoria";
        note22 = "Note about Victoria";

        contact01 = new ContactImpl(id01, name01, note01);
        contact02 = new ContactImpl(id02, name02, note02);
        contact03 = new ContactImpl(id03, name03, note03);
        contact04 = new ContactImpl(id04, name04, note04);
        contact05 = new ContactImpl(id05, name05, note05);

        contact12 = new ContactImpl(id12, name12, note12);

        contactSet1 = new HashSet<>();
        contactSet1.add(contact01);
        contactSet1.add(contact02);
        contactSet1.add(contact03);

        contactSet2 = new HashSet<>();
        contactSet2.add(contact04);
        contactSet2.add(contact05);

        /**
         * contactSet3 - unknown contacts
         */
        contactSet3 = new HashSet<>();
        contact21 = new ContactImpl(id21, name21, note21);
        contact22 = new ContactImpl(id22, name22, note22);
        contactSet3.add(contact21);
        contactSet3.add(contact22);

        emptyContactSet = new HashSet<>();

        cManager1 = new ContactManagerImpl();
        cManager1.addNewContact(name01, note01);
        cManager1.addNewContact(name02, note02);
        cManager1.addNewContact(name03, note03);
        cManager1.addNewContact(name04, note04);
        cManager1.addNewContact(name05, note05);

        text01 = "Text about Meeting 1";
        text02 = "Text about Meeting 2";
        textAdded = "Some added notes";

        cManager2 = new ContactManagerImpl();

        testTime = Calendar.getInstance();
        futureTime = Calendar.getInstance();
        futureTime.add(Calendar.MONTH, 1);
        pastTime = Calendar.getInstance();
        pastTime.add(Calendar.MONTH, -1);
    }

    @Test (expected = NullPointerException.class)
    public void testAddFutureMeetingThrowsNullPointerExceptionForNullContacts() {
        cManager1.addFutureMeeting(null, futureTime);
    }

    @Test (expected = NullPointerException.class)
    public void testAddFutureMeetingThrowsNullPointerExceptionForNullDate() {
        cManager1.addFutureMeeting(contactSet1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFutureMeetingThrowsIllegalArgumentExceptionForTimeInPastCurrentMinusOneSecond() {
        testTime.add(Calendar.SECOND, -1);
        cManager1.addFutureMeeting(contactSet1, testTime);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFutureMeetingThrowsIllegalArgumentExceptionForTimeInPastCurrentMinusOneMinute() {
        testTime.add(Calendar.MINUTE, -1);
        cManager1.addFutureMeeting(contactSet1, testTime);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFutureMeetingThrowsIllegalArgumentExceptionForTimeInPastCurrentMinusOneYear() {
        testTime.add(Calendar.YEAR, -1);
        cManager1.addFutureMeeting(contactSet1, testTime);
    }

    @Test
    public void testAddFutureMeetingReturnsPositiveIdForTimeInFutureCurrentPlusOneYear() {
        testTime.add(Calendar.YEAR, 1);
        assertTrue((cManager1.addFutureMeeting(contactSet1, testTime)) > 0);
    }

    @Test
    public void testAddFutureMeetingReturnsPositiveIdForTimeInFutureCurrentPlusOneSecond() {
        testTime.add(Calendar.SECOND, 1);
        assertTrue((cManager1.addFutureMeeting(contactSet1, testTime)) > 0);
    }

    @Test
    public void testAddFutureMeetingReturnsCorrectIds() {
        assertEquals(1, cManager1.addFutureMeeting(contactSet1, futureTime));
        assertEquals(2, cManager1.addFutureMeeting(contactSet2, futureTime));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFutureMeetingUnknownContactsThrowsIllegalArgumentException() {
        cManager1.addFutureMeeting(contactSet3, futureTime);
    }

    @Test
    public void testAddFutureMeetingsGetMeetings() {
        cManager1.addFutureMeeting(contactSet1, futureTime);
        cManager1.addFutureMeeting(contactSet2, futureTime);

        Meeting fMeeting1 = cManager1.getMeeting(1);
        assertEquals(1, fMeeting1.getId());
        assertEquals(contactSet1, fMeeting1.getContacts());
        assertEquals(futureTime, fMeeting1.getDate());
        assertTrue(fMeeting1 instanceof FutureMeeting);

        Meeting fMeeting2 = cManager1.getMeeting(2);
        assertEquals(2, fMeeting2.getId());
        assertEquals(contactSet2, fMeeting2.getContacts());
        assertEquals(futureTime, fMeeting2.getDate());
        assertTrue(fMeeting2 instanceof FutureMeeting);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetPastMeetingThrowsIllegalArgumentExceptionForMeetingInFuture() {
        cManager1.addFutureMeeting(contactSet1, futureTime);
        cManager1.getPastMeeting(1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetFutureMeetingThrowsIllegalArgumentExceptionForMeetingInPast() {
        cManager1.addNewPastMeeting(contactSet1, pastTime, text01);
        cManager1.getFutureMeeting(1);
    }

    @Test
    public void testGetMeetingReturnsNullForNoMeetingMatchingId() {
        cManager1.addFutureMeeting(contactSet1, futureTime);
        cManager1.addFutureMeeting(contactSet2, futureTime);
        assertNull(cManager1.getMeeting(3));
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

    @Test (expected = IllegalArgumentException.class)
    public void testAddNewPastMeetingThrowsIllegalArgumentExceptionForEmptyContacts() {
        cManager1.addNewPastMeeting(emptyContactSet, pastTime, text01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNewPastMeetingThrowsIllegalArgumentExceptionForNonExistentContacts() {
        cManager1.addNewPastMeeting(contactSet3, pastTime, text01);
    }

    @Test (expected = NullPointerException.class)
    public void testAddNewPastMeetingThrowsNullPointerExceptionForNullContacts() {
        cManager1.addNewPastMeeting(null, pastTime, text01);
    }

    @Test (expected = NullPointerException.class)
    public void testAddNewPastMeetingThrowsNullPointerExceptionForNullDate() {
        cManager1.addNewPastMeeting(contactSet1, null, text01);
    }

    @Test (expected = NullPointerException.class)
    public void testAddNewPastMeetingThrowsNullPointerExceptionForNullText() {
        cManager1.addNewPastMeeting(contactSet1, pastTime, null);
    }

    @Test (expected = NullPointerException.class)
    public void testAddMeetingNotesThrowsNullPointerExceptionForNullNotes() {
        cManager1.addNewPastMeeting(contactSet1, pastTime, text01);
        cManager1.addMeetingNotes(1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddMeetingNotesThrowsIllegalArgumentExceptionForNonExistentMeeting() {
        cManager1.addNewPastMeeting(contactSet1, pastTime, text01);
        cManager1.addMeetingNotes(2, text02);
    }

    @Test (expected = IllegalStateException.class)
    public void testAddMeetingNotesThrowsIllegalStateExceptionForMeetingDateInFuture() {
        cManager1.addFutureMeeting(contactSet1, futureTime);
        cManager1.addMeetingNotes(1, text01);
    }

    @Test
    public void testAddMeetingNotesAddNotesToPastMeetingThenGetNotesOriginalPlusAdded() {
        cManager1.addNewPastMeeting(contactSet1, pastTime, text01);
        PastMeeting returnedPastMeeting = cManager1.addMeetingNotes(1, textAdded);
        assertEquals(text01 + "\n" + textAdded, returnedPastMeeting.getNotes());
        System.out.println(returnedPastMeeting.getNotes());
    }

    /**
     * addNewContact tests
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddNewContactEmptyStringForNameThrowsIllegalArgumentException() {
        cManager2.addNewContact("", note01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNewContactEmptyStringForNotesThrowsIllegalArgumentException() {
        cManager2.addNewContact(name01, "");
    }

    @Test (expected = NullPointerException.class)
    public void testAddNewContactNullNameThrowsNullPointerException() {
        cManager2.addNewContact(null, note01);
    }

    @Test (expected = NullPointerException.class)
    public void testAddNewContactNullNotesThrowsNullPointerException() {
        cManager2.addNewContact(name01, null);
    }

    @Test
    public void testAddNewContactAdd2NewContactsReturnsCorrectIDs() {
        assertEquals(1, cManager2.addNewContact(name01, note01));
        assertEquals(2, cManager2.addNewContact(name02, note02));
        Set<Contact> testContactSet = cManager2.getContacts("");
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
        testContactSet = cManager2.getContacts("");
        assertEquals(testContactSet.size(), 0);

        cManager2.addNewContact(name01, note01);
        testContactSet = cManager2.getContacts("");
        assertEquals(testContactSet.size(), 1);

        cManager2.addNewContact(name02, note02);
        testContactSet = cManager2.getContacts("");
        assertEquals(testContactSet.size(), 2);
    }

    @Test
    public void testGetContactsReturnsContactsWithNamesContainingSpecifiedString() {
        /**
         * Looking for String "uce" in Adam, Bruce & Claire
         */
        cManager2.addNewContact(name01, note01);
        cManager2.addNewContact(name02, note02);
        cManager2.addNewContact(name03, note03);
        Set<Contact> testContactSet = cManager2.getContacts("uce");
        assertEquals(testContactSet.size(), 1);
        /**
         * Adding Lucette and looking again for "uce"
         */
        cManager2.addNewContact(name12, note12);
        testContactSet = cManager2.getContacts("uce");
        assertEquals(testContactSet.size(), 2);
    }

    /**
     * getContacts(int... ids) tests
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetContactsByIdNoIDsProvidedThrowsIllegalArgumentException() {
        int[] ids = new int[0];
        cManager1.getContacts(ids);
    }

    @Test
    public void testGetContactsByIdReturnsCorrespondingNumberOfContactsForSuppliedIDs() {
        assertEquals(2, cManager1.getContacts(2, 4).size());
        assertEquals(5, cManager1.getContacts(1,2,3,4,5).size());
        assertEquals(5, cManager1.getContacts(5,4,3,2,1).size());
        assertEquals(1, cManager1.getContacts(3).size());
    }

    @Test
    public void testGetContactsByIdIgnoresDuplicateSuppliedIDs() {
        assertEquals(3, cManager1.getContacts(1,2,2,4,4).size());
        assertEquals(1, cManager1.getContacts(3,3,3,3,3,3).size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetContactsByIdThrowsIllegalArgumentExceptionForUnknownIDs() {
        cManager1.getContacts(37);
        cManager1.getContacts(1376, 94, 232);
        cManager1.getContacts(1376, 94, 1376, 232, 94);
    }

    @Test
    public void testFlush() throws Exception {

    }
}