package EndtermProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;//importing packages that we will need


public class UI {//creating a class UI
    private PostgresDB db = new PostgresDB();
    public void getTicketsList(){//creating a getTicketsList method to, who could have guessed? Get the list of tickets!
        try {
            Connection connection;
            ResultSet resultSet;
            connection=db.getConnection();
            String sql = "select * from bus_ticket";
            Statement st = connection.createStatement();

            resultSet= st.executeQuery(sql);//executing query to display the list of tickets
            while (resultSet.next()) {//ouputting them on the console
                System.out.println(resultSet.getInt("ticket_id") + " " + resultSet.getString("starting_point") + " " + resultSet.getString("destination") + " " + resultSet.getInt("price"));
            }
        }
        catch (Exception e){
            System.out.println(e);//exception handling when working with connection as something can and will go wrong
        }
    }
    public void Hello_Message(){//creating the method to display the list of possible options for user to chose from
        System.out.println();
        System.out.println("Please, choose and option:");
        System.out.println("1 - Buy a ticket");
        System.out.println("2 - See my tickets");
        System.out.println("3 - See the total price");
        System.out.println("4 - Exit");
    }
}
