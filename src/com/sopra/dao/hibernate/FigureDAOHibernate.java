package com.sopra.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sopra.dao.IFigureDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Figure;
import com.sopra.model.Game;
import com.sopra.model.Tetrimino;

@Repository
@Transactional
public class FigureDAOHibernate implements IFigureDAO {
	
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public Figure add(Figure obj) {
		return em.merge(obj);
	}

	@Override
	public Figure modify(Figure obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		Figure figure = this.search(id);
		em.remove(figure);
	}

	@Override
	public List<Figure> list() {
		return em.createQuery("select f from Figure f").getResultList();
	}

	@Override
	public Figure search(int id) {
		return em.find(Figure.class, id);
	}
	
	public Figure searchByRotation(int rotationN, int id) {
		Figure figure = null;	
		try {
		figure = (Figure) em.createQuery("select f from Figure f where rotationNumber="+rotationN+" and tetrimino.id="+id).getSingleResult();
		}
		catch(Exception e) {
		}
		return figure;
	}
}
