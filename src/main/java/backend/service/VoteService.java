package backend.service;


import backend.entity.Vote;
import backend.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private IVoteRepository voteRepository;

    public List<Vote> retrieveVotes() {
        return (List<Vote>) this.voteRepository.findAll();
    }

    public Vote retrieveVoteById(Long id) {
        return this.voteRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Vote with id not found");
        });
    }

    public Vote insertVote(Vote vote) {
        Optional<Vote> existingUser = this.voteRepository.findById(vote.getIdVote());
        if(existingUser.isPresent()){
            throw new IllegalStateException("Votul cu acest nume exista deja");
        }
        return voteRepository.save(vote);
    }

    public String deleteById(Long id) {
        try {
            this.voteRepository.deleteById(id);
            return "Deletion Successfully";
        } catch (Exception e) {
            return "Failed to delete vote with id " + id;
        }
    }
}
