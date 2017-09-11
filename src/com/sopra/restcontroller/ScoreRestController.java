package com.sopra.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.IScoreDAO;
import com.sopra.model.Score;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/score")
public class ScoreRestController {
	
	@Autowired
	private IScoreDAO scoreDAO;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Score> getById(@PathVariable Integer id){
		Score score = this.scoreDAO.search(id);
		return new ResponseEntity<Score> (score, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Score>> getAll(){
		List<Score> listScore = this.scoreDAO.list();
		return new ResponseEntity<List<Score>> (listScore, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Score> add(@RequestBody Score score){
		score = this.scoreDAO.add(score);
		return new ResponseEntity<Score>(score, HttpStatus.OK);
		}
}
