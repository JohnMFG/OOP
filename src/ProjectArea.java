import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ProjectArea extends JPanel {
	private JLabel infoLabel;
	private JTextArea infoArea;
	
	//Text are view, shows projects and their information
	public ProjectArea () {
		infoLabel = new JLabel("Projects:");
		
		infoArea = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(infoLabel, BorderLayout.NORTH);
		add(new JScrollPane(infoArea), BorderLayout.CENTER);
	}
	
	public void updateTextArea(Library nLib) {
		infoArea.setText("");
		for (Project a: nLib.getProjects()) {
			String info = a.toString();
			infoArea.append(info);
		}
	}
}
