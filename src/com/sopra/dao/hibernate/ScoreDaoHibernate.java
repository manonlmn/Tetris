package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IScoreDAO;
import com.sopra.model.Score;

@Repository
@Transactional
public class ScoreDaoHibernate implements IScoreDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Score add(Score obj) {
		return em.merge(obj);
	}

	@Override
	public Score modify(Score obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		Score score = this.search(id);
		em.remove(score);
	}

	@Override
	public List<Score> list() {
		return em.createQuery("select sc from Score sc").getResultList();
	}

	@Override
	public Score search(int id) {
		return em.find(Score.class, id);
	}

}
