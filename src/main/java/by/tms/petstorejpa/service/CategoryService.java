package by.tms.petstorejpa.service;

import by.tms.petstorejpa.entity.Category;
import by.tms.petstorejpa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()) {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        } else {
            return category.get();
        }
    }

    public void deleteCategory(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()) {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        } else {
            categoryRepository.deleteById(id);
        }
    }
}
