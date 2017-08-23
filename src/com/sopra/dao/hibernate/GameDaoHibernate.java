package com.sopra.dao.hibernate;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sopra.dao.IGameDAO;
import com.sopra.model.Game;

@Stateless
public class GameDaoHibernate implements IGameDAO {
	@PersistenceContext(unitName="NomPersistenceUnit")
	private EntityManager em; 
	
	@Override
	public Game add(Game obj) {
		return em.merge(obj);
	}

	@Override
	public Game modify(Game obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		Game game = this.search(id);
		em.remove(game);
	}

	@Override
	public List<Game> list() {
		return em.createQuery("select g from Game g").getResultList();
	}

	@Override
	public Game search(int id) {
		return em.find(Game.class, id);
	}

}
