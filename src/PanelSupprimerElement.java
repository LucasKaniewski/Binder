import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class PanelSupprimerElement extends JPanel implements ActionListener{
	// JPanel
	private JPanel monPanel;
	private JPanel monPanelBas;
	private JPanel monPanelGlobal;
	
	// JLabel
	private JLabel lblTitre;
	private JLabel lblTitreNumFacture;
	private JLabel lblNumFacture;
	
	private JLabel lblMsgErreur;
	
	
	//JComboBox
    private JComboBox listeIdFacture;
    private JComboBox listeElementFacture;
    
	// JButton
	private JButton btnValider;
	private JButton btnValider2;
    	
	/*
	 * Panel pour la sélection de la facture à modifier
	 */
	public PanelSupprimerElement(){
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
		this.lblTitre.setText("Supprimer un élément");
		this.monPanel.add(this.lblTitre, BorderLayout.CENTER);
		
		Font f = new Font("Sherif", Font.BOLD, 32);
		Font f2 = new Font("Sherif", Font.BOLD, 20);
		this.lblTitre.setFont(f);
		this.monPanel.add(this.lblTitre);
		
		// JLabel
		this.lblTitreNumFacture = new JLabel ();
		this.lblTitreNumFacture.setForeground(new Color(203,157,62));
		this.lblTitreNumFacture.setText("Facture à modifier :");
		this.lblTitreNumFacture.setFont(f2);
		this.monPanel.add(this.lblTitreNumFacture, BorderLayout.CENTER);
		
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
				
		// JButton
		this.btnValider = new JButton("Valider");
		this.monPanelBas.add(this.btnValider);
		this.btnValider.addActionListener(this);
		
		// msg d'erreur
		this.lblMsgErreur= new JLabel ();
		this.lblMsgErreur.setText("");
		this.lblMsgErreur.setForeground(Color.RED);
		this.monPanel.add(this.lblMsgErreur, BorderLayout.CENTER);
		    	
		this.monPanelGlobal.add(this.monPanel);
		this.monPanel.add(this.monPanelBas);
	}
	
	/*
	 * Panel pour la sélection de élément à supprimer
	 */
	public PanelSupprimerElement(int intIdFacture){
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
		this.lblTitre.setText("Supprimer un élément");
		this.monPanel.add(this.lblTitre, BorderLayout.CENTER);
		
		Font f = new Font("Sherif", Font.BOLD, 32);
		Font f2 = new Font("Sherif", Font.BOLD, 20);
		this.lblTitre.setFont(f);
		this.monPanel.add(this.lblTitre);
		
		// JLabel
		this.lblTitreNumFacture = new JLabel ();
		this.lblTitreNumFacture.setForeground(new Color(203,157,62));
		this.lblTitreNumFacture.setText("Facture à modifier :");
		this.lblTitreNumFacture.setFont(f2);
		this.monPanel.add(this.lblTitreNumFacture, BorderLayout.CENTER);
		
		this.lblNumFacture = new JLabel ();
		this.lblNumFacture.setForeground(new Color(203,157,62));
		this.lblNumFacture.setText(String.valueOf(intIdFacture));
		this.lblNumFacture.setFont(f2);
		this.monPanel.add(this.lblNumFacture, BorderLayout.CENTER);

		//combo Box
		ArrayList<String> listeElementFactureRecup = Modele.recupListElementFacture(intIdFacture);

		String listeElement[] = new String[Modele.getNbElementFacture(intIdFacture)];
		int i = 0; 
		for (String unElementFacture : listeElementFactureRecup) {
			listeElement[i] = unElementFacture;
			i++;
		}
		this.listeElementFacture = new JComboBox(listeElement);
		this.listeElementFacture.setFont(f2);
		this.monPanel.add(this.listeElementFacture);
		this.listeElementFacture.addActionListener(this);
		
		// JButton
		this.btnValider2 = new JButton("Valider");
		this.monPanelBas.add(this.btnValider2);
		this.btnValider2.addActionListener(this);
		
		// msg d'erreur
		this.lblMsgErreur = new JLabel ();
		this.lblMsgErreur.setText("");
		this.lblMsgErreur.setForeground(Color.RED);
		this.monPanel.add(this.lblMsgErreur, BorderLayout.CENTER);
		    	
		this.monPanelGlobal.add(this.monPanel);
		this.monPanel.add(this.monPanelBas);
	}
	
	public JPanel getMonPanel() {
	    return monPanelGlobal;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnValider)) {
			String idFacture = this.listeIdFacture.getSelectedItem().toString();
			int intIdFacture = Integer.parseInt(idFacture);
			this.monPanelGlobal.removeAll();
			this.monPanelGlobal.add(new PanelSupprimerElement(intIdFacture).getMonPanel());
			this.monPanelGlobal.revalidate();
			this.monPanelGlobal.repaint();
		}else if(e.getSource().equals(this.btnValider2)){
			
		}
	}
}
