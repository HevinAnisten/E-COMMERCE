package e_commerce_application.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public Category createCategory(Category category) {
        return (Category) categoryRepository.save(category);
    }

    public Category updateCategory(Long categoryId, Category categoryDetails) throws Throwable {
        Category category = (Category) categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Category not found for this id :: " + categoryId));
        category.setCategory_type(categoryDetails.getCategory_type());
        return (Category) categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
