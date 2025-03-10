package backend.config;

import backend.entity.Bug;
import backend.entity.User;
import backend.repository.BugRepository;
import backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BugConfig {
    @Bean
    CommandLineRunner commandLineRunner2(BugRepository bugRepository, UserRepository userRepository) {
        return args -> {
            /*User user = userRepository.findById(6L).orElse(null);
            Bug bug1 = new Bug("Bad Remove", "Remove is not working properly","20.05.2025","Received","dfgdfgfdg",12,5,user);
            bugRepository.save(bug1);*/

        };
    }
}