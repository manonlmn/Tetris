package com.sopra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tetrimino")
public class Tetrimino implements Serializable {
	
	// Tetrimino's attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TET_ID")
	int idTetrimino;
	
	@Column(name="TET_NAME")
	@NotNull
	String nameTetrimino;
	
	@Column(name="TET_COLOUR")
	@NotNull
	String colourTetrimino;
	
	
	
	// Tereimino's get/setters
	public String getNameTetrimino() {
		return nameTetrimino;
	}
	
	public void setNameTetrimino(String nameTetrimino) {
		this.nameTetrimino = nameTetrimino;
	}
	
	public String getColourTetrimino() {
		return colourTetrimino;
	}
	public void setColourTetrimino(String colourTetrimino) {
		this.colourTetrimino = colourTetrimino;
	}
	
	public int getIdTetrimino() {
		return idTetrimino;
	}
	public void setIdTetrimino(int idTetrimino) {
		this.idTetrimino = idTetrimino;
	}
}
