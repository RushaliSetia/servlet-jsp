package p1;

public class Questions {
	
	private String loginName;
	private int id;
	private String question;
	private String answer;
	private String topic;
	public Questions(String loginName, int id, String question, String answer, String topic) {
		super();
		this.loginName = loginName;
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.topic = topic;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	@Override
	public String toString() {
		return "Questions [loginName=" + loginName + ", id=" + id + ", question=" + question + ", answer=" + answer
				+ ", topic=" + topic + "]";
	}
	
	
}
