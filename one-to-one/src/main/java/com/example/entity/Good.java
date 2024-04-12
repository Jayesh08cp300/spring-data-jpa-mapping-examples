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
@Table(name = "goods")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Good {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private float price;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "goods_details", joinColumns = { @JoinColumn(name = "good_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "good_detail_id", referencedColumnName = "id") })
	private GoodDetail goodDetail;
}
