package dci.j24e01.ToyStore;

import java.util.List;

public interface ProductDAO {

    Product getProduct(int id);
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);

}
