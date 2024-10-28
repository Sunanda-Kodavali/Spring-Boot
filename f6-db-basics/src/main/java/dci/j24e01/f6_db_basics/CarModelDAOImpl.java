package dci.j24e01.f6_db_basics;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarModelDAOImpl implements CarModelDAO {

    private final Connection connection;

    public CarModelDAOImpl(DBConnectionManager connectionManager) {
        this.connection = connectionManager.getConnection();
    }
    @Override
    public List<CarModel> getModels() {
        String sql = "SELECT * FROM models";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CarModel> carModels = new ArrayList<>();
            while (resultSet.next()) {
                CarModel carModel = new CarModel(resultSet.getLong("id"),
                        resultSet.getLong("brand_id"),
                        resultSet.getString("name"),
                        resultSet.getLong("year"),
                        resultSet.getLong("hp"));
                carModels.add(carModel);

            }
            return carModels;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CarModel> getModelsByBrandId(Long brandId) {

        String sql = "SELECT * FROM models WHERE brand_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, brandId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CarModel> carModels = new ArrayList<>();
            while (resultSet.next()) {
                CarModel carModel = new CarModel(resultSet.getLong("id"),
                        resultSet.getLong("brand_id"),
                        resultSet.getString("name"),
                        resultSet.getLong("year"),
                        resultSet.getLong("hp"));
                carModels.add(carModel);

            }
            return carModels;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
