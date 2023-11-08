package com.bti.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.bti" })
public class BatchAndTrainerConfig {
	@Bean(name = "em")
	public EntityManager getEntityManager() {
		System.out.println("Hi");
		return Persistence.createEntityManagerFactory("vikas").createEntityManager();
	}

	@Bean
	public EntityTransaction getEntityTransaction() {
		return getEntityManager().getTransaction();
	}

}
