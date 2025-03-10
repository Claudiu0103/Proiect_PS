package backend.service;


import backend.entity.Tag;
import backend.entity.User;
import backend.repository.TagRepository;
import backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> retrieveTags() {
        return (List<Tag>) this.tagRepository.findAll();
    }

    public Tag retrieveTagById(Long id) {
        return this.tagRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Tag with id not found");
        });
    }

    public Tag insertTag(Tag tag) {
        return this.tagRepository.save(tag);
    }

    public String deleteById(Long id) {
        try {
            this.tagRepository.deleteById(id);
            return "Deletion Successfully";
        } catch (Exception e) {
            return "Failed to delete tag with id " + id;
        }
    }
}
