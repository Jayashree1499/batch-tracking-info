package com.bti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.bti.dto.Status;
import com.bti.dto.User;

public class UserDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;

	public User saveUser(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public User findUserById(int id) {
		Query q = entityManager.createQuery("select u from User u where u.id=?1");
		q.setParameter(1, id);
		List<User> user = q.getResultList();
		return user.get(0);

	}

	public User findUserByEmailAndPassword(String email, String password) {
		Query q = entityManager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<User> user = q.getResultList();
		return user.get(0);

	}

	public User updateUser(User user) {
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return user;
	}

	public User modifyUserStatus(int id, Status status) {
		User user = findUserById(id);
		user.setStatus(status);
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return user;

	}

	public void Test() {
		modifyUserStatus(123, Status.INACTIVE);
	}
}
