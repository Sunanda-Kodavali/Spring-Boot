package dci.j24e01.f9_HibernateModelRelationships.controllers;

import dci.j24e01.f9_HibernateModelRelationships.db.CategoryRepository;
import dci.j24e01.f9_HibernateModelRelationships.db.ProductRepository;
import dci.j24e01.f9_HibernateModelRelationships.models.Category;
import dci.j24e01.f9_HibernateModelRelationships.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class AppController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String homepage(Model model) {

        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);

        return "index";
    }

    @GetMapping("/{categorySlug}")
    public String category(@PathVariable String categorySlug, Model model) {
        System.out.println(categorySlug);
        model.addAttribute("slug", categorySlug);

        // Show all the products that belong to this slug
        // remember we don't have the id just the slug to find the category
        // and respective products...

        Optional<Category> category = categoryRepository.findBySlug(categorySlug);

        category.ifPresent(value -> model.addAttribute("products", value.getProductList()));

        return "category";
    }

}
