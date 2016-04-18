import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

/**
 * Created by chris on 10/04/2016.
 *
 * @see PastMeeting
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting, Serializable {
    private String notes;

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
