package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Spring Data JPA One to One with Foreign Key
 */
@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private float price;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_detail_id", referencedColumnName = "id")
	private ItemDetail itemDetail;
}
