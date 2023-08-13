package org.ruisnow.ruisnow.domain;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUsernameRegex() {
        assertAll(
                () -> assertTrue("abcd22222".matches(User.USERNAME_REGEX)),
                () -> assertTrue("aaa".matches(User.USERNAME_REGEX)),
                () -> assertFalse("a".matches(User.USERNAME_REGEX)),
                () -> assertFalse("ab".matches(User.USERNAME_REGEX)),
                () -> assertFalse("_abcd1234".matches(User.USERNAME_REGEX)),
                () -> assertFalse("abcd_1234_".matches(User.USERNAME_REGEX)),
                () -> assertFalse("aaaaaaaaaaaaaaaaaaaaa".matches(User.USERNAME_REGEX))
        );
    }

    @Test
    void testPasswordRegex() {
        assertAll(
                () -> assertTrue("Abcd1234!!".matches(User.PASSWORD_REGEX)),
                () -> assertTrue("Abcde1".matches(User.PASSWORD_REGEX)),
                () -> assertTrue("abcA111".matches(User.PASSWORD_REGEX)),
                () -> assertFalse("1234567".matches(User.PASSWORD_REGEX)),
                () -> assertFalse("abcd12".matches(User.PASSWORD_REGEX)),
                () -> assertFalse("Ab3456789012345678901".matches(User.PASSWORD_REGEX)),
                () -> assertFalse("".matches(User.PASSWORD_REGEX))
        );
    }

}