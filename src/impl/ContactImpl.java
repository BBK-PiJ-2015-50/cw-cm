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
        if (name == null || notes == null) {
            throw new NullPointerException();
        }
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.notes = notes;
    }

    public ContactImpl(int id, String name) {
        this(id, name, "");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public void addNotes(String note) {
        notes += note;
    }
}
