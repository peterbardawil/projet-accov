package accov2;

/**
 * <h1>GererListeCameneon Class</h1>
 * Ce Class est pour gerer les courant cameneon qui sont connecter a la serveur
 * etoile
 *
 * @author Peter Bardawil
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GererListeCameneon {

    List<Cameneons> listeCameneon;
    int compteClientAttendu;

    /**
     * Constructeur.
     *
     * initializer un liste par default a premier demarre
     */
    public GererListeCameneon() {
        listeCameneon = new ArrayList<>();
        compteClientAttendu = 0;
    }

    /**
     * Cette methode est pour retourner nombre client attendu
     *
     * @return int
     */
    public int getCompteClientAttendu() {
        return this.compteClientAttendu;
    }

    /**
     * Cette methode est pour modifier la nombre client attendu
     *
     * @param methode Pour savoir si il faut ajouter ou diminuer le nombre cameneon attendu
     */
    public void setCompteClientAttendu(String methode) {
        if (methode.equals("ajouter")) {
            this.compteClientAttendu++;
        } else {
            this.compteClientAttendu--;
        }
    }

    /**
     * Cette methode est pour ajouter un client cameneon a la liste
     *
     * @param cameneonClient Objet cameneon veut connecter
     */
    public void ajouterCameneonClient(Cameneons cameneonClient) {
        listeCameneon.add(cameneonClient);
    }

    /**
     * Cette methode est pour supprimer un client cameneon de la liste
     *
     * @param cameneon Objet Cameneon
     * @throws java.io.IOException Exception produit par les operation lecture/ecriture
     */
    public void supprimerCameneonDeListe(Cameneons cameneon) throws IOException {
        cameneon.getLecteur().close();
        cameneon.getEcriveur().close();
        cameneon.getCameneonClientSocket().close();
        listeCameneon.remove(cameneon);
    }

    /**
     * Cette methode est pour faire la mutation entre les deux cameneon client
     *
     * @param autreCameneon Objet Cameneon
     * @param Couleur La couleur de cameneon
     */
    public synchronized void faireMutation(Cameneons autreCameneon, String Couleur) {
        this.listeCameneon.stream().filter((cameneon) -> (cameneon.getCouleur() != null)).forEach((cameneon) -> {
            if (cameneon.getCouleur().equals(Couleur)) {
                this.gererMutation(cameneon, autreCameneon, Couleur);
            } else if ((Couleur.equals("Rouge") && cameneon.getCouleur().equals("Bleu")) || (Couleur.equals("Bleu") && cameneon.getCouleur().equals("Rouge"))) {
                this.gererMutation(cameneon, autreCameneon, "Jaune");
            } else if ((Couleur.equals("Jaune") && cameneon.getCouleur().equals("Bleu")) || (Couleur.equals("Bleu") && cameneon.getCouleur().equals("Jaune"))) {
                this.gererMutation(cameneon, autreCameneon, "Rouge");
            } else if ((Couleur.equals("Jaune") && cameneon.getCouleur().equals("Rouge")) || (Couleur.equals("Rouge") && cameneon.getCouleur().equals("Jaune"))) {
                this.gererMutation(cameneon, autreCameneon, "Bleu");
            }
        });
    }
    
     /**
     * Cette methode est pour gerer la courant mutation entre les deux cameneon
     *
     * @param cameneon Objet cameneon
     * @param autreCameneon La couleur d'un autre cameneon
     * @param couleur La couleur de cameneon
     */
    public void gererMutation(Cameneons cameneon, Cameneons autreCameneon, String couleur) {
        cameneon.getEcriveur().println(couleur);
        autreCameneon.getEcriveur().println(couleur);
        System.out.println("la mutation est fini et Mon couleur est:" +couleur);
        cameneon.setCouleur(null);
        this.setCompteClientAttendu("diminuer");
    }
}
