package com.bti.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "image_id")
	@SequenceGenerator(name="image_id",initialValue = 301,allocationSize = 1)
	private int image_id;
	private byte [] pic;
	
}
