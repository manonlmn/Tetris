package com.sopra.dao;

import java.util.ArrayList;
import java.util.List;

import com.sopra.model.Tetrimino;

public class TetriminoDAO implements ITetriminoDAO {

	List myTetriminoList = new ArrayList();
	int cpt = 1;
	
	public Tetrimino add(Tetrimino obj) {

		obj.setIdTetrimino(cpt++);
		myTetriminoList.add(obj);
		
		return obj;
	}
	
	public Tetrimino modify(Tetrimino obj) {
		return null;
	}

	public Tetrimino delete(Tetrimino obj) {
		return null;
	}

	public List<Tetrimino> list() {
		
		return null;
	}
}
