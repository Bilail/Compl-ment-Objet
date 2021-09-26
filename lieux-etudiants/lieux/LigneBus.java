package lieux;
import java.util.ArrayList;

public class LigneBus {
    protected String nomLigne;
    protected ArrayList<Arret> sesArrets;
    protected Heure[] sesDeparts;
    protected Heure[] sesTemps;

    public LigneBus(String nom) { nomLigne = nom; }

    public void addArrets(Arret[] lesArrets) {
        sesArrets = new ArrayList<Arret>();
        for(Arret a : lesArrets) {
            a.ajoutLigne(this);
            sesArrets.add(a);
        }
    }

    public String nom() { return nomLigne; }

    /* pour simplifier on suppose que les durees de deplacement sont
     * independantes de l'heure. Pour definir les horaires il suffit de donner
     * les heures de depart ainsi que les durees entre 2 arrets successifs.
     * La dimension du tableau des horaires doit etre egale au nombre d'arrets
     * de la ligne moins 1.
     *
     * Attention: une ligne de bus est orientee. Les horaires sont donnes dans
     * le sens de parcours. Si on veut aussi pouvoir parcourir une ligne dans
     * l'autre sens, il faut creer une deuxieme ligne !
     * On suppose enfin que les lignes ne sont pas circulaires,
     */
    public void ajoutHoraires(Heure[] horaire, Heure[] hdepart)
        throws ErreurTrajet {
        if (horaire.length != sesArrets.size() - 1) {
            throw new ErreurTrajet("Horaire mal formatte");
        }
        sesDeparts = hdepart;
        sesTemps = horaire;
    }

    public ArrayList<Heure> horaireArret(Arret a){
        int i = sesArrets.lastIndexOf(a);
        ArrayList<Heure> h = new ArrayList<Heure>() ;
        for (Heure d : sesDeparts) {
            Heure acc = d;
            int l = sesArrets.indexOf(a);
            int it = 0;
            for (Heure t : sesTemps)
                if (it < l){
                    acc = acc.add(t);
                    it ++;
            }
            else {h.add(acc);}
        }

        return h;
    }

    public boolean estPossible(Arret a1, Arret a2, Heure dep) {
        //throw new UnsupportedOperationException();
        if (!sesArrets.contains(a1) || !sesArrets.contains(a2)) return false;
        else {
            int i1 = sesArrets.lastIndexOf(a1);

        }
    return false;
    }

    // On suppose que la duree de transport entre deux arrets ne depend pas
    // de l'heure et qu'on n'arrive jamais le lendemain du jour de depart.
    public Heure dureeEnBus(Arret a1, Arret a2) throws ErreurTrajet {
        throw new UnsupportedOperationException();
    }

    public Heure attente(Arret a, Heure h) throws ErreurTrajet {
        throw new UnsupportedOperationException();
    }
}
