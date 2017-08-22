package com.sopra.model;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="player")
public class Player extends Person{
	
	@OneToMany(mappedBy="game")
	private List<Game> myGames;
	
	
}
