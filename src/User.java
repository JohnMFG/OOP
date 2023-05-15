public class User {

	private String name;
	private int commits;

	public User(String name) {
		this.name = name;
		this.commits = 0;
	}

	public String getName() {
		return name;
	}

	public int getCommits() {
		return commits;
	}

	@Override
	public String toString() {
		return "User: name=" + getName() + "; commits=" + getCommits();
	}

	public void incrementCommits() {
		this.commits++;
	}

}
