import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

/**
 * @author Chris Kimberley
 *
 * @see PastMeeting
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting, Serializable {
    private String notes;

    /**
     * @param id
     * @param date
     * @param contacts
     * @param notes
     */
    public PastMeetingImpl(int id, Calendar date, Set<Contact> contacts, String notes) {
        super(id, date, contacts);
        if (notes == null) {
            throw new NullPointerException();
        }
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
}
