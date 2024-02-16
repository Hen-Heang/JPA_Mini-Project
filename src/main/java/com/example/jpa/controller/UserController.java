package com.example.jpa.controller;

import com.example.jpa.payload.user.UserRequest;
import com.example.jpa.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController extends AbstractRestController {
    private final UserService userService;

    @PostMapping("/add")
    public Object createUser(@RequestBody UserRequest userRequest) {
        if (userRequest.getName() == null || userRequest.getName().isBlank()) {
            throw new IllegalArgumentException("User can not be blank");
        }
        userService.createUser(userRequest);
        return ok();
    }

    @GetMapping("/all")
    public Object getAllUser(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ) {

        return ok(userService.getAllUser(page, size));
    }

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable("id") Long id) {
        var findUser = userService.getUserById(id);
        if (findUser != null ) {
            throw new NotFoundException("There is no data for this id: " + id);
        }
        return ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public Object updateUser(@PathVariable("id") Long id, UserRequest userRequest) {
        return ok(userService.updateUser(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public Object deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ok();
    }
}
