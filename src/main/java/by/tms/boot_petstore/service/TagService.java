package by.tms.boot_petstore.service;

import by.tms.boot_petstore.model.Category;
import by.tms.boot_petstore.model.Tag;
import by.tms.boot_petstore.repository.CategoryRepository;
import by.tms.boot_petstore.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public void createTag(Tag tag) {
        tagRepository.save(tag);
    }

    public Tag findById(long id) {
        if (tagRepository.contains(id)) {
            return tagRepository.findById(id);
        } else {
            throw new TagNotFoundException(id);
        }
    }

    public void deleteTag(long id) {
        if (tagRepository.contains(id)) {
            tagRepository.delete(id);
        } else {
            throw new TagNotFoundException(id);
        }
    }
}
