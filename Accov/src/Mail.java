package accov;
/**
 * 
 * <h1>Mail Class</h1>
 *
 * @author Peter Bardawil
 */
public class Mail {

    public Couleur premiereCouleur, deuxiemeCouleur;//Les couleur des cameneon partenaire
    public Boolean premiereAppelCameneon = true;//l'arrive de premiere Thread cameneon
    public Boolean fautAttendre = false;//flag pour savoir quand le mail contient deux cameneon

    /**
     * Cette methode est utilise pour faire le cooperation entre les cameneon
     */
    public synchronized Couleur Cooperation(IdentificateurCameneons identificateur, Couleur couleur) {
        Couleur nouveauCouleur;
        //Fait tout les autre cameneon attendre si le mail contient deux cameneon partenaire
        while (fautAttendre) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        if (this.premiereAppelCameneon) {
            this.premiereCouleur = couleur;
            this.premiereAppelCameneon = false;
            while (!this.premiereAppelCameneon) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            this.fautAttendre=false;
            nouveauCouleur=this.deuxiemeCouleur;
            notifyAll();
        }
        else{
            this.deuxiemeCouleur=couleur;
            nouveauCouleur=this.premiereCouleur;
            this.premiereAppelCameneon=true;
            this.fautAttendre=true;
            notifyAll();
        }
        return nouveauCouleur;
    }
}
