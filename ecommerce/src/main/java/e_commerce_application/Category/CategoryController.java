package e_commerce_application.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {



        @Autowired
        private CategoryService categoryService;

        @GetMapping
        public List<Category> getAllCategories() {
            return categoryService.getAllCategories();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long categoryId) {
            Optional<Category> category = categoryService.getCategoryById(categoryId);
            return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public Category createCategory(@RequestBody Category category) {
            return categoryService.createCategory(category);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryId, @RequestBody Category categoryDetails) throws Throwable {
            return ResponseEntity.ok(categoryService.updateCategory(categoryId, categoryDetails));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCategory(@PathVariable(value = "id") Long categoryId) {
            categoryService.deleteCategory(categoryId);
            return ResponseEntity.noContent().build();
        }
}
