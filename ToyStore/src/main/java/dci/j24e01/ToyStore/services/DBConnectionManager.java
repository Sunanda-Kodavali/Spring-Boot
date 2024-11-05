package dci.j24e01.ToyStore;

import java.sql.Connection;

public interface DBConnectionManager {
    Connection getConnection();
}
