package com.cobi.jpa.lock;

import com.cobi.jpa.lock.entity.User;
import com.cobi.jpa.lock.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class LockTest {
    private static final ExecutorService service =
            Executors.newFixedThreadPool(3);
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void test() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            @Transactional
            public void run() {
                Optional<User> optionalUser = userRepository.findByAge(4);
                System.out.println(optionalUser.get());
            }
        });
        t.start();
        t.join();
    }
}
