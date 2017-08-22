package com.sopra.dao.hibernate;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Tetrimino;
@Stateless
public class TetriminoDaoHibernate implements ITetriminoDAO {
	@PersistenceContext(unitName="NomPersistenceUnit")
	private EntityManager em; 
	
	@Override
	public Tetrimino add(Tetrimino obj) {
		return em.merge(obj);
	}

	@Override
	public Tetrimino modify(Tetrimino obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		Tetrimino tetrimino = this.search(id);
		em.remove(tetrimino);

	}

	@Override
	public List<Tetrimino> list() {
		return em.createQuery("select t from Tetrimino t").getResultList();
	}

	@Override
	public Tetrimino search(int id) {
		return em.find(Tetrimino.class, id);
	}

}
