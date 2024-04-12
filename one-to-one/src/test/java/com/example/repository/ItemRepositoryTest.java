package com.example.repository;

import com.example.entity.Item;
import com.example.entity.ItemDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void testListAll() {
		List<Item> items = itemRepository.findAll();
		assertThat(items).isNotEmpty();
		items.forEach(System.out::println);
	}

	@Test
	public void testAdd() {
		Item item = new Item();
		ItemDetail itemDetail = new ItemDetail();

		item.setName("Iphone");
		item.setPrice(100000);

		item.setItemDetail(itemDetail);

		itemDetail.setDescription("New iPhone version in 2023");
		itemDetail.setWeight(2.5f);
		itemDetail.setHeight(0.7f);
		itemDetail.setLength(4.0f);
		itemDetail.setWidth(3.5f);

		Item save = itemRepository.save(item);

		assertThat(save).isNotNull();

	}
}
