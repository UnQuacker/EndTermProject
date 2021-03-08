package EndtermProject;


import java.sql.*;
import java.util.LinkedList;
import java.util.*;
public class StartingMethod {
    Scanner input= new Scanner(System.in);
    UI ui = new UI();
    Statement st = null;
    public void start(){
        String connectionUrl="jdbc:postgresql://localhost:5432/Java";
        Connection connection=null;
        ResultSet resultSet=null;
        PostgresDB db = new PostgresDB();
        Scanner input= new Scanner(System.in);
        try{
            System.out.println("Hello, welcome to my program!");
            while (true){
                ui.Hello_Message();
                int option = input.nextInt();
                if(option == 1){
                    System.out.println("");
                    String empty = input.nextLine();
                    System.out.println("Please, enter your name:");
                    String name = input.nextLine();
                    System.out.println("Please, enter your surname:");
                    String surname = input.nextLine();
                    System.out.println("Please, enter your credit card information:");
                    String cardInfo=input.nextLine();
                    System.out.println("Please, choose your ticket by number:");
                    ui.getTicketsList();
                    int ticket_id = input.nextInt();
                    connection = db.getConnection();
                    String sql = "INSERT INTO user_info(name,surname,credit_card_info) VALUES (?,?,?)";
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setString(1, name);
                    st.setString(2, surname);
                    st.setString(3, cardInfo);
                    st.execute();
                    sql = "INSERT INTO ticket_info(ticket_id) VALUES(?)";
                    st=connection.prepareStatement(sql);
                    st.setInt(1, ticket_id);
                    st.execute();
                }
                if(option==2){
                    System.out.println("");
                    String empty = input.nextLine();
                    System.out.println("Please, enter your name:");
                    String name = input.nextLine();
                    System.out.println("Please, enter your surname:");
                    String surname = input.nextLine();
                    connection = db.getConnection();
                    String sql = "select name, surname, starting_point, destination, price\n" +
                            "from ticket_info\n" +
                            "inner join user_info on ticket_info.user_id = user_info.user_id\n" +
                            "inner join bus_ticket on ticket_info.ticket_id = bus_ticket.ticket_id\n" +
                            "where name = '"+name+"' and surname = '"+surname+"'";
                    st = connection.createStatement();
                    resultSet=st.executeQuery(sql);
                    while(resultSet.next()){
                        System.out.println("Name: "+resultSet.getString("name")+"   Surname:: "+resultSet.getString("surname")+"   Starting Point: "+resultSet.getString("starting_point")+"   Destination: "+resultSet.getString("destination")+"   Price: "+resultSet.getInt("price"));
                    }
                }
                if(option == 3){
                    System.out.println("");
                    String empty = input.nextLine();
                    System.out.println("Please, enter your name:");
                    String name = input.nextLine();
                    System.out.println("Please, enter your surname:");
                    String surname = input.nextLine();
                    connection = db.getConnection();
                    String sql = "select sum(distinct price) as sum\n" +
                            "from ticket_info\n" +
                            "inner join user_info on ticket_info.user_id = user_info.user_id\n" +
                            "inner join bus_ticket on ticket_info.ticket_id = bus_ticket.ticket_id\n" +
                            "where name = '"+name+"' and surname = '"+surname+"'";
                    st = connection.createStatement();
                    resultSet=st.executeQuery(sql);
                    while(resultSet.next()){
                        System.out.println("Total sum: "+resultSet.getInt("sum"));
                    }
                }
                if(option==4){
                    break;
                }
            }
        }
    catch (InputMismatchException a) {
        System.out.println("Input must be an integer from 1 to 4");
        input.nextLine(); // to ignore incorrect input
    }
        catch (Exception e) {
        System.out.println(e.getMessage());
    }

        System.out.println("*************************");
    }
}
