package com.ceylan.myRecipesBook.repository;

import com.ceylan.myRecipesBook.entity.concrete.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User getByEmail(String email);

    User getByPassword(String password);

    boolean existsByEmail(String email);

    boolean existsByPassword(String password);

}
