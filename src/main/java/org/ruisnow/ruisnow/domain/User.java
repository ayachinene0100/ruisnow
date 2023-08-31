package org.ruisnow.ruisnow.domain;

import jakarta.persistence.Entity;
import org.ruisnow.ruisnow.validation.annotation.Password;
import org.ruisnow.ruisnow.validation.annotation.Username;

import java.util.regex.Pattern;

@Entity
public class User extends AbstractEntity {

    public static final String USERNAME_REGEX = "^[a-zA-Z]\\w{1,18}[a-zA-Z0-9]$";

    public static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);

    public static final String PASSWORD_REGEX = "^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{5,19})\\S$";

    public static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
