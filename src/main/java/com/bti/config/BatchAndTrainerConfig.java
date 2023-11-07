package com.bti.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.bti.controller", "com.bti.dao", "com.bti.dto" })
public class BatchAndTrainerConfig {
	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vikas").createEntityManager();
	}

	@Bean
	public EntityTransaction getEntityTransaction() {
		return getEntityManager().getTransaction();
	}

}
