package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IAdminDAO;
import com.sopra.model.Admin;

@Repository
@Transactional
public class AdminDaoHibernate implements IAdminDAO {
	@PersistenceContext
	private EntityManager em; 

	@Override
	public Admin add(Admin obj) {
		return em.merge(obj);
	}

	@Override
	public Admin modify(Admin obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		Admin admin = this.search(id);
		em.remove(admin);		
	}

	@Override
	public List<Admin> list() {
		return em.createQuery("select a from Admin a").getResultList();
	}

	@Override
	public Admin search(int id) {
		return em.find(Admin.class, id);
	}

	@Override
	public Admin searchbyUNandPWd(String username, String password) {
		Query myQuery = em.createQuery("select a from Admin a where a.username= :username and a.password= :password");

		//On insère les paramètres
		myQuery.setParameter("username", username);
		myQuery.setParameter("password", password);

		try {
			return (Admin) myQuery.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}

	}



}
