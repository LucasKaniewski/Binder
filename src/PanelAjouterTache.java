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

public class PanelAjouterTache extends JPanel implements ActionListener{
	// JPanel
	private JPanel monPanel;
	private JPanel monPanelBas;
	private JPanel monPanelGlobal;
	
	// JLabel
	private JLabel lblTitre;
	private JLabel lblNumFacture;
	private JLabel lblDescription;
	private JLabel lblTarif;
	
	private JLabel lblMsgErreur;
	
	// JTF
	private JTextField jtfDescription;
	private JTextField jtfTarif;
	
	// JButton
	private JButton btnValider;
	
	//JComboBox
    private JComboBox listeIdFacture;
    
	public PanelAjouterTache(){
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
		this.lblTitre.setText("Ajouter un élément à une facture");
		this.monPanel.add(this.lblTitre, BorderLayout.CENTER);
		
		Font f = new Font("Sherif", Font.BOLD, 32);
		Font f2 = new Font("Sherif", Font.BOLD, 20);
		this.lblTitre.setFont(f);
		this.monPanel.add(this.lblTitre);
		
		// JLabel
		this.lblNumFacture = new JLabel ();
		this.lblNumFacture.setForeground(new Color(203,157,62));
		this.lblNumFacture.setText("Numéro de la facture :");
		this.lblNumFacture.setFont(f2);
		this.monPanel.add(this.lblNumFacture, BorderLayout.CENTER);
		
		//combo Box
		ArrayList<Integer> listeIdFactureRecup = Modele.recupListIdFacture();

		String listeId[] = new String[Modele.getNbFacture()];
		int i = 0; 
		for (int unIdFacture : listeIdFactureRecup) {
			listeId[i] = String.valueOf(unIdFacture);
			i++;
		}
		this.listeIdFacture = new JComboBox(listeId);
		this.listeIdFacture.setFont(f2);
		this.monPanel.add(this.listeIdFacture);
		this.listeIdFacture.addActionListener(this);
		
		this.lblDescription = new JLabel ();
		this.lblDescription.setForeground(new Color(203,157,62));
		this.lblDescription.setText("Description de la tache :");
		this.lblDescription.setFont(f2);
		this.monPanel.add(this.lblDescription, BorderLayout.CENTER);
		
		this.jtfDescription = new JTextField(""); 
		this.jtfDescription.setPreferredSize(new Dimension(250, 30));
		this.jtfDescription.setFont(f2);
		this.monPanel.add(this.jtfDescription);
		
		this.lblTarif = new JLabel ();
		this.lblTarif.setForeground(new Color(203,157,62));
		this.lblTarif.setText("Tarif (xxxxx.xx) :");
		this.lblTarif.setFont(f2);
		this.monPanel.add(this.lblTarif, BorderLayout.CENTER);
		
		this.jtfTarif = new JTextField(""); 
		this.jtfTarif.setPreferredSize(new Dimension(250, 30));
		this.jtfTarif.setFont(f2);
		this.monPanel.add(this.jtfTarif);
		
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
			if (!jtfDescription.getText().isEmpty() && !jtfTarif.getText().isEmpty()) {
				String numFacture = this.listeIdFacture.getSelectedItem().toString();
				int intNumFacture = Integer.parseInt(numFacture);
	            String description = jtfDescription.getText();
	            String stringTarif = jtfTarif.getText();
	            double tarif = Double.parseDouble(stringTarif);
			
				if(Modele.ajouterTache(intNumFacture, description, tarif)) {
					
					this.lblMsgErreur.setText("La tache a bien été ajouté");
					this.lblMsgErreur.setForeground(Color.GREEN);
					this.monPanelBas.remove(btnValider);
				}
				else {
					this.lblMsgErreur.setText("Erreur lors de l'ajout de la tache à la facture");
				}
			}
			else {
				this.lblMsgErreur.setText("Un ou plusieurs champs sont vide");
			}
			
		}
	}
}
