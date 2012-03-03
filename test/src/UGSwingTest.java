import com.gollersoft.jultragame.binding.swing.SwingList;
import com.gollersoft.jultragame.binding.swing.SwingMap;
import com.gollersoft.jultragame.binding.swing.UGSwing;
import com.gollersoft.jultragame.binding.swing.display.SwingImage;
import com.gollersoft.jultragame.core.UGList;
import com.gollersoft.jultragame.core.UGMap;
import com.gollersoft.jultragame.core.display.UGImage;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.easymock.EasyMock.createMock;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/21/12
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSwingTest {
    private UGSwing ug;

    @Before
    public void setUp() throws Exception {
        ug = new UGSwing(640, 480);
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGetImage() throws Exception {
        final UGImage image = ug.getImage("testimg.png");
        assertTrue("Image should be of type SwingImage", image instanceof SwingImage);
    }

    @org.junit.Test
    public void testCreateMap() throws Exception {
        final UGMap<String, String> map = ug.createMap();
        assertTrue("Map should be of type SwingMap", map instanceof SwingMap);
        map.put("Bla", "asdf");
        map.put("foo", "bar");
        assertEquals("Key 'Bla' should return 'asdf'", "asdf", map.get("Bla"));
        assertEquals("Key 'foo' should return 'bar'", "bar", map.get("foo"));
        assertNull("Key 'dkdkddk' should be null", map.get("dkdkddk"));
    }

    @org.junit.Test
    public void testCreateList() throws Exception {
        final UGList<String> list = ug.createList();
        assertTrue("List should be of type SwingList", list instanceof SwingList);
        assertEquals("Length of list at the beginning should be 0", 0, list.size());
        list.add("Foo");
        list.add("Bar");
        assertEquals("Length after two inserts should be 2", 2, list.size());
        assertEquals("Element at 0 should be 'Foo'", "Foo", list.at(0));
        assertEquals("Element at 0 should be 'Bar'", "Bar", list.at(1));
    }
}
