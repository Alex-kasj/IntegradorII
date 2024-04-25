
package ConcreteStrategy;

/**
 *
 * @author alex
 */
public class Logearse {
    private Interfaz.IUsuario iUsuario;
    
    public void setIUsuario(Interfaz.IUsuario iUsuario){
        this.iUsuario = iUsuario;
    }
    
    public String login(){
        return this.iUsuario.login();
    }
}
