package com.example.repository;

import com.example.entity.Good;
import com.example.entity.GoodDetail;
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
public class GoodRepositoryTest {

	@Autowired
	private GoodRepository goodRepository;

	@Test
	public void testListAll() {
		List<Good> goods = goodRepository.findAll();
		assertThat(goods).isNotEmpty();
		goods.forEach(System.out::println);
	}

	@Test
	public void testAddGoodWithoutDetail() {
		Good good = new Good();
		good.setName("iPhone 15");
		good.setPrice(999);
		Good savedGood = goodRepository.save(good);
		assertThat(savedGood).isNotNull();
	}

	@Test
	public void testAddGoodWithDetail() {
		Good good = new Good();
		GoodDetail goodDetail = new GoodDetail();

		good.setName("iPhone 15");
		good.setPrice(289);
		good.setGoodDetail(goodDetail);

		goodDetail.setDescription("New Android Phone in 2023");
		goodDetail.setWeight(3.5f);
		goodDetail.setHeight(0.5f);
		goodDetail.setLength(4.5f);
		goodDetail.setWidth(4.1f);

		Good savedGood = goodRepository.save(good);

		assertThat(savedGood).isNotNull();

	}
}