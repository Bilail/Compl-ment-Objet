import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class TestePoint {

    // On pourrait faire col2.containsAll(col1). Cette version permet
    // d'afficher un message si besoin.
    public static boolean testeInclusion(Collection<Point> col1,
					 Collection<Point> col2) {
	for(Point p: col1) {
	    if (! col2.contains(p)) {
		System.out.println("Le point " + p
				   + " est absent de la collection");
		return false;
	    }
	}
	return true;
    }

    public static void main (String[] args) {
	/* TreeSet et HashSet sont deux implementations de l'interface Set.
	 * Un element ne peut donc apparaitre qu'une fois dans un Set
	 * On utilise aussi une autre sorte de Collection (ArrayList) qui
	 * n'impose pas qu'un element n'apparaisse qu'une fois.
         */
	Collection <Point> col1 = new TreeSet<Point>();
	Collection <Point> col2 = new HashSet<Point>();
	Collection <Point> col3 = new ArrayList<Point>();
	Point[] tab = {
	    new Point(),
	    new Point(3.0, 2.0),
	    new Point(2.0, 5.0),
	    new Point(5.0, 2.0),
	    new Point(3.0, 2.0),
	    new Point()
	};

	for(Point p : tab) {
	    col1.add(p);
	    col2.add(p);
	    col3.add(p);
	}

	System.out.println("Taille de col1: " + col1.size());
	System.out.println("Taille de col2: " + col2.size());
	System.out.println("Taille de col3: " + col3.size());

	System.out.println("Test d'inclusion du TreeSet dans le HashSet: ");
	System.out.println(testeInclusion(col1, col2) ? "OK" : "KO");

	System.out.println("Test d'inclusion du HashSet dans le TreeSet: ");
	System.out.println(testeInclusion(col2, col1) ? "OK" : "KO");

	System.out.println("Test d'inclusion de TreeSet dans ArrayList: ");
	System.out.println(testeInclusion(col2, col3) ? "OK" : "KO");

	System.out.println("Test d'inclusion du ArrayList dans le TreeSet: ");
	System.out.println(testeInclusion(col3, col2) ? "OK" : "KO");

	System.out.println("Test d'inclusion de HashSet dans ArrayList: ");
	System.out.println(testeInclusion(col1, col3) ? "OK" : "KO");

	System.out.println("Test d'inclusion du ArrayList dans le HashSet: ");
	System.out.println(testeInclusion(col3, col1) ? "OK" : "KO");

	System.out.println("Egalite entre HashSet et TreeSet: ");
	System.out.println(col1.equals(col2) && col2.equals(col1) ? "OK" : "KO");

    }
}

