import org.junit.*;
import static org.junit.Assert.*;

public class ComplementsCercleTest {
    
    @Test
    public void testSetDiametre() {
        Cercle c = new Cercle(new Point(0,0), 1);
        c.setDiametre(4);
        assertEquals("erreur du diametre", 2.0, c.getRayon(), 0.001);
    }

    @Test
    public void testTranslater() {
        Cercle c = new Cercle(new Point(0,0), 1);
        c.translater(1, 2);
        assertEquals("erreur centre x", 1.0, c.getCentre().getX(), 0.001);
        assertEquals("erreur centre y", 2.0, c.getCentre().getY(), 0.001);
    }

    @Test
    public void testContient() {
        Cercle c = new Cercle(new Point(0,0), 1);
        Point p1 = new Point(0, 0.5); // inside
        Point p2 = new Point(0, 2); // outside
    assertTrue("point devrait etre contenu", c.contient(p1));
        assertFalse("point ne devrait pas etre contenu", c.contient(p2));
    }
}