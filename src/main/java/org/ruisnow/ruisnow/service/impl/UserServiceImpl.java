package org.ruisnow.ruisnow.service.impl;

import org.ruisnow.ruisnow.domain.User;
import org.ruisnow.ruisnow.repository.UserRepository;
import org.ruisnow.ruisnow.service.UserService;
import org.ruisnow.ruisnow.support.exception.UserExistsException;
import org.ruisnow.ruisnow.validation.annotation.Password;
import org.ruisnow.ruisnow.validation.annotation.Username;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(@Username String username, @Password String password) {
        boolean alreadySigned = userRepository.existsByUsername(username);
        if (alreadySigned) {
            throw new UserExistsException("用户已注册");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        User user = optionalUser.get();
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }

    @Override
    public UserDetails updatePassword(UserDetails userDetails, String newPassword) {
        Optional<User> optionalUser = userRepository.findByUsername(userDetails.getUsername());
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("用户不存在");
        }
        User user = optionalUser.get();
        user.setPassword(newPassword);
        userRepository.save(user);
        return loadUserByUsername(userDetails.getUsername());
    }
}
