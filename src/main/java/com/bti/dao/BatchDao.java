package com.bti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bti.dto.Batch;
import com.bti.dto.Status;



@Component
public class BatchDao {
	
	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public Batch saveBatch(Batch batch) {
		entityTransaction.begin();
		entityManager.persist(batch);
		entityTransaction.commit();
		return batch;
	}
	
	public Batch updateBatch(Batch batch) {
		entityTransaction.begin();
		entityManager.merge(batch);
		entityTransaction.commit();
		return batch;
	}
	
	public Batch findBatchByBatchId(int batch_id) {
		Query query=entityManager.createQuery("select b from Batch where b.batch_id=?");
		query.setParameter(1, batch_id);
		List<Batch> list=query.getResultList();
		return list.get(0);
	}
	
	public List<Batch> findBatchByUserId(int user_id) {
		Query query=entityManager.createQuery("select b from Batch where b.user.id=?");
		query.setParameter(1, user_id);
		List<Batch> list=query.getResultList();
		return list;
	}
	
	public Batch modifyBatchStatus(int batch_id,Status status ) {
		Batch batch=findBatchByBatchId(batch_id);
		batch.setStatus(status);
		updateBatch(batch);
		return batch;
		
	}
	
}
