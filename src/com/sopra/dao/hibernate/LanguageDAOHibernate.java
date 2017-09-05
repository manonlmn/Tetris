package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.ILanguageDAO;
import com.sopra.model.Language;

@Repository
@Transactional
public class LanguageDAOHibernate implements ILanguageDAO {
	
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public Language add(Language obj) {
		return em.merge(obj);
	}

	@Override
	public Language modify(Language obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		Language language = this.search(id);
		em.remove(language);
	}

	@Override
	public List<Language> list() {
		return em.createQuery("select l from Language l").getResultList();
	}

	@Override
	public Language search(int id) {
		return em.find(Language.class, id);
	}
	
	@Override
	public Language searchByCode(String code) {
		Language language = null;
		try {
		language = (Language)em.createQuery("select l from Language l where l.code = "+code).getSingleResult();
		}
		catch(Exception e) {
		}
		return language;
	}

}
