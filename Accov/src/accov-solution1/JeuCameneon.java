package accov;

/**
 *
 * @author Peter Bardawil
 */
public class JeuCameneon {
    //Groupe De Couleur De Tout Cameneon
    public static Couleur[] groupeCouleurs=
    {
        Couleur.ROUGE,
        Couleur.BLEU,
        Couleur.JAUNE,
        Couleur.BLEU,
        Couleur.ROUGE,
        Couleur.BLEU
    };
    //Les objets cameneon
    public static Cameneons[] groupeCameneons=new Cameneons[groupeCouleurs.length];
    public static void main(String args[]){
        Mail mailCourant=new Mail();
        for(int i =0;i<groupeCouleurs.length;i++){
            groupeCameneons[i]=new Cameneons(mailCourant,new IdentificateurCameneons(i),groupeCouleurs[i]);
            new Thread(groupeCameneons[i]).start();
        }
    }
    
}
