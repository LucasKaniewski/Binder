import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * @author lucas_kaniewski | mickael_campos
 *
 */

public class PanelAjouterFacture extends JPanel implements ActionListener {
	
	//JPanel
	private JPanel monPanelGlobal;
	
	// JMenuItem 
	private JMenuItem creeFacture;
	private JMenuItem ajouterTache;
	private JMenuItem supprElement;
	private JMenuItem modifierFacture;
	
	//JLabel
	private JLabel lblLieu;
	private JLabel lblDate;
	private JLabel lblNomClient;
	private JLabel lblAdrClient;
	private JLabel lblVilleClient;
	private JLabel lblCodePostale;
	
	//JTextField
	private JTextField jtfLieu;
	private JTextField jtfNomClient;
	private JTextField jtfAdrClient;
	private JTextField jtfVilleClient;
	private JTextField jtfCodePostale;
	
	//JButton
	private JButton btnValider;
	
	public PanelAjouterFacture() {
		
	   	this.setSize(800, 600);
    	
		// Instanciation du panel
        this.monPanelGlobal = new JPanel();
        
        // Set Layout des panel
        this.monPanelGlobal.setLayout(new FlowLayout());  
        this.monPanelGlobal.setLayout(new GridLayout(13, 1));
        
        // Instanciation JLabel
        this.lblLieu = new JLabel("Lieu ");
        this.lblDate = new JLabel("Nom du Circuit : ");
        this.lblNomClient = new JLabel("Pays : ");
        this.lblAdrClient = new JLabel("Taille du circuit en km²: ");
        this.lblVilleClient = new JLabel("Pays : ");
        this.lblCodePostale = new JLabel("Taille du circuit en km²: ");
		       
        //JTextField
		this.jtfLieu = new JTextField("");
		this.jtfNomClient = new JTextField("");
		this.jtfAdrClient = new JTextField("");
		this.jtfVilleClient = new JTextField("");
		this.jtfCodePostale = new JTextField("");
        
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
		
	    // Ajout des éléments au panel 		
	 	this.monPanelGlobal.add(lblLieu, BorderLayout.CENTER);
	 	this.monPanelGlobal.add(jtfLieu, BorderLayout.CENTER);
	 	this.monPanelGlobal.add(lblDate, BorderLayout.CENTER);
	 	//this.monPanelGlobal.add(jtfDate, BorderLayout.CENTER);
	 	this.monPanelGlobal.add(lblNomClient, BorderLayout.CENTER);
	 	this.monPanelGlobal.add(jtfNomClient, BorderLayout.CENTER);
	 	this.monPanelGlobal.add(lblAdrClient, BorderLayout.CENTER);
	 	this.monPanelGlobal.add(jtfAdrClient, BorderLayout.CENTER);
	 	this.monPanelGlobal.add(jtfNomClient, BorderLayout.CENTER);
	 	this.monPanelGlobal.add(lblAdrClient, BorderLayout.CENTER);
	 	this.monPanelGlobal.add(btnValider, BorderLayout.SOUTH);        
	 			
	    
	    //JButton
		this.btnValider = new JButton ("Ajouter la facture");
		this.btnValider.addActionListener(this);
	    
	    this.setVisible(true);
	    
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

