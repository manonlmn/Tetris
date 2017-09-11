package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IFAQLanguageDAO;
import com.sopra.model.FAQ;
import com.sopra.model.FAQLanguage;


@Repository
@Transactional
public class FAQLanquageDAOHibernate implements IFAQLanguageDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public FAQLanguage add(FAQLanguage obj) {
		return em.merge(obj);
	}

	@Override
	public FAQLanguage modify(FAQLanguage obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		FAQLanguage faqLanguage = this.search(id);
		em.remove(faqLanguage);
	}

	@Override
	public List<FAQLanguage> list() {
		return em.createQuery("select fl from FAQLanguage fl").getResultList();
	}
	
	

	@Override
	public FAQLanguage search(int id) {
		return em.find(FAQLanguage.class, id);
	}

}
