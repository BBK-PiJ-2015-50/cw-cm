import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Chris Kimberley on 09/03/2016.
 */
public class ContactImplTest {
    private Contact contact1;
    private int id1;
    private String name1, notes1;

    @Before
    public void setUp() {
        id1 = 1;
        name1 = "Joe";
        notes1 = "1st note";
        contact1 = new ContactImpl(id1, name1, notes1);
    }

    @Test
    public void testGetId() {
        assertEquals(id1, contact1.getId());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(name1, contact1.getName());
    }

    @Test
    public void testGetNotes() throws Exception {

    }

    @Test
    public void testAddNotes() throws Exception {

    }
}