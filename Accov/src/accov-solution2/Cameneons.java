package accov2;

/**
 * <h1>Cameneos Class</h1>
 * Ce class est pour creer un objet cameneos avec l'abiliter de savoir
 * l'info de cameneon de socket et savoir sa couleur
 *
 * @author Peter Bardawil
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cameneons {

    private Socket cameneonClientSocket;
    private String couleur;

    private final BufferedReader lecteur;

    private final PrintWriter ecriveur;

    /**
     * Constructeur.
     *
     * @param socket Attribuer un socket client au cameneon qui veut se
     * connecter
     * @throws java.io.IOException Exception produit par les operation lecture/ecriture
     */
    public Cameneons(Socket socket) throws IOException {
        cameneonClientSocket = socket;
        lecteur = getDonnees(socket);
        ecriveur = getoutput(socket);
        couleur = null;
    }

    /**
     * Cette methode est pour retourner le socket de courant cameneon objet
     *
     * @return Socket
     */
    public Socket getCameneonClientSocket() {
        return this.cameneonClientSocket;
    }

    /**
     * Cette methode est pour determiner le socket de courant cameneon objet
     *
     * @param socket Socket du courant cameneon
     */
    public void setCameneonClientSocket(Socket socket) {
        this.cameneonClientSocket = socket;
    }

    /**
     * Cette methode est pour retourner le socket de courant cameneon objet
     *
     * @return String
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Cette methode est pour determiner le couleur de courant cameneon objet
     *
     * @param Couleur Couleur de cameneon
     */
    public void setCouleur(String Couleur) {
        this.couleur = Couleur;
    }

    /**
     * Cette methode est pour retourner le courant lecteur
     *
     * @return BufferedReader
     */
    public BufferedReader getLecteur() {
        return this.lecteur;
    }

     /**
     * Cette methode est pour retourner le courant ecriveur
     *
     * @return PrintWriter
     */
    public PrintWriter getEcriveur() {
        return this.ecriveur;

    }
    
    
    /**
     * Cette methode est pour lire de socket courant pour savoir couleur 
     *
     * @param socket
     * Retourner BufferedReader
     */
    final BufferedReader getDonnees(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Cette methode est pour ecrire sur le socket courant la couleur
     *
     * @param socket
     * Retourner PrintWriter
     */
    final PrintWriter getoutput(Socket socket) throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }
}
