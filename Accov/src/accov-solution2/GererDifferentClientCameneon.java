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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GererDifferentClientCameneon implements Runnable{

    private final Cameneons cameneon;
    private final GererListeCameneon listeCameneon;

    public GererDifferentClientCameneon(Socket socket, GererListeCameneon listeCameneon) throws IOException {
        this.cameneon = new Cameneons(socket);
        this.listeCameneon = listeCameneon;
        this.listeCameneon.ajouterCameneonClient(cameneon);
    }

    @Override
    public void run() {

        try {
            System.out.println(this.cameneon.getCameneonClientSocket().getRemoteSocketAddress());
            String line;
            while (!(line = this.cameneon.getLecteur().readLine()).equals(".")) {
                System.out.printf("[TRACE] Color received : %s\n", line);
                if (this.listeCameneon.getCompteClientAttendu() == 0) {
                    this.cameneon.setCouleur(line);
                    this.listeCameneon.setCompteClientAttendu("ajouter");
                } else {
                    this.listeCameneon.mutate(this.cameneon, line);
                }

            }
            this.cameneon.getEcriveur().printf(".\n");
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.listeCameneon.supprimerCameneonDeListe(this.cameneon);
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
