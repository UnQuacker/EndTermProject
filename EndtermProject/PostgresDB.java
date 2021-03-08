package EndtermProject;

import java.sql.*;//importing the package to actually be able to connect to Database

public class PostgresDB implements IDB {//creating class PostgresDB implementing interface IDB
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {//overriding getConnection method
        String connectionUrl = "jdbc:postgresql://localhost:5432/EndTermProject";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "5550125Qz");//connecting to the Database

            return con;//returning connection
        } catch (Exception e) {
            System.out.println(e);//exception handling when working with connection as something can go wrong
            return null;
        }
    }
}
