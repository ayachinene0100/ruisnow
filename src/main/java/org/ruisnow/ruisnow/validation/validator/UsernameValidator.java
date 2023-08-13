package org.ruisnow.ruisnow.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.ruisnow.ruisnow.domain.User;
import org.ruisnow.ruisnow.validation.annotation.Username;

public class UsernameValidator implements ConstraintValidator<Username, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isNotEmpty(value) && User.USERNAME_PATTERN.matcher(value).matches();
    }
}
