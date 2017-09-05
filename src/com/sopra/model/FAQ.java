package com.sopra.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="faq")
public class FAQ {

	//PARAMETRES
	@Id
	@Column(name="FAQ_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer idFAQ;

	@OneToMany(mappedBy="myFAQ")
	protected List<FAQLanguage> listFAQLanguage;
	
	//GETTERS & SETTERS
	public Integer getIdFAQ() {
		return idFAQ;
	}

	public void setIdFAQ(Integer idFAQ) {
		this.idFAQ = idFAQ;
	}

	public List<FAQLanguage> getListFAQLanguage() {
		return listFAQLanguage;
	}

	public void setListFAQLanguage(List<FAQLanguage> listFAQLanguage) {
		this.listFAQLanguage = listFAQLanguage;
	}



}
