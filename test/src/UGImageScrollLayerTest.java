import com.gollersoft.jultragame.core.display.UGCamera;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.core.display.UGImage;
import com.gollersoft.jultragame.layer.UGImageScrollLayer;

import static org.easymock.EasyMock.*;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/21/12
 * Time: 7:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGImageScrollLayerTest {
    @org.junit.Test
    public void testDraw() throws Exception {
        final UGImage imageMock = createMock(UGImage.class);
        final UGCamera cameraMock = createMock(UGCamera.class);
        final UGGraphics graphicsMock = createStrictMock(UGGraphics.class);
        cameraMock.x = 40;
        cameraMock.y = 24;
        graphicsMock.drawImage(imageMock, -40, -24);
        replay(graphicsMock);
        final UGImageScrollLayer scrollLayer = new UGImageScrollLayer(imageMock, cameraMock);
        scrollLayer.draw(graphicsMock);
    }
}
