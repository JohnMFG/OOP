import java.io.FileNotFoundException;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainFrame();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

	}

}
