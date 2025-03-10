package backend.config;

import backend.entity.Bug;
import backend.entity.Comment;
import backend.entity.User;
import backend.repository.BugRepository;
import backend.repository.CommentRepository;
import backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentConfig {
    @Bean
    CommandLineRunner commandLineRunner3(BugRepository bugRepository, UserRepository userRepository, CommentRepository commentRepository) {
        return args -> {
            /*User user = userRepository.findById(7L).orElse(null);
            Bug bug1 = bugRepository.findById(3L).orElse(null);
            Comment comment1 = new Comment("ai dreptate, mi s a intamplat si mie asta", "20.05.2025","sdfsdfsd",2,0,user,bug1);
            commentRepository.save(comment1);*/

        };
    }
}