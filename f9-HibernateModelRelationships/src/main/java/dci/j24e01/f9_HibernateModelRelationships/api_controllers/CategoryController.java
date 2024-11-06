package dci.j24e01.f9_HibernateModelRelationships.api_controllers;

import dci.j24e01.f9_HibernateModelRelationships.db.CategoryRepository;
import dci.j24e01.f9_HibernateModelRelationships.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    private List<Category> getCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        System.out.println(categoryList);
        return categoryList;
    }
}
