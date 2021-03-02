package by.tms.boot_petstore.repository;

import by.tms.boot_petstore.model.Tag;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Data
public class TagRepository {
    private List<Tag> tags = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong();

    public void save(Tag tag) {
        tag.setId(idGenerator.incrementAndGet());
        tags.add(tag);
    }

    public Tag findById(long id) {
        for (Tag tag : tags) {
            if (tag.getId() == id) {
                return tag;
            }
        }
        return null;
    }

    public void delete(long id) {
        Tag tag = findById(id);
        tags.remove(tag);
    }

    public boolean contains(long id) {
        return findById(id) != null;
    }
}
