package org.ruisnow.ruisnow.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.ruisnow.ruisnow.validation.validator.UsernameValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameValidator.class)
public @interface Username {

    String message() default "用户名格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
