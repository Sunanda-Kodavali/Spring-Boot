package dci.j24e01.f9_HibernateModelRelationships.db;

import dci.j24e01.f9_HibernateModelRelationships.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findBySlug(String slug);
}