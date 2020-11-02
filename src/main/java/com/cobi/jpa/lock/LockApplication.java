package com.cobi.jpa.lock;

import com.cobi.jpa.lock.entities.User;
import com.cobi.jpa.lock.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class LockApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockApplication.class, args);
    }

    @Bean
    CommandLineRunner onStartUp(UserService userService) {
        return args -> {

            Runnable task = () -> {
                User user = null;
                try {
                    user = userService.getUser();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Runnable task2 = () -> {
                User user = null;
                try {
                    user = userService.getUser();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Thread thread = new Thread(task);
            Thread thread2 = new Thread(task2);

            thread.start();
            Thread.sleep(30L);
            thread2.start();
        };
    }

}
