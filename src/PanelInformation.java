import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author lucas_kaniewski | mickael_campos
 *
 */


public class PanelInformation extends JPanel {
	
	// JPanel
	private JPanel monPanel;
	private JPanel monPanelBas;
	private JPanel monPanelGlobal;


	// JLabel
	private JLabel lblTitre;
	private JLabel lblNom;
	private JLabel lblAdresse;
	private JLabel lblCodePostale;
	private JLabel lblVille;	
	private JLabel lblTvaEntreprise;
	private JLabel lblTvaParticulier;
	private JLabel lblTelephone;
	private JLabel lblFax;
	private JLabel lblMail;

	public PanelInformation(){
		
		// panels		
		this.monPanel = new JPanel();
		this.monPanel.setLayout(new BorderLayout());
		this.monPanel.setLayout(new GridLayout(12, 1));
		this.monPanel.setBackground(new Color(58, 58, 68));
		
		this.monPanelBas = new JPanel();
		this.monPanelBas.setLayout(new BorderLayout());
		this.monPanelBas.setLayout(new GridLayout(1, 2));
		this.monPanelBas.setBackground(new Color(58, 58, 68));
		
		this.monPanelGlobal = new JPanel();
		this.monPanelGlobal.setBackground(new Color(58, 58, 68));

		//TITRE		
		this.lblTitre = new JLabel ();
		this.lblTitre.setForeground(new Color(203,157,62));
		this.lblTitre.setText("Informations Binder");
		this.monPanel.add(this.lblTitre, BorderLayout.CENTER);
		
		Font f = new Font("Sherif", Font.BOLD, 32);
		Font f2 = new Font("Sherif", Font.BOLD, 20);
		this.lblTitre.setFont(f);
		this.monPanel.add(this.lblTitre);
		
		// JLabel
		this.lblNom = new JLabel ();
		this.lblNom.setForeground(new Color(203,157,62));
		this.lblNom.setText("Nom : " + Modele.getNomEntreprise());
		this.lblNom.setFont(f2);
		this.monPanel.add(this.lblNom, BorderLayout.CENTER);
		
		this.lblVille = new JLabel ();
		this.lblVille.setForeground(new Color(203,157,62));
		this.lblVille.setText("Ville : " + Modele.getVilleEntreprise());
		this.lblVille.setFont(f2);
		this.monPanel.add(this.lblVille, BorderLayout.CENTER);
		
		this.lblAdresse = new JLabel ();
		this.lblAdresse.setForeground(new Color(203,157,62));
		this.lblAdresse.setText("Adresse : " + Modele.getAdresseEntreprise());
		this.lblAdresse.setFont(f2);
		this.monPanel.add(this.lblAdresse, BorderLayout.CENTER);
		
		this.lblCodePostale = new JLabel ();
		this.lblCodePostale.setForeground(new Color(203,157,62));
		this.lblCodePostale.setText("Code Postale : " + Modele.getcpEntreprise());
		this.lblCodePostale.setFont(f2);
		this.monPanel.add(this.lblCodePostale, BorderLayout.CENTER);
		
		this.lblTelephone = new JLabel ();
		this.lblTelephone.setForeground(new Color(203,157,62));
		this.lblTelephone.setText("Téléphone : " + Modele.getTelephoneEntreprise());
		this.lblTelephone.setFont(f2);
		this.monPanel.add(this.lblTelephone, BorderLayout.CENTER);
		
		this.lblFax = new JLabel ();
		this.lblFax.setForeground(new Color(203,157,62));
		this.lblFax.setText("Fax : " + Modele.getFaxEntreprise());
		this.lblFax.setFont(f2);
		this.monPanel.add(this.lblFax, BorderLayout.CENTER);
		
		this.lblMail = new JLabel ();
		this.lblMail.setForeground(new Color(203,157,62));
		this.lblMail.setText("Mail :" + Modele.getMailEntreprise());
		this.lblMail.setFont(f2);
		this.monPanel.add(this.lblMail, BorderLayout.CENTER);
		
		this.lblTvaEntreprise = new JLabel ();
		this.lblTvaEntreprise.setForeground(new Color(203,157,62));
		this.lblTvaEntreprise.setText("TVA Entreprise : " + Modele.gettvaEntreprise() + "%");
		this.lblTvaEntreprise.setFont(f2);
		this.monPanel.add(this.lblTvaEntreprise, BorderLayout.CENTER);
		
		this.lblTvaParticulier = new JLabel ();
		this.lblTvaParticulier.setForeground(new Color(203,157,62));
		this.lblTvaParticulier.setText("TVA Particulier :" + Modele.getTvaParticulier() + "%");
		this.lblTvaParticulier.setFont(f2);
		this.monPanel.add(this.lblTvaParticulier, BorderLayout.CENTER);
		
		this.monPanelGlobal.add(this.monPanel);
		this.monPanel.add(this.monPanelBas);	
	}
	
	public JPanel getMonPanel() {
	    return monPanelGlobal;
	}
	
}