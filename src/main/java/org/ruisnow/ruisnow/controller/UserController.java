package org.ruisnow.ruisnow.controller;

import jakarta.validation.constraints.NotNull;
import org.ruisnow.ruisnow.service.UserService;
import org.ruisnow.ruisnow.support.exception.NeedLoginException;
import org.ruisnow.ruisnow.validation.annotation.Password;
import org.ruisnow.ruisnow.validation.annotation.Username;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public void signUp(@NotNull(message = "用户名不能为空") @Username String username,
                       @NotNull(message = "密码不能为空") @Password String password) {
        userService.signUp(username, password);
    }

    @PostMapping("/portal/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping ("/loginHint")
    public void loginHint() {
        throw new NeedLoginException("请登录");
    }
}
