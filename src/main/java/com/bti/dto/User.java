package com.bti.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user1")
@Component
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
	@SequenceGenerator(name = "user_id", initialValue = 101, allocationSize = 1)
	int id;
	@Column(nullable = false)
	String name;
	@Column(unique = true, nullable = false)
	String email;
	@Column(nullable = false)
	String password;
	String role;
	@OneToMany
	List<Batch> batch;

}
