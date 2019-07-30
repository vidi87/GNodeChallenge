package cisco.java.challenge;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class GNodeHandlerTest {
    static GNode A = new GNodeImpl("A", new GNode[3]);

    static GNode B = new GNodeImpl("B", new GNode[2]);
    static GNode E = new GNodeImpl("E", new GNode[0]);
    static GNode F = new GNodeImpl("F", new GNode[0]);

    static GNode C = new GNodeImpl("C", new GNode[3]);
    static GNode G = new GNodeImpl("G", new GNode[0]);
    static GNode H = new GNodeImpl("H", new GNode[0]);
    static GNode I = new GNodeImpl("I", new GNode[0]);

    static GNode D = new GNodeImpl("D", new GNode[0]);

    static GNodeHandler handler  = new GNodeHandlerImpl();

    @BeforeClass
    public static void runOnceBeforeClass() {
        A.getChildren()[0] = B;
        B.getChildren()[0] = E;
        B.getChildren()[1] = F;

        A.getChildren()[1] = C;
        C.getChildren()[0] = G;
        C.getChildren()[1] = H;
        C.getChildren()[2] = I;

        A.getChildren()[2] = D;
    }

    @Test
    public void walkGraphTest() {

        ArrayList list = handler.walkGraph(A);
        GNode Z = new GNodeImpl("Z", null);
        Assert.assertTrue(list.contains(A) && list.contains(B) && list.contains(C) && list.contains(D)
                && list.contains(E) && list.contains(F) && list.contains(G) && list.contains(H) && list.contains(I));
        Assert.assertFalse(list.contains(Z));

        list = handler.walkGraph(C);
        ArrayList<GNode> nodelist = new ArrayList<>();
        nodelist.add(C);
        nodelist.add(G);
        nodelist.add(H);
        nodelist.add(I);
        Assert.assertEquals(list, nodelist);
    }

    @Test
    public void pathTest() {
        ArrayList list = handler.paths(A);
        Assert.assertEquals(list.size(), 6);

        list = handler.paths(C);
        Assert.assertEquals(list.size(), 3);

        list = handler.paths(D);
        Assert.assertEquals(list.size(), 1);
        ArrayList<GNode> nodelist = new ArrayList<>();
        nodelist.add(D);
        Assert.assertEquals(list.get(0),  new ArrayList<>());
    }

}
