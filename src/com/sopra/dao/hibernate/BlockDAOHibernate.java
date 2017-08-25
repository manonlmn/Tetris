package com.sopra.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sopra.dao.IBlockDAO;
import com.sopra.model.Block;
import com.sopra.model.Game;

@Repository
@Transactional
public class BlockDAOHibernate implements IBlockDAO {
	
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public Block add(Block obj) {
		return em.merge(obj);
	}

	@Override
	public Block modify(Block obj) {
		return this.add(obj);
	}

	@Override
	public void delete(int id) {
		Block block = this.search(id);
		em.remove(block);
	}

	@Override
	public List<Block> list() {
		return em.createQuery("select g from Block g").getResultList();
	}

	@Override
	public Block search(int id) {
		return em.find(Block.class, id);
	}
	
}
