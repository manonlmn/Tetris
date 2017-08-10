package com.sopra.dao;

import java.util.ArrayList;
import java.util.List;

import com.sopra.model.Tetrimino;

public class TetriminoDAO implements ITetriminoDAO {

	List myTetriminoList = new ArrayList();
	// int cpt = 0;
	
	public Tetrimino add(Tetrimino obj) {
		// incrémentation du compteur d'ID
		// cpt++;
		
		// récupération du nom et de la couleur du tétrimino à ajouter
		Tetrimino myTetrimino = new Tetrimino();
		myTetrimino.setNameTetrimino(obj.getNameTetrimino());
		myTetrimino.setColourTetrimino(obj.getColourTetrimino());
		
		// attribution de l'ID du tétrimino à ajouter
		
		
		// ajout du tétrimino complet à la liste
		myTetriminoList.add(obj);
		
		return null;
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
