package com.sopra.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Person")
public class Person implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PER_ID")
	private int idPerson;
	
	@Column(name="PER_USERNAME")
	private String username;
	
	@Column(name="PER_PWD")
	private String password;
	
	@Column(name="PER_LASTNAME")
	private String nom;
	
	@Column(name="PER_NAME")
	private String prenom;
	
}
