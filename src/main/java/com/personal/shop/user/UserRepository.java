package com.personal.shop.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

  /*  @Query("SELECT u from User u where u.username = ?1")
    public Optional<User> findUserByUsername(String username);

    @Query("SELECT count(u) = 1 FROM User u where u.username = ?1")
    public boolean existsByUsername(String username);
*/
}