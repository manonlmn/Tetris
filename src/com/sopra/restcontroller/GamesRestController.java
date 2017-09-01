package com.sopra.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.IGameDAO;
import com.sopra.model.Game;

@RestController
@RequestMapping(value="/games")
public class GamesRestController {

	//méthodes GET (getAll) POST et PUT
	
	@Autowired
	private IGameDAO gameDAO;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Game>> getAll(){
		return new ResponseEntity<List<Game>>(this.gameDAO.list(), HttpStatus.OK);
	}
}
