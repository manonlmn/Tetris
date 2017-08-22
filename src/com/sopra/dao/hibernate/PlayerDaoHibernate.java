package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sopra.dao.IPlayerDAO;
import com.sopra.model.Player;

public class PlayerDaoHibernate implements IPlayerDAO {

	@PersistenceContext(unitName="NomPersistenceUnit")
	private EntityManager em; 
	
	@Override
	public Player add(Player obj) {
		return em.merge(obj);
	}

	@Override
	public Player modify(Player obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		Player player = this.search(id);
		em.remove(player);

	}

	@Override
	public List<Player> list() {
		return em.createQuery("select pl from player pl").getResultList();
	}

	@Override
	public Player search(int id) {
		return em.find(Player.class, id);
	}

}
