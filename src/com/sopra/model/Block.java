package com.sopra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="block")
public class Block implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BLO_ID")
	private int idBlock;
	
	@Column(name="x")
	private int x;
	
	@Column(name="y")
	private int y;
	
	@ManyToOne
	@JoinColumn(name = "BLO_ID_FIG")
	private Figure figure;

	/**
	 * @return the idBlock
	 */
	public int getIdBlock() {
		return idBlock;
	}

	/**
	 * @param idBlock the idBlock to set
	 */
	public void setIdBlock(int idBlock) {
		this.idBlock = idBlock;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the figure
	 */
	public Figure getFigure() {
		return figure;
	}

	/**
	 * @param figure the figure to set
	 */
	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
}
