import com.gollersoft.jultragame.core.UGFinalRect;
import com.gollersoft.jultragame.sprite.UGSpriteAnimation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSpriteAnimationTest {
    UGSpriteAnimation animation;

    @Before
    public void setUp() throws Exception {
        animation = new UGSpriteAnimation(new UGFinalRect(64, 64, 32, 32), 2, 4);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStep() throws Exception {
        UGFinalRect rect = animation.getPosition();
        assertEquals(64, rect.x);
        assertEquals(64, rect.y);
        assertEquals(32, rect.width);
        assertEquals(32, rect.height);

        animation.step();
        rect = animation.getPosition();
        assertEquals(98, rect.x);
        assertEquals(64, rect.y);
        assertEquals(32, rect.width);
        assertEquals(32, rect.height);

        animation.setNext(2);
        animation.step();
        rect = animation.getPosition();
        assertEquals(98, rect.x);
        assertEquals(64, rect.y);
        assertEquals(32, rect.width);
        assertEquals(32, rect.height);

        animation.step();
        rect = animation.getPosition();
        assertEquals(98 + 32 + 2, rect.x);
        assertEquals(64, rect.y);
        assertEquals(32, rect.width);
        assertEquals(32, rect.height);

        animation.setNext(1);
        animation.step();
        rect = animation.getPosition();
        assertEquals(98 + 64 + 4, rect.x);
        assertEquals(64, rect.y);
        assertEquals(32, rect.width);
        assertEquals(32, rect.height);

        animation.step();
        rect = animation.getPosition();
        assertEquals(64, rect.x);
        assertEquals(64, rect.y);
        assertEquals(32, rect.width);
        assertEquals(32, rect.height);
    }
}
