package com.springboot.jpa.springbootjpa.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.jpa.springbootjpa.entity.User;
@Repository
@Transactional
public class UserDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long saveUser(User user) {
		 entityManager.persist(user);
		 return user.getId();
	}
}
