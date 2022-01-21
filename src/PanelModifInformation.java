import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelModifInformation extends JPanel implements ActionListener{
	// JPanel
	private JPanel monPanel;
	
	public PanelModifInformation(){
		this.monPanel = new JPanel();
	}
	
	public JPanel getMonPanel() {
	    return monPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(aaaaaa)) { 
			
		}
	}
}
