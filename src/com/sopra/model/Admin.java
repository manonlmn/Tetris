package com.sopra.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name="ADM_ID", referencedColumnName="PER_ID")
public class Admin extends Person {

	private static final long serialVersionUID = 1L;

}

