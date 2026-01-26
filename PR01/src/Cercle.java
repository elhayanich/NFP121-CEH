import java.awt.Color;

/**
 * Classe Cercle 
 */
public class Cercle implements Mesurable2D {

    /**PI */
    public static final double PI = Math.PI;

    //encapsulation
    private Point centre;
    private double rayon;
    private Color couleur;

    /**
     * Constructeur à partir d'un centre et du rayon
     * @param centre centre
     * @param rayon rayon
     */
    public Cercle(Point centre, double rayon) {
        assert centre != null; //preconditio
        assert rayon > 0;
        //Copie défensive
        this.centre = new Point(centre.getX(), centre.getY());
        this.rayon = rayon;
        this.couleur = Color.blue;
    }

    /**
     * Constructeur à partir de 2points diamétralement opposé
     * @param p1 
     * @param p2 
     */
    public Cercle(Point p1, Point p2) {
        this(p1, p2, Color.blue);
    }

    /**
     * constructeur à partir de deux points diamétralement opposés et d'une couleur
     */
    public Cercle(Point p1, Point p2, Color couleur) {
        assert p1 != null && p2 != null;
        assert p1.distance(p2) > 0;
        assert couleur != null;
        
        double mx = (p1.getX() + p2.getX()) / 2;
        double my = (p1.getY() + p2.getY()) / 2;
        this.centre = new Point(mx, my);
        this.rayon = p1.distance(p2) / 2;
        this.couleur = couleur;
    }

    /**
     * méthode pour créer un cercle 
     */
    public static Cercle creerCercle(Point centre, Point circonference) {
        assert centre != null && circonference != null;
        assert centre.distance(circonference) > 0;
        double r = centre.distance(circonference);
        return new Cercle(centre, r);
    }

    //getters
    
    public Point getCentre() {
        // ici pour proteger le cente j'ai mis (à completer aprè)
        Point pt = new Point(this.centre.getX(), this.centre.getY());
        return pt;
    }

    public double getRayon() { return this.rayon; }
    public double getDiametre() { return this.rayon * 2; }
    public Color getCouleur() { return this.couleur; }

    //setters

    public void setCouleur(Color nouvelleCouleur) {
        assert nouvelleCouleur != null;
        this.couleur = nouvelleCouleur;
    }

    public void setRayon(double nouveauRayon) {
        assert nouveauRayon > 0;
        this.rayon = nouveauRayon;
    }

    public void setDiametre(double nouveauDiametre) {
        assert nouveauDiametre > 0;
        this.rayon = nouveauDiametre / 2;
    }

    //méthodes de calcule

    public void translater(double dx, double dy) {
        this.centre.translater(dx, dy);
    }

    public boolean contient(Point p) {
        assert p != null;
        return this.centre.distance(p) <= this.rayon;
    }

    @Override
    public double perimetre() { return 2 * PI * this.rayon; }

    @Override
    public double aire() { return PI * this.rayon * this.rayon; }

    /** afichage cercle terminal - à faire */
    @Override
    public String toString() {
        return "C"+this.rayon + "@" + this.centre;
    }
}