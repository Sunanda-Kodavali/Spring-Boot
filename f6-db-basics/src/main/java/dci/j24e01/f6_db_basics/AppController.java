package dci.j24e01.f6_db_basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/stand_auto",
                "root",
                "sunanda123"
        );
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Brand> brands = new ArrayList<>();


        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM brands");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Brand brand = new Brand(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("logo"));
                brands.add(brand);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("brands", brands);
        return modelAndView;
    }

    @GetMapping("/models")
    public ModelAndView models(@RequestParam(required = false) Integer brandId) {
        ModelAndView modelAndView = new ModelAndView("models");
        List<CarModel> carModels = new ArrayList<>();

        String sql;
        PreparedStatement preparedStatement;

        try (Connection connection = getConnection()) {
            if (brandId != null) {
                sql = "SELECT models.id as id, brand_id, models.name as model_name, year, hp, brands.name as brand_name " +
                        "FROM brands JOIN models ON brands.id = models.brand_id WHERE models.brand_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, brandId);
            } else {
                sql = "SELECT id, brand_id, name as model_name, year, hp FROM models";
                preparedStatement = connection.prepareStatement(sql);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    CarModel carModel = new CarModel(resultSet.getLong("id"),
                            resultSet.getLong("brand_id"),
                            resultSet.getString("model_name"),
                            resultSet.getLong("year"),
                            resultSet.getLong("hp"));
                    carModels.add(carModel);

                    if (brandId != null) {
                        modelAndView.addObject("brandName", resultSet.getString("brand_name"));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("carModels", carModels);
        return modelAndView;
    }
}
