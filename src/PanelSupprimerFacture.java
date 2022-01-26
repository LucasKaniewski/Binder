/**
 * 
 * @author lucas_kaniewski | mickael_campos
 *
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSupprimerFacture extends JPanel implements ActionListener{
	// JPanel
	private JPanel monPanel;
	private JPanel monPanelBas;
	private JPanel monPanelGlobal;
	
	// JLabel
	private JLabel lblTitre;
	private JLabel lblNumFacture;
	
	private JLabel lblMsgErreur;
	
	// JButton
	private JButton btnValider;
	
	//JComboBox
    private JComboBox<String> listeIdFacture;
    
	public PanelSupprimerFacture(){
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
		this.lblTitre.setText("Supprimer une facture");
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
		this.listeIdFacture = new JComboBox<String>(listeId);
		this.listeIdFacture.setFont(f2);
		this.monPanel.add(this.listeIdFacture);
		this.listeIdFacture.addActionListener(this);
		
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
			String numFacture = this.listeIdFacture.getSelectedItem().toString();
			int intNumFacture = Integer.parseInt(numFacture);
		
			if(Modele.supprimerFacture(intNumFacture)) {
				this.lblMsgErreur.setText("La facture a bien été supprimé");
				this.lblMsgErreur.setForeground(Color.GREEN);
				this.monPanelBas.remove(btnValider);
			}
			else {
				this.lblMsgErreur.setText("Erreur lors de la suppression de la facture");
			}
		}
	}
}
