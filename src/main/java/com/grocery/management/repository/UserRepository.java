package com.grocery.management.repository;

import com.grocery.management.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by arshi on 5/6/2020.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserName(String username);
}
