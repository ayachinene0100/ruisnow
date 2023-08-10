package org.ruisnow.ruisnow.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.ruisnow.ruisnow.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeAll
    void generateData() {
        User ruisnow = new User();
        ruisnow.setUsername("ruisnow");
        ruisnow.setPassword("1234");
        userRepository.save(ruisnow);

        User shiliu = new User();
        shiliu.setUsername("shiliu");
        shiliu.setPassword("5678");
        userRepository.save(shiliu);
    }

    @Test
    void testSave() {
        User user = new User();
        user.setUsername("someUser");
        user.setPassword("1234");
        Optional<User> saved = userRepository.findById(userRepository.save(user).getId());
        assertTrue(saved.isPresent());
    }

    @Test
    void testQuery() {
        assertTrue(userRepository.findByUsername("ruisnow").isPresent());
    }

}