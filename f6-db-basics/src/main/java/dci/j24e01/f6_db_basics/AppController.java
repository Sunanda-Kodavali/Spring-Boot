package dci.j24e01.f6_db_basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class AppController {

    private final DBConnectionManager dbConnectionManager = new MysqlConnectionManager();
    private final BrandDAO brandDAO = new BrandDAOImpl(dbConnectionManager);
    private final CarModelDAO carModelDAO = new CarModelDAOImpl(dbConnectionManager);


    @GetMapping("/")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("index");
        List<Brand> brands = brandDAO.getBrands();
        modelAndView.addObject("brands", brands);
        return modelAndView;
    }

    @GetMapping("/models")
    public ModelAndView models(@RequestParam(required = false) Long brandId) {
        ModelAndView modelAndView = new ModelAndView("models");
        List<CarModel> carModels;
        if (brandId != null) {
            carModels = carModelDAO.getModelsByBrandId(brandId);
        }else {
            carModels = carModelDAO.getModels();
        }
        modelAndView.addObject("carModels", carModels);
        return modelAndView;
    }
}
