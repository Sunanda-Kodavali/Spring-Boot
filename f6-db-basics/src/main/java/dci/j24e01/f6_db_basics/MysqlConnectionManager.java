package dci.j24e01.f6_db_basics;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class MysqlConnectionManager implements DBConnectionManager{

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/stand_auto",
                    "root",
                    "sunanda123"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
