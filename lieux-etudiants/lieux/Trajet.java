package lieux;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class Trajet {
    private String nom;
    private Lieu depart;
    private Lieu arrivee;
    private Heure dateDepart;
    private ArrayList<Etape> sesEtapes;

    public Trajet(String n, Lieu dep, Lieu arr, Heure d,
                  ArrayList<Etape> etapes) {
        nom = n;
        depart = dep;
        arrivee = arr;
        dateDepart = d;
        sesEtapes = etapes;
    }

    public String nom() { return nom; }

    public Lieu depart() { return depart; }

    public Lieu arrivee() { return arrivee; }

    public void liste() {
        System.out.println("Trajet " + nom + " de " + depart.nom() + " a " 
                           + arrivee.nom() + ", depart a " + dateDepart + " :");
        for(Etape e: sesEtapes) e.liste();
    }

    public boolean estCoherent() {
        //throw new UnsupportedOperationException();
        for (Etape e : sesEtapes) {
            if (!e.estPossible()) return false;
        }
        return true;
    }

    public Heure hArrivee() throws ErreurTrajet {
        //throw new UnsupportedOperationException();
        Heure ha = dateDepart;
        for (Etape e : sesEtapes) {
           ha.add(e.duree());
        }
        return ha;
    }

    public Heure duree() throws ErreurTrajet {
        //throw new UnsupportedOperationException();
        Heure d = null;
        for (Etape e : sesEtapes) {
            d.add(e.duree());
        }
        return d;
    }

    public Heure attente() throws ErreurTrajet {
        throw new UnsupportedOperationException();
    }

    public int nbChgt() throws ErreurTrajet {
        //throw new UnsupportedOperationException();
        return sesEtapes.size();
    }

    public static Trajet meilleur(Collection<Trajet> col, Comparateur comp)
    throws ErreurTrajet {
        throw new UnsupportedOperationException();
    }

}
