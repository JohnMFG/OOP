import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private ProjectPanel projectPanel;
	private ProjectArea projectArea;
	private StatsPanel statsPanel;
	private Library lib;
	
	public MainFrame() throws FileNotFoundException {
		super("Version Control System");
		
		//Main GUI - controller
		lib = new Library();
		String path = System.getProperty("user.dir")+"/Data.txt";
		File file=new File(path);
		Scanner scan = new Scanner(file);
		while(scan.hasNext()){
		lib.addNewProject(scan.next(), scan.next(), scan.nextLine(), scan.nextInt(), scan.next(), scan.next(), scan.next());
		}
		scan.close();
		setLayout(new BorderLayout());
		
		projectPanel = new ProjectPanel();
		projectPanel.setLibrary(lib);
		projectArea = new ProjectArea();
		projectArea.updateTextArea(lib);
		statsPanel = new StatsPanel();
		statsPanel.setLibrary(lib);
		
		//Show stats, displays users and their commits from highest to lowest
		
		projectPanel.setUpdateListener(new UpdateListener() {
			@Override
			public void updateEmitted(Library lib) {
				projectArea.updateTextArea(lib);
				statsPanel.setLibrary(lib);
			}
		});
		
		add(projectPanel, BorderLayout.NORTH);
		add(projectArea, BorderLayout.CENTER);
		add(statsPanel, BorderLayout.SOUTH);
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
