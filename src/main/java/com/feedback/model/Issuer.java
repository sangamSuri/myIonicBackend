package com.feedback.model;

public class Issuer {
	private String Question;
	private String checked;
	
	
	public Issuer() {
	}
	
	public Issuer(String Question, String checked) {
		setQuestion(Question);
		setChecked(checked);
	}
	
 	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

		public String toString() {
		return "[" + getQuestion() 
				+ ", " + getChecked()
				+ "]";
	}
}
