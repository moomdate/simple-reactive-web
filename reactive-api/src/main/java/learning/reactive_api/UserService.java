package learning.reactive_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> createUser(User user) {
        return userRepository.save(user);  // Save user to MongoDB
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();  // Fetch all users from the database
    }
}
