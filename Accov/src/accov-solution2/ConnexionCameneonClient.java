package accov2;

/**
 * <h1>ConnexionCameneonClient Class</h1>
 * Ce class est pour connecter la nouvelle cameneon qui arrive au serveur pour
 * qu'ont peut ajouter cette nouveau cameneon au liste des cameneon qui sont
 * deja dans la liste des cameneon
 *
 * @author Peter Bardawil
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnexionCameneonClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = null;
        String couleurCameneonCourant = "";
        try {
            socket = new Socket("localhost", ServeurEtoile.PORT);
            System.out.println(socket.getLocalSocketAddress());
            BufferedReader lecteur = getLecture(socket);
            PrintWriter ecriveur = getEcriture(socket);
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Choisir Un couleur pour la cameneon qui veut connecter:");
                System.out.println("Choisir un de couleurs: Jaune, Rouge, Bleu");
                couleurCameneonCourant = capitalizerPremierLetter(sc.nextLine());
            } while (!couleurExiste(couleurCameneonCourant));
            Thread lireSockStdOut = new Thread(new GererArriverCameneon(lecteur, ecriveur, couleurCameneonCourant));
            lireSockStdOut.start();
            lireSockStdOut.join();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    /**
     * Faire lire du socket
     *
     * @param socket
     *
     */
    private static BufferedReader getLecture(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Faire ecrire sure socket
     *
     * @param socket
     *
     */
    private static PrintWriter getEcriture(Socket socket) throws IOException {

        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    /**
     * Savoire sur le courant couleur existe
     *
     * @param couleur Couleur entrer par le cameneon client
     * @return Boolean
     */
    public static boolean couleurExiste(String couleur) {
        return (couleur.equals("Rouge") || couleur.equals("Jaune") || couleur.equals("Bleu"));
    }

    /**
     * capitalizer la premiere lettre du mot
     *
     * @param couleur Couleur entrer par le cameneon client
     * @return String
     */
    public static String capitalizerPremierLetter(String couleur) {
        if (couleur == null || couleur.length() == 0) {
            return couleur;
        }
        return couleur.substring(0, 1).toUpperCase() + couleur.substring(1);
    }
}
