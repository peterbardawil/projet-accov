/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accov2;

/**
 *
 * @author bachir
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GererListeCameneon {

    List<Cameneons> listeCameneon;
    int compteClientAttendu;

    public GererListeCameneon() {
        listeCameneon = new ArrayList<>();
        compteClientAttendu = 0;
    }

    public void ajouterCameneonClient(Cameneons cameneonClient) {
        listeCameneon.add(cameneonClient);
    }

    public int getCompteClientAttendu() {
        return this.compteClientAttendu;
    }

    public void setCompteClientAttendu(String methode) {
        if (methode.equals("ajouter")) {
            this.compteClientAttendu++;
        } else {
            this.compteClientAttendu--;
        }
    }

    public void supprimerCameneonDeListe(Cameneons c) throws IOException {
        c.getLecteur().close();
        c.getEcriveur().close();
        c.getCameneonClientSocket().close();
        listeCameneon.remove(c);
    }

    public synchronized void mutate(Cameneons icc, String Couleur) {
        for (Cameneons ic : listeCameneon) {
            if (ic.getCouleur() != null) {
                if (ic.getCouleur().equals(Couleur)) {
                    ic.getEcriveur().println(Couleur);
                    icc.getEcriveur().println(Couleur);
                    System.out.println("la mutation est fini Mon couleur est:" + Couleur);
                    ic.setCouleur(null);
                    this.setCompteClientAttendu("diminuer");
                } else if ((Couleur.equals("Rouge") && ic.getCouleur().equals("Bleu")) || (Couleur.equals("Bleu") && ic.getCouleur().equals("Rouge"))) {
                    ic.getEcriveur().println("Jaune");
                    icc.getEcriveur().println("Jaune");
                    System.out.println("la mutation est fini Mon couleur est:" + "Jaune");
                    ic.setCouleur(null);
                    this.setCompteClientAttendu("diminuer");
                } else if ((Couleur.equals("Jaune") && ic.getCouleur().equals("Bleu")) || (Couleur.equals("Bleu") && ic.getCouleur().equals("Jaune"))) {
                    ic.getEcriveur().println("Rouge");
                    icc.getEcriveur().println("Rouge");
                    System.out.println("la mutation est fini Mon couleur est:" + "Rouge");
                    ic.setCouleur(null);
                    this.setCompteClientAttendu("diminuer");
                } else if ((Couleur.equals("Jaune") && ic.getCouleur().equals("Rouge")) || (Couleur.equals("Rouge") && ic.getCouleur().equals("Jaune"))) {
                    ic.getEcriveur().println("Bleu");
                    icc.getEcriveur().println("Bleu");
                    System.out.println("la mutation est fini Mon couleur est:" + "Bleu");
                    ic.setCouleur(null);
                    this.setCompteClientAttendu("diminuer");
                }

            }
        }
    }
}
