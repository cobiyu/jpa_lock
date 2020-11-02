package com.cobi.jpa.lock.repositories;

import com.cobi.jpa.lock.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.age = :age")
    Optional<User> findByAge(int age);

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Override
    Optional<User> findById(Long aLong);
}
