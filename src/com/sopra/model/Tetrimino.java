package com.sopra.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tetrimino")
public class Tetrimino implements Serializable {

	private static final long serialVersionUID = 1L;

	// Tetrimino's attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TET_ID")
	private int idTetrimino;
	
	@Column(name="TET_NAME")
	@NotNull
	private String nameTetrimino;
	
	@Column(name="TET_COLOUR")
	@NotNull
	private String colourTetrimino;
	
	@Column(name="TET_COEF")
	private Integer coef;
	
	@OneToMany(mappedBy="tetrimino")
	List<Figure> myFigures;
	
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

	public Integer getCoef() {
		return coef;
	}
	
	public void setCoef(Integer coef) {
		this.coef = coef;
	}

	public List<Figure> getMyFigures() {
		return myFigures;
	}

	public void setMyFigures(List<Figure> myFigures) {
		this.myFigures = myFigures;
	}
}
