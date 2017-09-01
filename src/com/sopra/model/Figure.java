package com.sopra.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="figure")
public class Figure implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FIG_ID")
	private Integer idFigure;
	
	@Column(name="FIG_NUM_ROT")
	private Integer rotationNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy="figure")
	List<Block> myBlocks;
	
	@ManyToOne
	@JoinColumn(name = "FIG_ID_TETRI")
	private Tetrimino tetrimino;

	/**
	 * @return the idFigure
	 */
	public Integer getIdFigure() {
		return idFigure;
	}

	/**
	 * @param idFigure the idFigure to set
	 */
	public void setIdFigure(Integer idFigure) {
		this.idFigure = idFigure;
	}

	/**
	 * @return the myBlocks
	 */
	public List<Block> getMyBlocks() {
		return myBlocks;
	}

	/**
	 * @param myBlocks the myBlocks to set
	 */
	public void setMyBlocks(List<Block> myBlocks) {
		this.myBlocks = myBlocks;
	}

	/**
	 * @return the rotationNumber
	 */
	public Integer getRotationNumber() {
		return rotationNumber;
	}

	/**
	 * @param rotationNumber the rotationNumber to set
	 */
	public void setRotationNumber(Integer rotationNumber) {
		this.rotationNumber = rotationNumber;
	}

	/**
	 * @return the tetrimino
	 */
	public Tetrimino getTetrimino() {
		return tetrimino;
	}

	/**
	 * @param tetrimino the tetrimino to set
	 */
	public void setTetrimino(Tetrimino tetrimino) {
		this.tetrimino = tetrimino;
	}
	
	

}
