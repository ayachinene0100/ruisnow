package org.ruisnow.ruisnow.service.impl;

import org.ruisnow.ruisnow.domain.User;
import org.ruisnow.ruisnow.support.exception.UserExistsException;
import org.ruisnow.ruisnow.repository.UserRepository;
import org.ruisnow.ruisnow.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(String username, String password) {
        boolean alreadySigned = userRepository.existsByUsername(username);
        if (alreadySigned) {
            throw new UserExistsException("用户已注册");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }
}
