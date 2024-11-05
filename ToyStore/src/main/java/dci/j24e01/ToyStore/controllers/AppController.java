package dci.j24e01.ToyStore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    private final DBConnectionManager dbConnectionManager = new MysqlConnectionManager();
    private final ProductDAO productDAO = new ProductDAOImpl(dbConnectionManager);

    @GetMapping("/")
    public ModelAndView getAllProducts() {

        ModelAndView modelAndView = new ModelAndView("products");
        List<Product> products = productDAO.getAllProducts();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/addProduct")
    public ModelAndView addProduct() {

        return new ModelAndView("addProduct");

    }

    @PostMapping("/addingProduct")
    public ModelAndView addingProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("addProduct");
        try {
            productDAO.addProduct(product);
            modelAndView.addObject("message", "Product added successfully!");
        } catch (Exception e) {
            modelAndView.addObject("message", "Error adding product: " + e.getMessage());
        }
        return modelAndView;

    }

    @GetMapping("/editProduct")
    public ModelAndView editProduct(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        Product product = productDAO.getProduct(id);
        System.out.println(product.name());
        modelAndView.addObject("product", product);
        return modelAndView;

    }

    @PostMapping("/editingProduct")
    public ModelAndView editingProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        try {
            productDAO.updateProduct(product);
            modelAndView.addObject("message", "Product updated successfully!");
        } catch (Exception e) {
            modelAndView.addObject("message", "Error updating product: " + e.getMessage());
        }
        return modelAndView;

    }

    @GetMapping("/deleteProduct")
    public ModelAndView deleteProduct(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("products");
        try {
            productDAO.deleteProduct(id);
            List<Product> products = productDAO.getAllProducts();
            modelAndView.addObject("products", products);
            modelAndView.addObject("message", "Product deleted successfully!");
        } catch (Exception e) {
            modelAndView.addObject("message", "Error deleting product: " + e.getMessage());
        }
        return modelAndView;

    }

    @GetMapping("aboutUs")
    public ModelAndView aboutUs() {
        return new ModelAndView("aboutUs");
    }

    @GetMapping("home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }
    @GetMapping("blog")
    public ModelAndView blog() {
        return new ModelAndView("blog");
    }
    @GetMapping("contact")
    public ModelAndView contact() {
        return new ModelAndView("contact");
    }

}
