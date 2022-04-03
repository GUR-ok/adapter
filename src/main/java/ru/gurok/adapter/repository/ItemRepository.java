package ru.gurok.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.gurok.adapter.domain.model.Item;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findByTitleLike(String name);

    @Query("{name:'?0'}")
    List<Item> findCustomByTitle(String name);
}
