package com.onetoonebi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="QuestionId")
	private int id;
	private String question;
	
	@OneToOne(cascade = CascadeType.PERSIST,mappedBy = "ques")
	private Answer ans;
	
	//helper method
	public void addAnswer(Answer ans) {
		this.ans=ans;
		this.ans.setQues(this);
	}
}
