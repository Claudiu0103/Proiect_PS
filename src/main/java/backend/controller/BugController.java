package backend.controller;

import backend.entity.Bug;
import backend.entity.User;
import backend.service.BugService;
import backend.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bug")
public class BugController {

    @Autowired
    private BugService bugService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Bug> getAllBugs() {
        return this.bugService.retrieveBugs();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Bug getBugById(@PathVariable Long id) {
        return this.bugService.retrieveBugById(id);
    }

    @PostMapping("/addBug")
    public ResponseEntity<Bug> addBug(@RequestParam String title,
                                      @RequestParam String text,
                                      @RequestParam String date,
                                      @RequestParam String status,
                                      @RequestParam Long userId) {
        Bug bug = new Bug();
        bug.setTitle(title);
        bug.setText(text);
        bug.setDate(date);
        bug.setStatus(status);
        Bug savedBug = bugService.insertBug(bug, userId);
        return ResponseEntity.ok(savedBug);
    }

    @PutMapping("/updateBug/{bugId}")
    public ResponseEntity<Bug> updateBug(@PathVariable Long bugId, @RequestBody Bug bug) {
        Bug updatedBug = bugService.updateBug(bugId, bug);
        return ResponseEntity.ok(updatedBug);
    }


    @DeleteMapping("/deleteById")
    @ResponseBody
    public String deleteBugById(@RequestParam Long id) {
        return this.bugService.deleteById(id);
    }
}
