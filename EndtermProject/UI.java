package EndtermProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class UI {
    String connectionUrl="jdbc:postgresql://localhost:5432/EndTermProject";
    Statement statement=null;
    private PostgresDB db = new PostgresDB();
    public void getTicketsList(){
        try {
            Connection connection=null;
            ResultSet resultSet=null;
            connection=db.getConnection();
            String sql = "select * from bus_ticket";
            Statement st = connection.createStatement();

            resultSet= st.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ticket_id") + " " + resultSet.getString("starting_point") + " " + resultSet.getString("destination") + " " + resultSet.getInt("price"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void Hello_Message(){
        System.out.println();
        System.out.println("Please, choose and option:");
        System.out.println("1 - Buy a ticket");
        System.out.println("2 - See my tickets");
        System.out.println("3 - See the total price");
        System.out.println("4 - Exit");
    }
}
/* Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionUrl, "postgres", "5550125Qz");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from bus_ticket");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ticket_id") + " " + resultSet.getString("starting_point") + " " + resultSet.getString("destination") + " " + resultSet.getInt("price"));
            }
 */
