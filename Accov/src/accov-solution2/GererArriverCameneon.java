package accov2;

/**
 * <h1>GererArriverCameneon Class</h1>
 * Ce Class est pour gerer l'arrive de nouveau cameneon qui veut fair le
 * actions: Manger, entrainer, aller au mail et faire la mutation
 *
 * @author Peter Bardawil
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GererArriverCameneon implements Runnable {

    private final PrintWriter ecriture;
    private final BufferedReader lecture;
    private String Couleur;

    /**
     * Constructeur. Gerer l'ecriture est la lecture et l'ecriture de cameneon
     * pour savoir l'info courant de cette cameneon
     *
     * @param lecture Lecteur d'un cameneon message
     * @param ecriture Ecriveur d'un cameneon message
     * @param Couleur Couleur cameneon
     */
    public GererArriverCameneon(BufferedReader lecture, PrintWriter ecriture, String Couleur) {
        this.lecture = lecture;
        this.ecriture = ecriture;
        this.Couleur = Couleur;
    }

    /**
     * Faire tous les action qui faut etre faire par chaque cameneon 
     * client manger,entrainer,aller au mail et faire un mutation
     * 
     */
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Je suis entrain de manger");
                System.out.println("Je suis entrain d'entrainer");
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Je veux aller au mail");
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("je veux faire une mutation Mon couleur est: " + Couleur);
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
                }
                String line;
                this.ecriture.printf("%s\n", Couleur);
                this.ecriture.flush();
                if ((line = this.lecture.readLine()) != null) {
                    this.Couleur = line;
                    System.out.println("la mutation est fini et Mon couleur est: " + Couleur);

                }
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
