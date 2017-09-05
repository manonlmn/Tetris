package com.sopra.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="faqlanguage")
public class FAQLanguage {

	@Id
	@Column(name="FAQL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer idFAQLanguage;
	
	public Integer getIdFAQLanguage() {
		return idFAQLanguage;
	}

	public void setIdFAQLanguage(Integer idFAQLanguage) {
		this.idFAQLanguage = idFAQLanguage;
	}

	//PARAMETRES
	@Column(name="FAQL_QUESTION")
	protected String questionFAQLanguage;
	
	@Column(name="FAQL_RESPONSE")
	protected String responseFAQLanguage;
	
	@ManyToOne
	@JoinColumn(name="FAQL_IDLANGUAGE")
	protected Language myLanguage;
	
	@ManyToOne
	@JoinColumn(name="FAQL_IDFAQ")
	protected FAQ myFAQ;
	
	
	//GETTERS & SETTERS
	public String getQuestionFAQLanguage() {
		return questionFAQLanguage;
	}

	public void setQuestionFAQLanguage(String questionFAQLanguage) {
		this.questionFAQLanguage = questionFAQLanguage;
	}

	public String getResponseFAQLanguage() {
		return responseFAQLanguage;
	}

	public void setResponseFAQLanguage(String responseFAQLanguage) {
		this.responseFAQLanguage = responseFAQLanguage;
	}

	public Language getMyLanguage() {
		return myLanguage;
	}

	public void setMyLanguage(Language myLanguage) {
		this.myLanguage = myLanguage;
	}

	public FAQ getMyFAQ() {
		return myFAQ;
	}

	public void setMyFAQ(FAQ myFAQ) {
		this.myFAQ = myFAQ;
	}
}
