public class Project {
	private String name;
	private User user;
	private String file;
	private String comment;
	private int version;
	private String date;
	private String time;

	public Project(String name, String file, String comment, int version, User user, String date, String time) {
		this.name = name;
		this.file = file;
		this.user = user;
		this.comment = comment;
		this.version = version;
		this.date = date;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Name: " + getName() + "\nFile: " + getFile() + "\nComment: " + getComment() + "\nVersion: "
				+ getVersion()/100 +"."+getVersion()%100/10+"."+getVersion()%10 + "\nUser: " + getUser().getName() + "\nDate and time: " +getDate() + " " +getTime() + "\n-------------------\n";
	}

	

	
}
