package com.hd.v1unit.item;

import com.hd.repository.ItemRepository;
import com.hd.v1.item.entity.ItemEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*; // assertThat

@Slf4j
@DataJpaTest // spring boot의 모든게 올라오는게 아니라 JPA 관련 메모리만 올리게 된다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 메모리DB를 무조건 가지므로 NONE으로 해놓으면 필요에 따라 mysql, 메모리DB
@DisplayName("Item Repository Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("h2db") // 필요에 따라 빠르게 전환 가능하다 -> 어느정도 테스트가 됐다고 하면 "dev"로 바꾸면 된다
public class RepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Order(1)
    @DisplayName("1. Insert Test")
    public void test1() {
        // given : 데이터가 주워졌다
        String name = "pants1";
        long price = 1000L;

        // when
        ItemEntity itemEntity = itemRepository.save(ItemEntity.builder()
                        .name(name)
                        .price(price)
                .build());


        log.info("itemEntity: {}", itemEntity);
        // then : assert로 테스트
        // junit5랑 assert가 같이 있어서 assertThat은 잘 안먹는다
        assertThat(name).isEqualTo(itemEntity.getName());
        assertThat(price).isEqualTo(itemEntity.getPrice());
        assertThat(itemEntity.getId()).isNotNull();
        assertThat(1L).isEqualTo(itemEntity.getId());
    }

}
