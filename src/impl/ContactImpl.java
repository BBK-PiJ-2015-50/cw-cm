import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Chris Kimberley on 08/03/2016.
 *
 * @see Contact
 */
public class ContactImpl implements Contact {
    private int id;
    private String name, notes;

    public ContactImpl(int id, String name, String notes) {
        this.id = id;
        this.name = name;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    /**
     * Returns our notes about the contact, if any.
     * <p>
     * If we have not written anything about the contact, the empty
     * string is returned.
     *
     * @return a string with notes about the contact, maybe empty.
     */
    //@Override
    public String getNotes() {
        throw new NotImplementedException();
    }

    /**
     * Add notes about the contact.
     *
     * @param note the notes to be added
     */
    ///@Override
    public void addNotes(String note) {
        throw new NotImplementedException();
    }
}
