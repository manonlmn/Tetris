package com.sopra.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	
	// Player's attributes
	int idPlayer;
	String pseudoPlayer;

	
	
	// Player's get/setters
	public String getPseudoPlayer() {
		return pseudoPlayer;
	}

	public void setPseudoPlayer(String pseudoPlayer) {
		this.pseudoPlayer = pseudoPlayer;
	}
	
	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int pseudoPlayer) {
		this.idPlayer = idPlayer;
	}
}
