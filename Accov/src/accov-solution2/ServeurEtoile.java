package accov2;

/**
 * <h1>ServeurEtoile Class</h1>
 * Ce class est pour gerer tout les cameneon qui veulent connecter pour faire la
 * mutation avec les cameneon qui sont connecter avec le serveur
 *
 * @author Peter Bardawil
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurEtoile {

    final static int PORT = 1323;

    public static void main(String[] args) throws IOException {

        GererListeCameneon listeCameneon = new GererListeCameneon();
        gererServeur(listeCameneon);
    }

    /**
     * Cette methode est pour gerer la creation de serveur socket Le serveur
     * socket est cree sur la port 1323 qu'il faut etre connecter par le client
     * socket
     *
     * @throws java.io.IOException
     */
    public static void gererServeur(GererListeCameneon listeCameneon) throws IOException {
        ServerSocket serveurSocket = new ServerSocket(PORT);
        System.out.println(serveurSocket.getLocalSocketAddress());
        while (true) {
            Socket serviceSocket = serveurSocket.accept();
            Thread nc = new Thread(new GererDifferentClientCameneon(serviceSocket, listeCameneon));
            nc.setDaemon(true);
            nc.start();
        }

    }
}
