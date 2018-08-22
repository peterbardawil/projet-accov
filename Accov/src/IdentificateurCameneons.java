package accov;
/**
 * <h1>IdentificateurCameneos Class</h1>
 * Ce class est pour donner un identite unique au cameneos
 *
 * @author Peter Bardawil
 */
public class IdentificateurCameneons {
    private final int id;
    public IdentificateurCameneons(int id)
    {
        this.id=id;
    }
    public String toString(){
        return "Cameneon-"+this.id;
    }
}
