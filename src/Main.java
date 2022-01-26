/**
 * 
 * @author lucas_kaniewski | mickael_campos
 *
 */

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException{

		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		FenetreConnexion fenetreConnexion = new FenetreConnexion();
		
		//FenetreAccueil fenetreAccueil = new FenetreAccueil();
		
	}
}