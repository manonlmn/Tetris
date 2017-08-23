/**
 * 
 */
package com.sopra.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author mlemonnier
 *
 */
import javax.persistence.*;
import javax.validation.constraints.*;

import com.sopra.dao.PlayerDAO;


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

	@OneToMany(mappedBy="game")
	private List<Score> myScores;

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
	 * @return the myScores
	 */
	public List<Score> getMyScores() {
		return myScores;
	}

	/**
	 * @param myScores the myScores to set
	 */
	public void setMyScores(List<Score> myScores) {
		this.myScores = myScores;
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




	public Score getScoreA() {
		for (Score score : myScores) {
			if (score.getPlayer().getIdPerson() == player1.getIdPerson()) {
				return score;
			}
		}

		return null;
	}

	public Score getScoreB() {
		for (Score score : myScores) {
			if (score.getPlayer().getIdPerson() == player2.getIdPerson()) {
				return score;
			}
		}
		return null;
	}


}
