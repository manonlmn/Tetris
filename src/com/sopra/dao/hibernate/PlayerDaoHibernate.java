package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IPlayerDAO;
import com.sopra.model.Admin;
import com.sopra.model.Player;

@Repository
@Transactional
public class PlayerDaoHibernate implements IPlayerDAO {

	@PersistenceContext
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
		return em.createQuery("select pl from Player pl").getResultList();
	}

	@Override
	public Player search(int id) {
		return em.find(Player.class, id);
	}
	
	@Override
	public Player searchbyUNandPWd(String username, String password) {
		Query myQuery = em.createQuery("select p from Player p where p.username= :username and p.password= :password and p.banned=false");

		//On ins�re les param�tres
		myQuery.setParameter("username", username);
		myQuery.setParameter("password", password);

		try {
			return (Player) myQuery.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}

	}

}
