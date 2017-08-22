package com.sopra.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Person")
public class Person implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PER_ID")
	int idPerson;
	
	@Column(name="PER_USERNAME")
	String username;
	
	@Column(name="PER_PWD")
	String password;
	
	@Column(name="PER_LASTNAME")
	String nom;
	
	@Column(name="PER_NAME")
	String prenom;
	
	
}
