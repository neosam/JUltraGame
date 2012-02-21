import com.gollersoft.jultragame.binding.swing.UGSwing;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.layer.UGLayer;
import com.gollersoft.jultragame.layer.UGLayerList;
import org.easymock.IMocksControl;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.*;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/21/12
 * Time: 8:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGLayerListTest {
    private UGLayerList layerList;

    @Before
    public void setUp() throws Exception {
        layerList = new UGLayerList(new UGSwing(1, 1));
    }

    @org.junit.Test
    public void testDraw() throws Exception {
        IMocksControl ctrl = createStrictControl();
        UGLayer layer1Mock = ctrl.createMock(UGLayer.class);
        UGLayer layer2Mock = ctrl.createMock(UGLayer.class);
        UGGraphics graphicsMock = createMock(UGGraphics.class);
        layer1Mock.draw(graphicsMock);
        layer2Mock.draw(graphicsMock);
        ctrl.replay();
        layerList.add(layer1Mock);
        layerList.add(layer2Mock);
        layerList.draw(graphicsMock);
        ctrl.verify();
    }

    @org.junit.Test
    public void testFrame() throws Exception {
        IMocksControl ctrl = createStrictControl();
        UGLayer layer1Mock = ctrl.createMock(UGLayer.class);
        UGLayer layer2Mock = ctrl.createMock(UGLayer.class);
        layer1Mock.frame();
        layer2Mock.frame();
        ctrl.replay();
        layerList.add(layer1Mock);
        layerList.add(layer2Mock);
        assertEquals("Layer list should be of size 2", 2, layerList.size());
        layerList.frame();
        ctrl.verify();

    }
}
