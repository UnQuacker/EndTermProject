package EndtermProject;

import java.sql.Connection;
import java.sql.SQLException;//importing packages that we will need

public interface IDB {//creating an interface IDB
    Connection getConnection() throws SQLException, ClassNotFoundException;//initializing method getConnection, I wonder what it does...
}
