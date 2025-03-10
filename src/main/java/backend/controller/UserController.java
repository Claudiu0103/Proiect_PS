package backend.controller;

import backend.entity.User;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAllBugs() {
        return this.userService.retrieveUsers();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        return this.userService.retrieveUserById(id);
    }

    @PostMapping("/addUser")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return this.userService.insertUser(user);
    }

    @PutMapping("/updateUser")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return this.userService.insertUser(user);
    }

    @DeleteMapping("/deleteById")
    @ResponseBody
    public String deleteUserById(@RequestParam Long id) {
        return this.userService.deleteById(id);
    }
}
