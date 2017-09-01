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
@Table(name="Score")
public class Score implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SCO_ID")
	private Integer idScore;
	
	@Column(name="SCO_POINTS")
	private Integer points;
	
	@Column(name="SCO_LINES")
	private Integer lines;
	
	@Column(name="SCO_LEVEL")
	private Integer level;
	
	@ManyToOne
	@JoinColumn(name="SCO_GAME")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name="SCO_PLAYER_ID")
	private Player player;
	

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the idScore
	 */
	public Integer getIdScore() {
		return idScore;
	}

	/**
	 * @param idScore the idScore to set
	 */
	public void setIdScore(Integer idScore) {
		this.idScore = idScore;
	}

	/**
	 * @return the points
	 */
	public Integer getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}

	/**
	 * @return the lines
	 */
	public Integer getLines() {
		return lines;
	}

	/**
	 * @param lines the lines to set
	 */
	public void setLines(Integer lines) {
		this.lines = lines;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	
}
