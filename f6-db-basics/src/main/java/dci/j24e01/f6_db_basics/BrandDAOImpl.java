package dci.j24e01.f6_db_basics;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BrandDAOImpl implements BrandDAO {


    private final Connection connection;

    public BrandDAOImpl(DBConnectionManager connectionManager) {
        this.connection = connectionManager.getConnection();
    }

    @Override
    public List<Brand> getBrands() {

        String sql = "SELECT * FROM brands";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Brand> brands = new ArrayList<>();
            while (resultSet.next()) {
                Brand brand = new Brand(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("logo"));
                brands.add(brand);
            }
            return brands;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
