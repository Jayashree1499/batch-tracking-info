package com.bti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bti.dto.Role;
import com.bti.dto.Status;
import com.bti.dto.User;

@Component
public class UserDao {

	@Autowired
	EntityManager em;
	@Autowired
	EntityTransaction entityTransaction;

	public User saveUser(User user) {
		entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.persist(user);
		entityTransaction.commit();
		return user;
	}

	public User findUserById(int id) {
		Query q = em.createQuery("select u from User u where u.id=?1");
		q.setParameter(1, id);
		List<User> user = q.getResultList();
		return user.get(0);

	}

	public User findUserByEmailAndPassword(String email, String password) {
		Query q = em.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<User> users = (List<User>) q.getResultList();
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;

	}

	public User updateUser(User user) {
		entityTransaction.begin();
		em.merge(user);
		entityTransaction.commit();
		return user;
	}

	public User modifyUserStatus(int id, Status status) {
		User user = findUserById(id);
		user.setStatus(status);
		entityTransaction.begin();
		em.merge(user);
		entityTransaction.commit();
		return user;

	}

	public List<User> userbasedOnRole(Role role) {
		Query query = em.createQuery("select u from User u where u.role=?1");
		query.setParameter(1, role);
		List<User> user = (List<User>) query.getResultList();
		return user;
	}

//	public void Test() {
//		modifyUserStatus(123, Status.INACTIVE);
//	}

}
