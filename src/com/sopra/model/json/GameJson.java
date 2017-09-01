package com.sopra.model.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IGameDAO;
import com.sopra.model.Game;

public class GameJson extends Game {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IGameDAO gameDAO;


	public GameJson (Game game) {
		this.idGame=game.getIdGame();
		this.player1=game.getPlayer1();
		this.player2=game.getPlayer2();
		this.myScores=game.getMyScores();
		this.status=game.getStatus();
		this.type = game.getType();
	}
}
