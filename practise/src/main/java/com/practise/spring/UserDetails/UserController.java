package com.practise.spring.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
public class UserController {

    @Autowired
    UserdaoService userdaoService;

    @GetMapping(path = "/users")
    public Collection<User> getAllUsers() throws Exception {
        return userdaoService.getUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable Integer id) throws Exception {
        return userdaoService.getUser(id);
    }

    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        User savedUser = userdaoService.saveUser(user);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/users/delete/{id}")
    public User deleteUser(@PathVariable Integer id) {
        return userdaoService.deleteUser(id);
    }
}
