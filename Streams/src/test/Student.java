package test;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private int ranking;
	private int averageMarks;

	public Student(int id, String firstName, String lastName, int ranking, int averageMarks) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ranking = ranking;
		this.averageMarks = averageMarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getAverageMarks() {
		return averageMarks;
	}

	public void setAverageMarks(int averageMarks) {
		this.averageMarks = averageMarks;
	}

}
