package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "good_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoodDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private float weight;
	private float length;
	private float height;
	private float width;

	@OneToOne(mappedBy = "goodDetail")
	private Good good;
}
