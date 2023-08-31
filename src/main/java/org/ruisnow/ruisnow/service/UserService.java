package org.ruisnow.ruisnow.service;

import org.ruisnow.ruisnow.validation.annotation.Password;
import org.ruisnow.ruisnow.validation.annotation.Username;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, UserDetailsPasswordService {

    void signUp(@Username String username, @Password String password);

}
