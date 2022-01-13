import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * @author lucas_kaniewski | mickael_campos
 *
 */

public class FenetreAccueil extends JFrame implements ActionListener {
	
	// JMenuItem 
	private JMenuItem creeFacture;
	private JMenuItem ajouterTache;
	private JMenuItem supprElement;
	private JMenuItem modifierFacture;
	

	
	public FenetreAccueil() {
			
			this.setTitle("BINDER");
			this.setLocationRelativeTo(null);
	    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.setSize(800, 600);
	    	this.setResizable(false);
	    	
	    	// Instanciation de la barre de menu
	    	JMenuBar menu= new JMenuBar();
	    	
	    	// Instanciation des "boutons" dans la barre de menu
	    	JMenu menuCreation = new JMenu("Facture");
	        
	        // Instanciation d'élément du menu Facture
	        this.creeFacture = new JMenuItem("Créer une facture");
	    	this.ajouterTache = new JMenuItem("Ajouter une tâche");
	        this.supprElement = new JMenuItem("Supprimer un élément");
	        this.modifierFacture = new JMenuItem("Modifier une facture");
	               
	        // Ajout d'élément au menu Facture
	        menuCreation.add(creeFacture);
	        menuCreation.add(ajouterTache);
	        menuCreation.add(supprElement);
	        menuCreation.add(modifierFacture);
	        
	        
	        // Ajout des "bouton" menu à la barre de menu
	        menu.add(menuCreation);

	        
	        
	        // Ecoute des JButton menu circuit 
	        creeFacture.addActionListener(this);
	        ajouterTache.addActionListener(this);
	        supprElement.addActionListener(this);
	        modifierFacture.addActionListener(this);
	        
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
			
		
			if(e.getSource().equals(creeFacture)) { 
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