package by.tms.petstorejpa.service;

import by.tms.petstorejpa.entity.Tag;
import by.tms.petstorejpa.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag findById(long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (!tag.isPresent()) {
            throw new ResourceNotFoundException("Tag not found with id: " + id);
        } else {
            return tag.get();
        }
    }

    public void deleteTag(long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (!tag.isPresent()) {
            throw new ResourceNotFoundException("Tag not found with id: " + id);
        } else {
            tagRepository.deleteById(id);
        }
    }
}
