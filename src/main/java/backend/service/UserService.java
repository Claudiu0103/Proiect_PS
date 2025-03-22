package backend.service;


import backend.entity.User;
import backend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public List<User> retrieveUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public User retrieveUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("User with id not found");
        });
    }

    public User insertUser(User user) {
        Optional<User> existingUser = this.userRepository.findByUsername(user.getUsername());
        if(existingUser.isPresent()){
            throw new IllegalStateException("Utilizatorul cu acest nume exista deja");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public String deleteById(Long id) {
        try {
            this.userRepository.deleteById(id);
            return "Deletion Successfully";
        } catch (Exception e) {
            return "Failed to delete user with id " + id;
        }
    }
}
