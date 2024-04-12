package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private float weight;
	private float length;
	private float height;
	private float width;
	@OneToOne
	@JoinColumn(name = "product_id")
	@MapsId
	private Product product;
}
