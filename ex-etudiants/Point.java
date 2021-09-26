public class Point implements Comparable<Point> {

    public Point() { this(0.0, 0.0); }

    public Point(double x, double y) { 
	this.x = x; this.y = y;
    }

    public double getX() { return x; }

    public double getY() { return y; }

    /* On implemente Comparable<Point> donc on definit un compareTo qui prend
     * un Point en parametre
     * Relation totale d'ordre sur Point: extension lexicographique
     * de la relation d'ordre sur les doubles.
     * Cette definition est coherente par rapport a equals :
     * p1.compareTo(p2) == 0 ssi p1.equals(p2)
     * La seule difference est que compareTo prend un Point en argument et
     * leve NullPointerException si son argument est null.
     */
    public int compareTo(Point p) {
        // System.out.println("On est dans compareTo de Point");
	if (this == p) return 0; /* test rapide qui ne mange pas de pain ! */
	if (x < p.x) return -1;
	else if (x > p.x) return +1;
	else if (y < p.y) return -1;
	else if (y > p.y) return +1;
	else return 0;
    }

    /** deux points sont egaux s'ils ont meme coordonnees */
    public boolean equals(Object o) {
        // System.out.println("On est dans equals de Point");
	if (o == null) return false;
	if (o == this) return true;
	if (o instanceof Point) {
	    Point D = (Point) o;
	    return D.x == x && D.y == y;
	} else { return false; }
    }

    // Lors d'une comparaison dans un HashSet, il faut redéfinir la fonction HashCode()
    @Override
    public int hashCode() {
        int c = 0;
        c = (int) x * 1000 + (int) y * 2000;
        return c;
    }

    public String toString() {
	return "(" + x + ", " + y + ")";
    }

    protected double x;
    protected double y;
}
