package com.sopra.dao;

import java.util.List;

import com.sopra.model.Game;

public interface IGameDAO extends IDAO<Game> {
	public List<Game> listWithScore();

}
