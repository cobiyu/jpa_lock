package com.cobi.jpa.lock.repositories;

import com.cobi.jpa.lock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.age = :age")
    Optional<User> findByAge(int age);
}
