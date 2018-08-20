/**
 * <h1>Couleur Class</h1>
 * Ce class est pour le management des couleur des cameneon
 *
 * @author Peter Bardawil
 */
public class Couleur {

    public int couleurInterieure;
    private static final int valeurBleu = 0;
    private static final int valeurRouge = 1;
    private static final int valeurJaune = 2;
    public static final Couleur BLEU = new Couleur(valeurBleu);
    public static final Couleur ROUGE = new Couleur(valeurRouge);
    public static final Couleur JAUNE = new Couleur(valeurJaune);

    public Couleur(int valeurDeCouleur) {
        this.couleurInterieure = valeurDeCouleur;
    }

     /**
     * Cette methode est utilise pour change le couleur de cameneon
     */
    public Couleur changerCouleur(Couleur autreCameneonCouleur) {
        if (this.couleurInterieure == autreCameneonCouleur.couleurInterieure) {
            return new Couleur(this.couleurInterieure);
        }
        return new Couleur(3 - this.couleurInterieure - autreCameneonCouleur.couleurInterieure);
    }
    
    @Override
    public String toString(){
        if(this.couleurInterieure==valeurBleu){
            return "Bleu";
        }
        else if(this.couleurInterieure==valeurRouge){
            return "Rouge";
        }
        return "Jaune";
    }

}
