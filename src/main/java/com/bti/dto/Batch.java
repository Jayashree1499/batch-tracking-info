package com.bti.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_id")
	@SequenceGenerator(name = "batch_id", initialValue = 201, allocationSize = 1)
	private int id;
	private String subject;
	private LocalDate createDate;

	private Status status;

	@OneToMany
	private List<Image> image;
}
