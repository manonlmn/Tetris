package com.sopra.dao;

import com.sopra.model.Player;

public interface IPlayerDAO extends IDAO<Player> {
	public Player searchbyUNandPWd(String username, String password);

}
