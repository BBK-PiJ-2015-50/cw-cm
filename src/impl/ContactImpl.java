import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Objects;

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

    /**
     * Overriding check for equality of ContactImpl based on id & name
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ContactImpl contact = (ContactImpl) obj;
        return (id == contact.id && Objects.equals(name, contact.name));
    }

    /**
     * Also overriding hashCode - based on id & name
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
