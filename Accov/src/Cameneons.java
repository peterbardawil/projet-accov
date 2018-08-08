
/**
 * <h1>Cameneos Class</h1>
 * Ce class est pour creer un objet cameneos avec l'abiliter de donner un
 * identificateur identique et une couleur apres que le cameneos est cree il
 * faut qu'il rencontre sont partnere pour faire une mutation
 *
 * @author Peter Bardawil
 */
public class Cameneons {

    public IdentificateurCameneos id; //chaque cameneon est represente par une couleur unique

    //Pour faire definir une class pour les couleur des cameneon
    public String couleur; //chaque cameneon a sa propre couleur

    public Cameneons(IdentificateurCameneos id, String couleur) {
        this.id = id;
        this.couleur = couleur;
    }

    /**
     * Cette methode est utilise pour donner information sur l'etat de cameneos
     * avec information sur le cameneos
     *
     * @param infoCourant cette parametre est pour donner l'etat courant de
     * cameneos
     */
    public void donnerInformation(String infoCourant) {
        System.out.println("Mon Identificateur est " + this.id + " Mon Couleur est: " + this.couleur + " et " + infoCourant);
    }

    /**
     * Cette methode est utilise dans l'etat quand le cameneos mange
     */
    public void manger() {
        this.donnerInformation("Je suis entrain de manger");
    }

    /**
     * Cette methode est utilise dans l'etat quand le cameneos entraine
     */
    public void entrainer() {
        this.donnerInformation("Je suis entrain d'entrainer");
    }

    /**
     * Cette methode est utilise dans l'etat quand le cameneos aller au mail
     */
    public void allerAuMail() {
        this.donnerInformation("Je veux aller au mail");
    }

    /**
     * Cette methode est utilise dans l'etat quand le cameneos faire un mutation
     */
    public void mutation() {
        this.donnerInformation("je veux faire une mutation");
        //Pour faire savoir le couleur de partenaire
        //Pour faire changer ma couleur
        this.donnerInformation("la mutation est fini");
    }
}
