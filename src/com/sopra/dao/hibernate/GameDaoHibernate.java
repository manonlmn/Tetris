package com.sopra.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IGameDAO;
import com.sopra.model.Game;

@Repository
@Transactional
public class GameDaoHibernate implements IGameDAO {
	@PersistenceContext
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
	
	
	public List<Game> listWithScore() {
		List<Game> myGames = new ArrayList<Game>();
		myGames =(List<Game>) em.createQuery("select distinct g from Game g left join fetch g.myScores").getResultList();
		return myGames;
	}

	@Override
	public List<Game> listWithScoreSolo() {
		List<Game> myGames = new ArrayList<Game>();
		myGames = (List<Game>) em.createQuery("select distinct g from Game g left join fetch g.myScores where g.type='0'").getResultList();
		return myGames;
	}

	@Override
	public List<Game> listWithScoreMulti() {
		List<Game> myGames = new ArrayList<Game>();
		myGames = (List<Game>) em.createQuery("select distinct g from Game g left join fetch g.myScores where g.type='1'").getResultList();
		return myGames;
	}

}
