/**
 * 
 * @author lucas_kaniewski | mickael_campos
 *
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FenetreConnexion extends JFrame implements ActionListener{

	//les panels
 	private JPanel monPanelGlobal;
    private JPanel monPanel;
	private JPanel monPanelBas;
	
	private JLabel lblTitre;
	private JLabel lblID;
	private JLabel lblMDP;
	private JLabel lblMsgErreur;
	
	private JTextField jtfID;
	private JPasswordField jtfMDP;
    private char getpass[];
	
	private JButton btnConnexion;
	private JButton btnQuit;
	
	
	//CONSTRUCTEUR
	public FenetreConnexion() {
		
    	//configuration de la fenetre
    	this.setTitle("SARL BINDER - Connexion");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
        this.setLocation(600, 300);
		this.setResizable(false);
		
		//================================ Les panel ===============================
		
		this.monPanel = new JPanel();
		this.monPanel.setBackground(new Color(86, 115, 154));
		this.monPanel.setLayout(new BorderLayout());
		this.monPanel.setLayout(new GridLayout(12, 1));
		this.monPanel.setForeground(Color.red);
		
		this.monPanelBas = new JPanel();
		this.monPanelBas.setLayout(new BorderLayout());
		this.monPanelBas.setLayout(new GridLayout(1, 2));
		this.monPanelBas.setBackground(new Color(86, 115, 154));
		
		this.monPanelGlobal = new JPanel();
		this.monPanelGlobal.setBackground(new Color(86, 115, 154));
		
		
		//================================ L'affichage =============================
		
		//TITRE 
		
		this.lblTitre = new JLabel ();
		this.lblTitre.setForeground(Color.white);
		this.lblTitre.setText("CONNEXION");
		this.monPanel.add(this.lblTitre, BorderLayout.CENTER);
    	
    	Font f = new Font("Sherif", Font.BOLD, 18);    
    	this.lblTitre.setFont(f);
        this.monPanel.add(this.lblTitre);
        
        
		//INSERTION ID
		
        this.lblID= new JLabel ();
        this.lblID.setForeground(Color.white);
        this.lblID.setText("Identifiant :");
        this.monPanel.add(this.lblID, BorderLayout.CENTER);
  
        this.jtfID = new JTextField(""); 
        this.jtfID.setPreferredSize(new Dimension(250, 30));
        this.monPanel.add(this.jtfID);
    	
		//INSERTION MDP
		
        this.lblMDP = new JLabel ();
        this.lblMDP.setForeground(Color.white);
        this.lblMDP.setText("Mot de Passe :");
        this.monPanel.add(this.lblMDP, BorderLayout.CENTER);
    	
        this.jtfMDP = new JPasswordField(""); 
        this.jtfMDP.setPreferredSize(new Dimension(250, 30));
        this.jtfMDP.setForeground(Color.black);
        this.monPanel.add(this.jtfMDP);
  		
  		//BUTTON
		
        this.btnConnexion = new JButton("Connection");
        this.monPanelBas.add(this.btnConnexion);
    	
        this.btnQuit = new JButton("Quiter");
        this.monPanelBas.add(this.btnQuit);
    	
		
    	//Les ecoute des button
    	this.btnConnexion.addActionListener(this);
    	this.btnQuit.addActionListener(this);
    	
    	
    	this.lblMsgErreur= new JLabel ();
    	this.lblMsgErreur.setText("");
    	this.lblMsgErreur.setForeground(Color.RED);
    	this.monPanel.add(this.lblMsgErreur, BorderLayout.CENTER);
    	
    	
    	
    	this.monPanelGlobal.add(this.monPanel);
    	this.monPanel.add(this.monPanelBas);
    	
    	this.getContentPane().add(this.monPanelGlobal);
    	this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource().equals(this.btnConnexion)) {
			
			String id = jtfID.getText();
			this.getpass = jtfMDP.getPassword();
    		String mdp = String.valueOf(getpass);
			
			if(Modele.connecter(id , mdp)) {
        		this.dispose();
        		FenetreAccueil accueil = new FenetreAccueil();
			}
			else {
				this.lblMsgErreur.setText("identifiant incorecte");
			}
			
		}
		else {
			this.dispose();
		}
		
	}
	
	

}