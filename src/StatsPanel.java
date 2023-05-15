import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StatsPanel extends JPanel {

	private JButton statsButton;
	private Library lib;

	public StatsPanel() {

		statsButton = new JButton("Display Users Statistic");
		statsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				JOptionPane.showMessageDialog(null, getStats());
			}
		});
		add(statsButton);
	}

	public void setLibrary(Library lib) {
		this.lib = lib;
	}
	
	//Using hashmap to get each user commits
	public String getStats () {
		HashMap<String, Integer> sarasas = new HashMap<String, Integer>();

		for (Project a: lib.getProjects()) {
			String name = a.getUser().getName();
			if (sarasas.containsKey(name)) {
				System.out.println("Adding" + name);
				sarasas.put(name, sarasas.get(name) + 1);
			} else {
				sarasas.put(name, 1);
			};
		}

		return sarasas.toString();
	}
}
