package backend.controller;

import backend.entity.User;
import backend.entity.Vote;
import backend.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Vote> getAllBugs() {
        return this.voteService.retrieveVotes();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Vote getUserById(@PathVariable Long id) {
        return this.voteService.retrieveVoteById(id);
    }

    @PostMapping("/addVote")
    @ResponseBody
    public Vote addVote(@RequestBody Vote vote) {
        return this.voteService.insertVote(vote);
    }

    @PutMapping("/updateVote")
    @ResponseBody
    public Vote updateVote(@RequestBody Vote vote) {
        return this.voteService.insertVote(vote);
    }

    @DeleteMapping("/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id) {
        return this.voteService.deleteById(id);
    }
}
