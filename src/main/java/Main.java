
import com.gabrielejose.arquiteturasoftware.bancodedados.AcessaBD;
import com.gabrielejose.arquiteturasoftware.gui.TelaPrincipal;

public class Main {
    
    public static void main(String[] args) {
        AcessaBD bd = new AcessaBD();
        bd.criaTabelas();
        new TelaPrincipal().setVisible(true);
    }
}
