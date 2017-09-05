package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IFAQDAO;
import com.sopra.model.FAQ;

@Repository
@Transactional
public class FaqDaoHibernate implements IFAQDAO{

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public FAQ add(FAQ obj) {
		return em.merge(obj);
	}

	@Override
	public FAQ modify(FAQ obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		FAQ faq = this.search(id);
		em.remove(faq);		
	}

	@Override
	public List<FAQ> list() {
		return em.createQuery("select f from FAQ f").getResultList();
	}

	@Override
	public FAQ search(int id) {
		return em.find(FAQ.class, id);
	}

}
