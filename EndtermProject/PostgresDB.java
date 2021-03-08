package EndtermProject;

import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/EndTermProject";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "5550125Qz");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}