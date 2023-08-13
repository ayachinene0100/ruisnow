package org.ruisnow.ruisnow.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.ruisnow.ruisnow.domain.User;
import org.ruisnow.ruisnow.validation.annotation.Password;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isNotEmpty(value) && User.PASSWORD_PATTERN.matcher(value).matches();
    }
}
