package com.cobi.jpa.lock.services;

import com.cobi.jpa.lock.entities.User;
import com.cobi.jpa.lock.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User getUser() throws InterruptedException {
        int age = 4;

        Optional<User> optionalUser = userRepository.findById(20L);
        User user = optionalUser.orElse(User.builder().age(age).name("name" + age).build());
        user.addAge();

        userRepository.save(user);

        return user;
    }
}
