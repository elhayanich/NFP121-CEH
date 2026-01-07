import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Color;

public class CercleTest {
    
    @Test
    public void testerE12_DeuxPoints() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Cercle c = new Cercle(p1, p2);
        assertEquals("erreur du rayon", 2.0, c.getRayon(), 0.001);
        assertEquals("erreur centre x", 2.0, c.getCentre().getX(), 0.001);
    }

    @Test
    public void testerE13_DeuxPointsCouleur() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 3);
        Cercle c = new Cercle(p1, p2, Color.GREEN);
        assertEquals(Color.GREEN, c.getCouleur());
        assertEquals(1.0, c.getRayon(), 0.001);
    }

    @Test
//testE14 à faire 