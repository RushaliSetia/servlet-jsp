package com.bean;

public class User {

	String userName;
	String password;
	int age;
	String topic;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password, int age, String topic) {
		super();
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.topic = topic;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", age=" + age + ", topic=" + topic + "]";
	}

	public boolean validateUser() throws Exception {

		if (age < 18)
			throw new InvalidAgeException();
		else
			return true;

	}

}
