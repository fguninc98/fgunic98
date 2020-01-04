package com.api.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.api.model.User;
import com.api.repository.UserRepository;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private UserRepository userRepository;

    public TestDataRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Insert admin
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole("ROLE_ADMIN");
        userRepository.save(admin);
    }
}

