package com.sopra.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="figure")
public class Figure implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FIG_ID")
	private int idFigure;
	
	@Column(name="FIG_NUM_ROT")
	private int rotationNumber;
	
	@OneToMany(mappedBy="figure")
	List<Block> myBlocks;
	
	@ManyToOne
	@JoinColumn(name = "FIG_ID_TETRI")
	private Tetrimino tetrimino;

	/**
	 * @return the idFigure
	 */
	public int getIdFigure() {
		return idFigure;
	}

	/**
	 * @param idFigure the idFigure to set
	 */
	public void setIdFigure(int idFigure) {
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
	public int getRotationNumber() {
		return rotationNumber;
	}

	/**
	 * @param rotationNumber the rotationNumber to set
	 */
	public void setRotationNumber(int rotationNumber) {
		this.rotationNumber = rotationNumber;
	}
	
	

}
