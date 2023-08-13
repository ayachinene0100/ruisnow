package org.ruisnow.ruisnow.service;

import org.ruisnow.ruisnow.validation.annotation.Password;
import org.ruisnow.ruisnow.validation.annotation.Username;

public interface UserService {

    void signUp(@Username String username, @Password String password);

}
