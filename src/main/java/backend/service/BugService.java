package backend.service;


import backend.entity.Bug;
import backend.entity.BugTag;
import backend.entity.Tag;
import backend.entity.User;
import backend.repository.BugRepository;
import backend.repository.TagRepository;
import backend.repository.BugTagRepository;
import backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugService {

    private final BugRepository bugRepository;
    private final TagRepository tagRepository;
    private final BugTagRepository bugTagRepository;
    private final UserRepository userRepository;

    public BugService(BugRepository bugRepository, UserRepository userRepository, TagRepository tagRepository, BugTagRepository bugTagRepository) {
        this.bugRepository = bugRepository;
        this.userRepository = userRepository;
        this.bugTagRepository = bugTagRepository;
        this.tagRepository = tagRepository;
    }

    public List<Bug> retrieveBugs() {
        return (List<Bug>) this.bugRepository.findAll();
    }

    public Bug retrieveBugById(Long id) {
        return this.bugRepository.findById(id).orElseThrow(() -> new IllegalStateException("Bug with id not found"));
    }

    public Bug insertBug(Bug bug, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Utilizatorul cu ID-ul " + userId + " nu există!");
        }

        bug.setUser(userOptional.get());

        return bugRepository.save(bug);
    }

    public Bug updateBug(Long bugId, Bug updatedBug) {
        Optional<Bug> existingBugOptional = bugRepository.findById(bugId);
        if (existingBugOptional.isEmpty()) {
            throw new IllegalArgumentException("Bug-ul cu ID-ul " + bugId + " nu există!");
        }
        Bug existingBug = existingBugOptional.get();
        existingBug.setTitle(updatedBug.getTitle());
        existingBug.setText(updatedBug.getText());
        existingBug.setDate(updatedBug.getDate());
        existingBug.setStatus(updatedBug.getStatus());
        existingBug.setImageURL(updatedBug.getImageURL());
        existingBug.setNrOfLikes(updatedBug.getNrOfLikes());
        existingBug.setNrOfDislikes(updatedBug.getNrOfDislikes());

        return bugRepository.save(existingBug);
    }

    public String deleteById(Long id) {
        try {
            this.bugRepository.deleteById(id);
            return "Deletion Successfully";
        } catch (Exception e) {
            return "Failed to delete bug with id " + id;
        }
    }

    @Transactional
    public Bug addBugWithTags(String title, String text, String date, String status, Long userId, List<String> tagNames) {
        Bug bug = new Bug();
        bug.setTitle(title);
        bug.setText(text);
        bug.setDate(date);
        bug.setStatus(status);
        bug.setUser(userRepository.findById(userId).orElse(null));
        bug = bugRepository.save(bug);

        for (String tagName : tagNames) {
            Tag tag = tagRepository.findByName(tagName).orElseGet(() -> {
                Tag newTag = new Tag();
                newTag.setName(tagName);
                return tagRepository.save(newTag);
            });
            BugTag bugTag = new BugTag(bug, tag);
            this.bugTagRepository.save(bugTag);
        }

        return bug;
    }


    @Transactional
    public String addTagToBug(Long bugId, String tagName) {
        Optional<Bug> bugOptional = bugRepository.findById(bugId);
        if (bugOptional.isEmpty()) {
            return "Bug-ul nu există!";
        }
        Bug bug = bugOptional.get();

        Tag tag = tagRepository.findByName(tagName).orElseGet(() -> {
            Tag newTag = new Tag();
            newTag.setName(tagName);
            return tagRepository.save(newTag);
        });

        if (bugTagRepository.existsByBugAndTag(bug, tag)) {
            return "Tag-ul este deja asociat cu acest bug!";
        }
        BugTag bugTag = new BugTag(bug, tag);
        bugTagRepository.save(bugTag);
        return "Tag-ul a fost adăugat cu succes!";
    }

    public List<Tag> getTagsForBug(Long bugId) {
        return bugTagRepository.findTagsByBug_IdBug(bugId);
    }

    public List<Bug> getBugsForTag(Long tagId) {
        return bugTagRepository.findBugsByTag_IdTag(tagId);
    }
}
