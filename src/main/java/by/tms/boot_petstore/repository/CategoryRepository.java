package by.tms.boot_petstore.repository;

import by.tms.boot_petstore.model.Category;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Data
public class CategoryRepository {
    private List<Category> categories = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong();

    public void save(Category category) {
        category.setId(idGenerator.incrementAndGet());
        categories.add(category);
    }

    public Category findById(long id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public void delete(long id) {
        Category category = findById(id);
        categories.remove(category);
    }

    public boolean contains(long id) {
        return findById(id) != null;
    }
}
