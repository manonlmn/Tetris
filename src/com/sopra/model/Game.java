/**
 * 
 */
package com.sopra.model;

import java.io.Serializable;

/**
 * @author mlemonnier
 *
 */
import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="game")
public class Game implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GAM_ID")
	private int idGame;
	
	@ManyToOne
	@JoinColumn(name = "GAM_ID_PLAYER1")
	@NotNull
	private Player player1;
	
	@ManyToOne
	@JoinColumn(name = "GAM_ID_PLAYER2")
	private Player player2;
	
	@OneToOne
	@JoinColumn(name = "GAM_SCORE")
	private Score score;
	
	@Column(name ="GAM_STATUS")
	private String status;

	/**
	 * @return the player1
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * @param player1 the player1 to set
	 */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	/**
	 * @return the player2
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * @param player2 the player2 to set
	 */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	

	/**
	 * @return the score
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Score score) {
		this.score = score;
	}

	/**
	 * @return the idGame
	 */
	public int getIdGame() {
		return idGame;
	}

	/**
	 * @param idGame the idGame to set
	 */
	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
