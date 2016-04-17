import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

/**
 * Created by chris on 09/04/2016.
 *
 * @see FutureMeeting
 */
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting, Serializable {
    public FutureMeetingImpl(int id, Calendar date, Set<Contact> contacts){
        super(id, date, contacts);
    }
}