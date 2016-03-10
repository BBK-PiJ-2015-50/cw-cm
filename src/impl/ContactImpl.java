import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Chris Kimberley on 08/03/2016.
 */
public class ContactImpl implements Contact {
    private int id;
    private String name, notes;

    public ContactImpl(int id, String name, String notes) {
        this.id = id;
        this.name = name;
        this.notes = notes;
    }

    /**
     * Returns the ID of the contact.
     *
     * @return the ID of the contact.
     */
    //@Override
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the contact.
     *
     * @return the name of the contact.
     */
    //@Override
    public String getName() {
        throw new NotImplementedException();
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
