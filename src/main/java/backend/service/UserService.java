package backend.service;


import backend.entity.User;
import backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> retrieveUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public User retrieveUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("User with id not found");
        });
    }

    public User insertUser(User user) {
        Optional<User> existingUser = this.userRepository.findById(user.getIdUser());
        if(existingUser.isPresent()){
            throw new IllegalStateException("Utilizatorul cu acest nume exista deja");
        }
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
