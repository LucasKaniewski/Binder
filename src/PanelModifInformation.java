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
import java.sql.Date;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class PanelModifInformation extends JPanel implements ActionListener{
	
	// JPanel
	private JPanel monPanel;
	private JPanel monPanelBas;
	private JPanel monPanelGlobal;
	
	// JLabel
	private JLabel lblTitre;
	private JLabel lblValModif;
	
	private JLabel lblMsgErreur;
	
	// JTF
	private JTextField jtfValModif;
	
	// JButton
	private JButton btnValider;
	private JButton btnValider2;

	//JBox
	private JComboBox<String> listeInformations;
    
	public PanelModifInformation(){
		// panels		
		this.monPanel = new JPanel();
		this.monPanel.setBackground(new Color(58, 58, 68));
		this.monPanel.setLayout(new BorderLayout());
		this.monPanel.setLayout(new GridLayout(15, 1));
		
		this.monPanelBas = new JPanel();
		this.monPanelBas.setLayout(new BorderLayout());
		this.monPanelBas.setLayout(new GridLayout(1, 2));
		this.monPanelBas.setBackground(new Color(58, 58, 68));
		
		this.monPanelGlobal = new JPanel();
		this.monPanelGlobal.setBackground(new Color(58, 58, 68));
		
		//TITRE		
		this.lblTitre = new JLabel ();
		this.lblTitre.setForeground(new Color(203,157,62));
		this.lblTitre.setText("Modification des informations");
		this.monPanel.add(this.lblTitre, BorderLayout.CENTER);
		
		Font f = new Font("Sherif", Font.BOLD, 32);
		Font f2 = new Font("Sherif", Font.BOLD, 20);
		this.lblTitre.setFont(f);
		this.monPanel.add(this.lblTitre);
		
		//Combo Box
      	ArrayList<String> listeDesInformations = new ArrayList<String>();
      	listeDesInformations.add("Nom");
      	listeDesInformations.add("Adresse");
      	listeDesInformations.add("Ville");
      	listeDesInformations.add("Code Postale");
      	listeDesInformations.add("TVA Entreprise");
      	listeDesInformations.add("TVA Particulier");
      	listeDesInformations.add("Telphone");
      	listeDesInformations.add("Fax");
      	listeDesInformations.add("Mail");
      	String listeInfo[] = new String[9];
      	int i = 0; 
      	for (String uneInformation : listeDesInformations) {
      		listeInfo[i] = uneInformation;
      		i++;
      	}   	
      	this.listeInformations = new JComboBox(listeInfo);
      	this.listeInformations.setFont(f2);
      	this.monPanel.add(this.listeInformations);
      	this.listeInformations.addActionListener(this);
      	
      	// JButton
     	this.btnValider = new JButton("Valider");
     	this.monPanelBas.add(this.btnValider);
     	this.btnValider.addActionListener(this);
      	
	}
	
    public PanelModifInformation(String infoModif){
    	
    	// Panels		
    	this.monPanel = new JPanel();
    	this.monPanel.setBackground(new Color(58, 58, 68));
    	this.monPanel.setLayout(new BorderLayout());
    	this.monPanel.setLayout(new GridLayout(15, 1));
    		
    	this.monPanelBas = new JPanel();
    	this.monPanelBas.setLayout(new BorderLayout());
    	this.monPanelBas.setLayout(new GridLayout(1, 2));
    	this.monPanelBas.setBackground(new Color(58, 58, 68));
    			
    	this.monPanelGlobal = new JPanel();
    	this.monPanelGlobal.setBackground(new Color(58, 58, 68));
    			
    	//TITRE		
    	this.lblTitre = new JLabel ();
    	this.lblTitre.setForeground(new Color(203,157,62));
    	this.lblTitre.setText("Modification des informations");
    	this.monPanel.add(this.lblTitre, BorderLayout.CENTER);
    			
    	Font f = new Font("Sherif", Font.BOLD, 32);
    	Font f2 = new Font("Sherif", Font.BOLD, 20);
    	this.lblTitre.setFont(f);
    	this.monPanel.add(this.lblTitre);
    	
    	// JLabel
		this.lblValModif = new JLabel ();
		this.lblValModif.setForeground(new Color(203,157,62));
		this.lblValModif.setText("Valeur à modifier : " + infoModif);
		this.lblValModif.setFont(f2);
		this.monPanel.add(this.lblValModif, BorderLayout.CENTER);
		
		this.jtfValModif = new JTextField(""); 
		this.jtfValModif.setPreferredSize(new Dimension(250, 30));
		this.jtfValModif.setFont(f2);
		this.monPanel.add(this.jtfValModif);
		
		// JButton
		this.btnValider2 = new JButton("Valider");
		this.monPanelBas.add(this.btnValider2);
		this.btnValider2.addActionListener(this);
		
		// msg d'erreur
		this.lblMsgErreur= new JLabel ();
		this.lblMsgErreur.setText("");
		this.lblMsgErreur.setForeground(Color.RED);
		this.lblMsgErreur.setFont(f2);
		this.monPanel.add(this.lblMsgErreur, BorderLayout.CENTER);
		    	
		this.monPanelGlobal.add(this.monPanel);
		this.monPanel.add(this.monPanelBas);
    }  	
	
	public JPanel getMonPanel() {
	    return monPanelGlobal;
	}	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnValider)) {
			String infoModif = this.listeInformations.getSelectedItem().toString();	
			if(infoModif != "") {
				this.monPanelGlobal.removeAll();
				this.monPanelGlobal.add(new PanelModifInformation(infoModif).getMonPanel());
				this.monPanelGlobal.revalidate();
				this.monPanelGlobal.repaint();
			}else if(e.getSource().equals(this.btnValider2)){
				String modifVal = this.jtfValModif.toString();
				if(Modele.modfierUneInformation(infoModif, modifVal)) {
					this.lblMsgErreur.setText("L'information à bien été modifier");
					this.lblMsgErreur.setForeground(Color.GREEN);
					this.monPanelBas.remove(btnValider2);
			}
			else {
				this.lblMsgErreur.setText("Aucune information sélectionnez");
			}	
		}
	}
	}
}