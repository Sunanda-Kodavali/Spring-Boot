package dci.j24e01.f8_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/")
    public List<Category> index() {
        return categoryRepository.findAll();
    }

    @GetMapping("/addCategory")
    public Category addCategory() {
        Category category = new Category("Cool", "cool");
        categoryRepository.save(category);

        return category;

    }

    @GetMapping("/categories")
    public ResponseEntity<Category> findCategory(@RequestParam Long id) {
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
