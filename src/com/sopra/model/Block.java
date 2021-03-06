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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="block")
public class Block implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BLO_ID")
	private Integer idBlock;
	
	@JsonProperty("positionY")
	@Column(name="x")
	private Integer x;
	
	@JsonProperty("positionX")
	@Column(name="y")
	private Integer y;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "BLO_ID_FIG")
	private Figure figure;

	/**
	 * @return the idBlock
	 */
	public Integer getIdBlock() {
		return idBlock;
	}

	/**
	 * @param idBlock the idBlock to set
	 */
	public void setIdBlock(Integer idBlock) {
		this.idBlock = idBlock;
	}

	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Integer y) {
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
