package com.sopra.model;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="player")
public class Player extends Person{
	
	@OneToMany(mappedBy="game")
	private List<Game> myGames;

	/**
	 * @return the myGames
	 */
	public List<Game> getMyGames() {
		return myGames;
	}

	/**
	 * @param myGames the myGames to set
	 */
	public void setMyGames(List<Game> myGames) {
		this.myGames = myGames;
	}
}
