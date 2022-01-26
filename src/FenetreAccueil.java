/**
 * 
 * @author lucas_kaniewski | mickael_campos
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetreAccueil extends JFrame implements ActionListener {
	//Panel
	private JPanel monPanel;
	
	// JMenuBar
	private JMenuBar menu;
	
	// JMenu
	private JMenu menuCreation;
	private JMenu menuRecherche;
	private JMenu menuAfficher;
	private JMenu menuAdmin;
	
	// JMenuItem 
	private JMenuItem creeFacture;
	private JMenuItem ajouterTache;
	private JMenuItem supprElement;
	private JMenuItem supprFacture;

	private JMenuItem parNum;
	private JMenuItem parNom;
	private JMenuItem parDate;

	private JMenuItem plusRecent;
	private JMenuItem plusAncien;

	private JMenuItem info;
	private JMenuItem modifInfo;
	
	//fond
    private ImageIcon imgIcon;
    private JLabel img;
	
	public FenetreAccueil() {
			
		this.setTitle("SARL BINDER - Gestion des factures");
		this.setLocationRelativeTo(null);
	   	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	this.setSize(1000, 800);
        this.setLocation(500, 150);
	    this.setResizable(false);
		// icone windows
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\campo\\git\\Binder\\logo.png");  
	    this.setIconImage(icon);
	    
		Font f2 = new Font("Sherif", Font.BOLD, 20);
	    
	    //Panel
        this.monPanel = new JPanel();
		this.monPanel.setBackground(new Color(58, 58, 68));
        
	    // Instanciation de la barre de menu
	    this.menu = new JMenuBar();
	    	
	    // Instanciation des différents sections du menu
	    this.menuCreation = new JMenu("Création / Ajout / Modification");
		this.menuCreation.setFont(f2);
	    this.menuRecherche = new JMenu("Rechercher");
		this.menuRecherche.setFont(f2);
	    this.menuAfficher = new JMenu("Afficher");
		this.menuAfficher.setFont(f2);
	    this.menuAdmin = new JMenu("Administration");
		this.menuAdmin.setFont(f2);
	        
	    // Instanciation des éléments du menu
	    this.creeFacture = new JMenuItem("Créer une facture");
		this.creeFacture.setFont(f2);
	    this.ajouterTache = new JMenuItem("Ajouter une tâche");
		this.ajouterTache.setFont(f2);
	    this.supprElement = new JMenuItem("Supprimer un élément");
		this.supprElement.setFont(f2);
	    this.supprFacture = new JMenuItem("Supprimer une facture");
		this.supprFacture.setFont(f2);

	    this.parNum = new JMenuItem("Par N° de facture");
		this.parNum.setFont(f2);
	    this.parNom = new JMenuItem("Par nom du client");
		this.parNom.setFont(f2);
	    this.parDate = new JMenuItem("Par date");
		this.parDate.setFont(f2);

	    this.plusRecent = new JMenuItem("Le plus récent");
		this.plusRecent.setFont(f2);
	    this.plusAncien = new JMenuItem("Le plus ancien");
		this.plusAncien.setFont(f2);

	    this.info = new JMenuItem("Informations");
		this.info.setFont(f2);
	    this.modifInfo = new JMenuItem("Modifier les informations");
		this.modifInfo.setFont(f2);
	               
	    // Ajout d'élément au menu Facture
	    this.menuCreation.add(creeFacture);
	    this.menuCreation.add(ajouterTache);
	    this.menuCreation.add(supprElement);
	    this.menuCreation.add(supprFacture);

	    this.menuRecherche.add(parNum);
	    this.menuRecherche.add(parNom);
	    this.menuRecherche.add(parDate);

	    this.menuAfficher.add(plusRecent);
	    this.menuAfficher.add(plusAncien);

	    this.menuAdmin.add(info);
	    this.menuAdmin.add(modifInfo);

	        
	        
	    // Ajout des "bouton" menu à la barre de menu
	    this.menu.add(menuCreation);
	    this.menu.add(menuRecherche);
	    this.menu.add(menuAfficher);
	    this.menu.add(menuAdmin);

	        
	        
	    // Ecoute des JButton menu circuit 
	    this.creeFacture.addActionListener(this);
	    this.ajouterTache.addActionListener(this);
	    this.supprElement.addActionListener(this);
	    this.supprFacture.addActionListener(this);

	    this.parNum.addActionListener(this);
	    this.parNom.addActionListener(this);
	    this.parDate.addActionListener(this);

	    this.plusRecent.addActionListener(this);
	    this.plusAncien.addActionListener(this);

	    this.info.addActionListener(this);
	    this.modifInfo.addActionListener(this);
	    
	    
	    this.imgIcon = new ImageIcon("C:\\Users\\campo\\git\\Binder\\logo.png");
	    this.img = new JLabel();
        this.img.setIcon(this.imgIcon);
        this.monPanel.add(this.img);
	    
	    // Permet de définir le menu utilisé dans la JFrame
	    this.setJMenuBar(this.menu);
	    this.getContentPane().add(this.monPanel);
	    this.setAlwaysOnTop(true);
	    this.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(creeFacture)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelCreationFacture().getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(ajouterTache)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelAjouterTache().getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(supprElement)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelSupprimerElement().getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(supprFacture)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelSupprimerFacture().getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(parNum)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelRecherche("parNum").getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(parNom)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelRecherche("parNom").getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(parDate)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelRecherche("parDate").getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(plusRecent)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelAffichage("plusRecent").getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(plusAncien)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelAffichage("plusAncien").getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(info)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelInformation().getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}else if(e.getSource().equals(modifInfo)) { 
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelModifInformation().getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}
	}
}