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
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class PanelCreationFacture extends JPanel implements ActionListener{
	// JPanel
	private JPanel monPanel;
	private JPanel monPanelBas;
	private JPanel monPanelGlobal;
	
	// JLabel
	private JLabel lblTitre;
	private JLabel lblLieu;
	private JLabel lblDate;
	private JLabel lblClient;
	private JLabel lblAdresse;
	private JLabel lblVille;
	private JLabel lblCP;
	
	private JLabel lblMsgErreur;
	
	// JTF
	private JTextField jtfLieu;
	private JTextField jtfClient;
	private JTextField jtfAdresse;
	private JTextField jtfVille;
	private JTextField jtfCP;
	
	// JButton
	private JButton btnValider;

    //calendrier
    private JDatePickerImpl dateCreation;
    
	public PanelCreationFacture(){
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
		this.lblTitre.setText("Création d'une facture");
		this.monPanel.add(this.lblTitre, BorderLayout.CENTER);
		
		Font f = new Font("Sherif", Font.BOLD, 32);
		Font f2 = new Font("Sherif", Font.BOLD, 20);
		this.lblTitre.setFont(f);
		this.monPanel.add(this.lblTitre);
		
		// JLabel
		this.lblLieu = new JLabel ();
		this.lblLieu.setForeground(new Color(203,157,62));
		this.lblLieu.setText("Lieu de création :");
		this.lblLieu.setFont(f2);
		this.monPanel.add(this.lblLieu, BorderLayout.CENTER);
		
		this.jtfLieu = new JTextField(""); 
		this.jtfLieu.setPreferredSize(new Dimension(250, 30));
		this.jtfLieu.setFont(f2);
		this.monPanel.add(this.jtfLieu);
		
		this.lblDate = new JLabel ();
		this.lblDate.setForeground(new Color(203,157,62));
		this.lblDate.setText("Date de création :");
		this.lblDate.setFont(f2);
		this.monPanel.add(this.lblDate, BorderLayout.CENTER);
		
		SqlDateModel modelDebut = new SqlDateModel();
        Properties pdateCreation = new Properties();
        pdateCreation.put("text.day", "Day");
        pdateCreation.put("text.month", "Month");
        pdateCreation.put("text.year", "Year");
        JDatePanelImpl panel = new JDatePanelImpl(modelDebut,pdateCreation);
        this.dateCreation = new JDatePickerImpl(panel, new DateLabelFormatter());
		this.dateCreation.setFont(f2);
		this.monPanel.add(this.dateCreation);
		
		this.lblClient = new JLabel ();
		this.lblClient.setForeground(new Color(203,157,62));
		this.lblClient.setText("Nom du client :");
		this.lblClient.setFont(f2);
		this.monPanel.add(this.lblClient, BorderLayout.CENTER);
		
		this.jtfClient = new JTextField(""); 
		this.jtfClient.setPreferredSize(new Dimension(250, 30));
		this.jtfClient.setFont(f2);
		this.monPanel.add(this.jtfClient);
		
		this.lblAdresse = new JLabel ();
		this.lblAdresse.setForeground(new Color(203,157,62));
		this.lblAdresse.setText("Adresse du client :");
		this.lblAdresse.setFont(f2);
		this.monPanel.add(this.lblAdresse, BorderLayout.CENTER);
		
		this.jtfAdresse = new JTextField(""); 
		this.jtfAdresse.setPreferredSize(new Dimension(250, 30));
		this.jtfAdresse.setFont(f2);
		this.monPanel.add(this.jtfAdresse);
		
		this.lblVille= new JLabel ();
		this.lblVille.setForeground(new Color(203,157,62));
		this.lblVille.setText("Ville du client :");
		this.lblVille.setFont(f2);
		this.monPanel.add(this.lblVille, BorderLayout.CENTER);
		
		this.jtfVille = new JTextField(""); 
		this.jtfVille.setPreferredSize(new Dimension(250, 30));
		this.jtfVille.setFont(f2);
		this.monPanel.add(this.jtfVille);
		
		this.lblCP = new JLabel ();
		this.lblCP.setForeground(new Color(203,157,62));
		this.lblCP.setText("Code postal du client :");
		this.lblCP.setFont(f2);
		this.monPanel.add(this.lblCP, BorderLayout.CENTER);
		
		this.jtfCP = new JTextField(""); 
		this.jtfCP.setPreferredSize(new Dimension(250, 30));
		this.jtfCP.setFont(f2);
		this.monPanel.add(this.jtfCP);
		
		// JButton
		this.btnValider = new JButton("Valider");
		this.monPanelBas.add(this.btnValider);
		this.btnValider.addActionListener(this);
		
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
			if (!jtfLieu.getText().isEmpty() && !jtfClient.getText().isEmpty() && !jtfAdresse.getText().isEmpty() && !jtfVille.getText().isEmpty() && !jtfCP.getText().isEmpty()) {
				String lieu = jtfLieu.getText();
				Date selectedDate = (Date) dateCreation.getModel().getValue();
	            String date = selectedDate + "";
	            String client = jtfClient.getText();
	            String adresse = jtfAdresse.getText();
	            String ville = jtfVille.getText();
	            String cp = jtfCP.getText();
			
				if(Modele.creerFacture(lieu, date, client, adresse, ville, cp)) {
					int numFacture = Modele.numFactureCreee(lieu, date, client, adresse, ville, cp);
					this.lblMsgErreur.setText("La facture " + numFacture + " a bien été créée");
					this.lblMsgErreur.setForeground(Color.GREEN);
					this.monPanelBas.remove(btnValider);
				}
				else {
					this.lblMsgErreur.setText("Erreur lors de la création de la facture");
				}
			}
			else {
				this.lblMsgErreur.setText("Un ou plusieurs champs sont vide");
			}
			
		}
	}
}
