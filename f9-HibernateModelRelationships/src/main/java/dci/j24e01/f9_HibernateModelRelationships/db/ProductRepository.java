package dci.j24e01.f9_HibernateModelRelationships.db;

import dci.j24e01.f9_HibernateModelRelationships.models.Category;
import dci.j24e01.f9_HibernateModelRelationships.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByCategory(Category category);
}
