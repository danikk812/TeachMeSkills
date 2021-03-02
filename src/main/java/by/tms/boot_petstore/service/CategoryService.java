package by.tms.boot_petstore.service;

import by.tms.boot_petstore.model.Category;
import by.tms.boot_petstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(long id) {
        if (categoryRepository.contains(id)) {
            return categoryRepository.findById(id);
        } else {
            throw new CategoryNotFoundException(id);
        }
    }

    public void deleteCategory(long id) {
        if (categoryRepository.contains(id)) {
            categoryRepository.delete(id);
        } else {
            throw new CategoryNotFoundException(id);
        }
    }
}
