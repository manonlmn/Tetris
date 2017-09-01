package com.sopra.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.IGameDAO;
import com.sopra.generic.Tools;
import com.sopra.model.Game;

@RestController
@RequestMapping(value="/games")
public class GamesRestController {
	
	@Autowired
	private IGameDAO gameDAO;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Game>> getAll(){
		List<Game> myGamesSolo = this.gameDAO.listWithScoreSolo();
		List<Game> myGamesMulti = this.gameDAO.listWithScoreMulti();
		
		List<Game> myGames = new ArrayList<Game>();
		myGames.addAll(myGamesSolo);
		myGames.addAll(myGamesMulti);
		
		return new ResponseEntity<List<Game>>(myGames, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Game> add(@RequestBody Game game){
		game = this.gameDAO.add(game);
		return new ResponseEntity<Game>(game, HttpStatus.OK);
	}
	
	
	//modification d'une partie
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Game> modify(@RequestBody Game game, @PathVariable int id){
		game.setIdGame(id);
		Game myGame = this.gameDAO.search(id);
		
		try {
			Tools.copy(game, myGame);
			myGame = this.gameDAO.modify(myGame);
			return new ResponseEntity<Game>(myGame, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Game>(HttpStatus.BAD_REQUEST);
		}
	}
}
