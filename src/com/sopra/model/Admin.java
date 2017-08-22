package com.sopra.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name="ADM_ID", referencedColumnName="PER_ID")
public class Admin extends Person {

}

