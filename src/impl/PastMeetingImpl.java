import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by chris on 10/04/2016.
 *
 * @see PastMeeting
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
    public PastMeetingImpl(int id, Calendar date, Set<Contact> contacts, String notes){
        super(id, date, contacts);
    }

    public String getNotes() {
        throw new NotImplementedException();
    }
}
