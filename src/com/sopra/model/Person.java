package com.sopra.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Person")
@Inheritance(strategy=InheritanceType.JOINED)
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
	private String lastName;
	
	@Column(name="PER_NAME")
	private String name;

	/**
	 * @return the idPerson
	 */
	public int getIdPerson() {
		return idPerson;
	}

	/**
	 * @param idPerson the idPerson to set
	 */
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
}
