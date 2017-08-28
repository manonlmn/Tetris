package com.sopra.dao;

import java.util.List;

import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;

public interface IFigureDAO extends IDAO<Figure> {
	public Figure searchByRotation(int i, int j);
}
