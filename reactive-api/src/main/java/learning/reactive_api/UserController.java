package learning.reactive_api;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private  UserService userService;


    @PostMapping
    public Mono<User> createUser(@Valid @RequestBody User user) {
        System.out.println("User: " + user.getEmail());
        return userService.createUser(user);
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();  // Fetch all users
    }
}
