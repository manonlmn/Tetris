package com.sopra.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class Language {

	//PARAMETRES
	@Id
	@Column(name="LAN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer idLanguage;
	
	@Column(name="LAN_CODE")
	protected String codeLanguage;
	
	@OneToMany(mappedBy="myLanguage")
	protected List<FAQLanguage> listFAQLanguage;

	public Integer getIdLanguage() {
		return idLanguage;
	}

	
	//GETTERS & SETTERS
	public void setIdLanguage(Integer idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getCodeLanguage() {
		return codeLanguage;
	}

	public void setCodeLanguage(String codeLanguage) {
		this.codeLanguage = codeLanguage;
	}

	public List<FAQLanguage> getListFAQLanguage() {
		return listFAQLanguage;
	}

	public void setListFAQLanguage(List<FAQLanguage> listFAQLanguage) {
		this.listFAQLanguage = listFAQLanguage;
	}
	
}
