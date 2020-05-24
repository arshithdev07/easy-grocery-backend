package com.grocery.management.repository;

import com.grocery.management.domain.GroceryList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by arshi on 5/15/2020.
 */
public interface GroceryListRepository extends CrudRepository<GroceryList, Long> {

    @Query("FROM GroceryList g WHERE g.user.id = :userId")
    Optional<GroceryList> findByCurrentUser(@Param("userId") Long userId);
}
