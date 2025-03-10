package backend.config;

import backend.entity.User;
import backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            /*User user2 = new User("ana2904","1234567a",Boolean.FALSE,0.0,"User");
            userRepository.save(user2);*/
//            userRepository.deleteById(3L);


        };
    }
}