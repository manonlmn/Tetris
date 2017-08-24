package com.sopra.model;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="player")
@PrimaryKeyJoinColumn(name="PLA_ID", referencedColumnName="PER_ID")
public class Player extends Person{

	private static final long serialVersionUID = 1L;
	
	@Column(name="PLA_BANNED")
	private boolean banned;

	@OneToMany(mappedBy="player1")
	private List<Game> myGamesP1;

	@OneToMany(mappedBy="player2")
	private List<Game> myGamesP2;
	
	@OneToMany(mappedBy="player")
	private List<Score> myScore;

	/**
	 * @return the myGamesP1
	 */
	public List<Game> getMyGamesP1() {
		return myGamesP1;
	}

	/**
	 * @param myGamesP1 the myGamesP1 to set
	 */
	public void setMyGamesP1(List<Game> myGamesP1) {
		this.myGamesP1 = myGamesP1;
	}

	/**
	 * @return the myGamesP2
	 */
	public List<Game> getMyGamesP2() {
		return myGamesP2;
	}

	/**
	 * @param myGamesP2 the myGamesP2 to set
	 */
	public void setMyGamesP2(List<Game> myGamesP2) {
		this.myGamesP2 = myGamesP2;
	}

	/**
	 * @return the myScore
	 */
	public List<Score> getMyScore() {
		return myScore;
	}

	/**
	 * @param myScore the myScore to set
	 */
	public void setMyScore(List<Score> myScore) {
		this.myScore = myScore;
	}

	public boolean isBanned() {
		return this.banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	
	public void modifyBanned() {
		this.banned = !banned;
	}
}
