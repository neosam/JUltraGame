import com.gollersoft.jultragame.binding.swing.UGSwing;
import com.gollersoft.jultragame.core.display.UGCamera;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.layer.UGSpriteLayer;
import com.gollersoft.jultragame.sprite.UGSprite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static sun.plugin2.liveconnect.ArgumentHelper.validate;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/23/12
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSpriteLayerTest {
    private UGSpriteLayer spriteLayer;
    private UGCamera camera;

    @Before
    public void setUp() throws Exception {
        camera = new UGCamera();
        spriteLayer = new UGSpriteLayer(new UGSwing(1, 1), camera);
    }

    @After
    public void tearDown() throws Exception {
        spriteLayer = null;

    }

    @Test
    public void testDraw() throws Exception {
        UGSprite aSprite = createMock(UGSprite.class);
        UGSprite bSprite = createMock(UGSprite.class);
        UGGraphics graphics = createMock(UGGraphics.class);
        spriteLayer.add(aSprite);
        spriteLayer.add(bSprite);
        aSprite.draw(graphics, camera);
        bSprite.draw(graphics, camera);
        replay(aSprite);
        replay(bSprite);
        spriteLayer.draw(graphics);
        verify(aSprite);
        verify(bSprite);

    }

    @Test
    public void testFrame() throws Exception {
        UGSprite aSprite = createMock(UGSprite.class);
        UGSprite bSprite = createMock(UGSprite.class);
        spriteLayer.add(aSprite);
        spriteLayer.add(bSprite);
        aSprite.step();
        bSprite.step();
        replay(aSprite);
        replay(bSprite);
        spriteLayer.frame();
        verify(aSprite);
        verify(bSprite);
    }
}
