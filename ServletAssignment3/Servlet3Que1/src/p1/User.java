package p1;


public class User {
	
	private String firstName;
	private String surname;
	private String loginName;
	private int age;
	private String password;
	private String topics;
	
	public User(String firstName, String surname, String loginName, int age, String password, String topics) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.loginName = loginName;
		this.age = age;
		this.password = password;
		this.topics = topics;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", surname=" + surname + ", loginName=" + loginName + ", age=" + age
				+ ", password=" + password + ", topics=" + topics + "]";
	}
	
	
	
	
}
