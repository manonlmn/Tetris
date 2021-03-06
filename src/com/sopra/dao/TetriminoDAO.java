package com.sopra.dao;

import java.util.ArrayList;
import java.util.List;

import com.sopra.model.Tetrimino;

public class TetriminoDAO implements ITetriminoDAO {
	// Initialisation stockée dans le context. Uniquement les méthodes sont appelées, donc initialisation = une unique fois.
	List<Tetrimino> myTetriminoList = new ArrayList<Tetrimino>();
	int cpt = 1;
	
	public Tetrimino add(Tetrimino obj) {
		// on applique un ID incrémenté pour le nouvel objet ajouté et on l'ajoute dans la liste
		obj.setIdTetrimino(cpt++);
		myTetriminoList.add(obj);
		return obj;
	}
	
	public Tetrimino modify(Tetrimino obj) {
	
		for(Tetrimino tetrimino : myTetriminoList) {
			if(obj.getIdTetrimino() == tetrimino.getIdTetrimino()) {
				tetrimino.setNameTetrimino(obj.getNameTetrimino());
				tetrimino.setColourTetrimino(obj.getColourTetrimino());
				return tetrimino;
			}
		}
		return null;
	}

	public Tetrimino delete(Tetrimino obj) {
		myTetriminoList.remove(obj);
		return obj;
	}

	public List<Tetrimino> list() {
		return this.myTetriminoList;
	}

	public Tetrimino search(int id) {
		for(Tetrimino tetrimino : myTetriminoList) {
			if(id == tetrimino.getIdTetrimino()) {
				return tetrimino;
			}
		}
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
