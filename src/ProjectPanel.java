import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProjectPanel extends JPanel {
	private JButton workButton;
	private Library lib;
	private UpdateListener updateListener;

	//View for adding new projects and working on old ones
	public ProjectPanel() {

		setBorder(BorderFactory.createEtchedBorder());

		workButton = new JButton("Work on project");
		workButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy/MM/dd");
				SimpleDateFormat sdfhours = new SimpleDateFormat("HH:mm");
				Date date = new Date();
				Date hours = new Date();
				
				String name = (String) JOptionPane.showInputDialog(null, "Enter project name(without spacebars):", "");
				if (name != null) {
					// If project with this name exists load page with it's constructor
					// Else load new project, clean constructor
					if (lib.isInLibrary(name)) {
						System.out.println("Is in library! " + name);
						int version = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter project version you want to load(E.g 121):", "100"));
						
						Project currentProject = lib.findProjectByNameAndVersion(name, version);
						if (currentProject != null) {
							String file = JOptionPane.showInputDialog(null, "Enter project file:", currentProject.getFile());
							String comment = JOptionPane.showInputDialog(null, "Enter project comment:", currentProject.getComment());
							int newVersion = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter project new version(E.g 121):", version+1));
							String userName = JOptionPane.showInputDialog(null, "Enter your name:", "");
							lib.addNewProject(name, file, comment, newVersion, userName, sdfdate.format(date), sdfhours.format(hours));
							lib.addProjectToDataBase(name, file, comment, newVersion, userName, sdfdate.format(date), sdfhours.format(hours));
							updateListener.updateEmitted(lib);
						} else {
							String file = JOptionPane.showInputDialog(null, "Enter project file:", "");
							String comment = JOptionPane.showInputDialog(null, "Enter project comment:", "");
							String userName = JOptionPane.showInputDialog(null, "Enter your name:", "");
							lib.addNewProject(name, file, comment, version, userName, sdfdate.format(date), sdfhours.format(hours));
							lib.addProjectToDataBase(name, file, comment, version, userName, sdfdate.format(date), sdfhours.format(hours));
							updateListener.updateEmitted(lib);
						}
						
					} else {
						System.out.println("Create new project! " + name);
						int version = Integer.parseInt(JOptionPane.showInputDialog("Enter project version(E.g 121):"));
						String file = JOptionPane.showInputDialog("Enter project file:");
						String comment = JOptionPane.showInputDialog("Enter project comment:");
						String userName = JOptionPane.showInputDialog(null, "Enter your name:", "");
						lib.addNewProject(name, file, comment, version, userName, sdfdate.format(date), sdfhours.format(hours));
						lib.addProjectToDataBase(name, file, comment, version, userName , sdfdate.format(date), sdfhours.format(hours));
						updateListener.updateEmitted(lib);
					}
				}
				
			}
		});

		add(workButton);
	}
	
	public void setLibrary (Library lib) {
		this.lib = lib;
	}
	
	public void setUpdateListener(UpdateListener updateListener) {
		this.updateListener = updateListener;
	}
}
