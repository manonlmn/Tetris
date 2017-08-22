/**
 * 
 */
package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sopra.dao.IPersonDAO;
import com.sopra.model.Admin;
import com.sopra.model.Person;

/**
 * @author mlemonnier
 *
 */
public class PersonDaoHibernate implements IPersonDAO {
	@PersistenceContext(unitName="NomPersistenceUnit")
	private EntityManager em; 
	 
	@Override
	public Person add(Person obj) {
		return em.merge(obj);
	}

	@Override
	public Person modify(Person obj) {
		return this.add(obj);
	}

	 
	@Override
	public void delete(int id) {
		Person person = this.search(id);
		em.remove(person);
	}
 
	@Override
	public List<Person> list() {
		return em.createQuery("select p from Person p").getResultList();
	}
 
	@Override
	public Person search(int id) {
		return em.find(Admin.class, id);
	}

}
