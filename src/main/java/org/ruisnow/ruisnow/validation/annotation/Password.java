package org.ruisnow.ruisnow.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.ruisnow.ruisnow.validation.validator.PasswordValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

    String message() default "密码格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
