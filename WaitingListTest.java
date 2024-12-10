
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WaitingListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WaitingListTest
{
    private WaitingList wl;
    private final String p1 = "John";
    private final String p2 = "Mark";
    private final String p3 = "Will";
    private final String p4 = "Beth";
    private final String p5 = "Steph";
    private final String n1 = null;
    /**
     * Default constructor for test class WaitingListTest
     */
    public WaitingListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        wl = new WaitingList();

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    // 3 Normal Test Cases
    @Test
    public void testAddPerson(){
        int expected = 1;
        wl.addPerson(p1);
        int actual = wl.waitingListSize();
        assertEquals(expected, actual);        
    }
    
    @Test
    public void testServePerson(){
        String expected = p3;
        String actual = p1;
        wl.addPerson(p3);
        wl.addPerson(p1);
        wl.addPerson(p4);
        actual = wl.servePerson();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testIsPersonInList(){
        boolean expected = true;
        boolean actual = false;
        wl.addPerson(p3);
        wl.addPerson(p1);
        wl.addPerson(p2);
        actual = wl.isPersonInList(p1);
        assertEquals(expected, actual);
    }
    
    // 3 Edge Test Cases
    @Test
    public void testWaitingListSizeEmpty(){
        int expected = 0;
        int actual = wl.waitingListSize();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testServePersonEmpty(){
        String expected = "";
        String actual = p1;
        actual = wl.servePerson();
        assertEquals(expected, actual);
    }
    
    @Test
    public void addDuplicatePerson(){
        int expected = 3;
        int actual = 0;
        wl.addPerson(p3);
        wl.addPerson(p1);
        wl.addPerson(p2);
        wl.addPerson(p1);
        actual = wl.waitingListSize();
        assertEquals(expected, actual);
    }
}
