
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Library {
	LinkedList<Project> projects = new LinkedList<Project>();
	FileWriter fileWriter;
	public Library() {};

	public LinkedList<Project> getProjects() {
		return projects;
	}
	
	public void addNewProject(String name, String file, String comment, int version, String userName, String date, String time) {
		projects.add(new Project(name, file, comment, version, new User(userName), date, time));
		
	}
	
	public boolean isInLibrary(String name) {
		boolean result = false;
		for (int i = 0; i < projects.size(); i++) {
			if(projects.get(i).getName().equals(name)) {
				result = true;
				break;
			};
		}
		return result;
	}
	
	public Project findProjectByNameAndVersion(String name, int version) {
		for (int i = 0; i < projects.size(); i++) {
			if(projects.get(i).getName().equals(name) && projects.get(i).getVersion() == version) {
				return projects.get(i);
			};
		}
		return null;
	}
	public void addProjectToDataBase(String name, String file, String comment, int version, String userName, String date, String time) {
		
		try {
			String path = System.getProperty("user.dir")+"/Data.txt";
			fileWriter = new FileWriter(path, true);
			fileWriter.write("\n" +name + " " + file +" "+ comment +"\n" + version +" "+ userName + " " + date + " " + time);
			 
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
