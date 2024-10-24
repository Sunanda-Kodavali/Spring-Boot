package dci.j24e01.ToyStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectionManager implements DBConnectionManager{
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/toy_store",
                    "root",
                    "sunanda123"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
