package dci.j24e01.f9_HibernateModelRelationships.api_controllers;

import dci.j24e01.f9_HibernateModelRelationships.db.ProductRepository;
import dci.j24e01.f9_HibernateModelRelationships.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}