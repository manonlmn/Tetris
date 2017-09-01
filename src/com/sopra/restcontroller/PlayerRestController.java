package com.sopra.restcontroller;

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

import com.sopra.dao.IPlayerDAO;
import com.sopra.generic.Tools;
import com.sopra.model.Player;

@RestController
@RequestMapping(value="/player")
public class PlayerRestController {

	@Autowired
	private IPlayerDAO playDAO;
	
	//recuperer la liste de tous les joueurs
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Player>> getAll(){
		return new ResponseEntity<List<Player>>(this.playDAO.list(),HttpStatus.OK);
	}
	
	//recuperer le joueur par l'id
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Player> getById(@PathVariable int id){
		return new ResponseEntity<Player>(this.playDAO.search(id),HttpStatus.OK);
	}
	
	//ajout d'un joueur
	@RequestMapping(value="", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Player> add(@RequestBody Player player) {
		player = this.playDAO.add(player);
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}
	
	//modification d'un joueur
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Player> modify(@RequestBody Player player, @PathVariable int id){
		player.setIdPerson(id);
		Player myPlayer = this.playDAO.search(id);
		
		try {
			Tools.copy(player, myPlayer);
			myPlayer = this.playDAO.modify(myPlayer);
			return new ResponseEntity<Player>(myPlayer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Player>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
