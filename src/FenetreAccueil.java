import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 * @author lucas_kaniewski
 *
 */

public class FenetreAccueil extends JFrame implements ActionListener {
	
	// JMenuItem Circuit
	private JMenuItem addFacture;
	private JMenuItem modifFacture;
	private JMenuItem affichageFacture;
	private JMenuItem searchFacture;
	

	
	public FenetreAccueil() {
			
			this.setTitle("BINDER");
	    	this.setLocationRelativeTo(null);
	    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.setSize(800, 600);
	    	this.setResizable(false);
	    	
	    	// Instanciation de la barre de menu
	    	JMenuBar menu= new JMenuBar();
	    	
	    	// Instanciation des "boutons" dans la barre de menu
	    	JMenu menuCircuit = new JMenu("Facture");


	        
	        // Instanciation d'élément du menu Circuit
	        this.affichageFacture = new JMenuItem("Recherche une facture");
	    	this.addFacture = new JMenuItem("Ajouter une facture");
	        this.modifFacture = new JMenuItem("Modifier une facture");
	        this.searchFacture = new JMenuItem("Rechercher une facture");

	       
	
	        
	        // Ajout d'élément au menu Circuit
	        menuCircuit.add(affichageFacture);
	        menuCircuit.add(addFacture);
	        menuCircuit.add(modifFacture);
	        menuCircuit.add(searchFacture);
	        
	        
	        // Ajout des "bouton" menu à la barre de menu
	        menu.add(menuCircuit);

	        
	        
	        // Ecoute des JButton menu circuit 
	        addFacture.addActionListener(this);
	        modifFacture.addActionListener(this);
	        affichageFacture.addActionListener(this);
	        searchFacture.addActionListener(this);
	        
	        // Permet de définir le menu utilisé dans la JFrame
	        this.setJMenuBar(menu);	        
	        this.setAlwaysOnTop(true);
	        this.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* ================================== Debut panel Facture ==================================== */		

			/**
			 * Repaint des panels Facture
			
		
			if(e.getSource().equals(afficherSpectateur)) { 
				this.getContentPane().removeAll();
				this.getContentPane().add(new PanelAfficherSpectateur(Modele.affichageSpectateur()).getMonPanel());
				this.getContentPane().revalidate();
				this.getContentPane().repaint();
			}
			if(e.getSource().equals(ajouterSpectateur)) { 
				this.getContentPane().removeAll();
				this.getContentPane().add(new PanelAjouterSpectateur().getMonPanel());
				this.getContentPane().revalidate();
				this.getContentPane().repaint();
			}
			if(e.getSource().equals(supprimerSpectateur)) { 
				this.getContentPane().removeAll();
				this.getContentPane().add(new PanelSupprimerSpectateur().getMonPanel());
				this.getContentPane().revalidate();
				this.getContentPane().repaint();
			}
			if(e.getSource().equals(rechercherSpectateur)) { 
				this.getContentPane().removeAll();
				this.getContentPane().add(new PanelRechercherSpectateur().getMonPanel());
				this.getContentPane().revalidate();
				this.getContentPane().repaint();
			}
		/* ================================== Fin panel Facture ==================================== */		

			
	}
}