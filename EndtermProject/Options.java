package EndtermProject;

import java.sql.*;
import java.util.*;

public class Options {//creating class Options
    public void option1(){//creating method for booking a ticket
        Connection connection;//these 2 will be needed for connection and executing queries
        PostgresDB db = new PostgresDB();
        Scanner input= new Scanner(System.in);//creating scanner object
        UI ui = new UI();//creating UI object
        System.out.println("");//asking for name, surname, credit card info and a ticket to buy
        System.out.println("Please, enter your name:");
        String name = input.nextLine();
        System.out.println("Please, enter your surname:");
        String surname = input.nextLine();
        System.out.println("Please, enter your credit card information:");
        String cardInfo=input.nextLine();
        System.out.println("Please, choose your ticket by number:");
        ui.getTicketsList();//showing the list of tickets, via getTicketList in UI class
        int ticket_id = input.nextInt();
        try {
            connection = db.getConnection();//connecting to database
            String sql = "INSERT INTO user_info(name,surname,credit_card_info) VALUES (?,?,?)";//creating prepared statement
            PreparedStatement st = connection.prepareStatement(sql);//

            st.setString(1, name);//inserting the values that the user provided
            st.setString(2, surname);
            st.setString(3, cardInfo);
            st.execute();//entering said values to the user_info table
            sql = "INSERT INTO ticket_info(ticket_id) VALUES(?)";//same process but with the ticket_info table
            st=connection.prepareStatement(sql);
            st.setInt(1, ticket_id);
            st.execute();
        } catch (SQLException throwables) {//handling exceptions when working with connections
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void option2(){//creating a method for outputting user's tickets
        try {
            Connection connection;//explained above
            ResultSet resultSet;
            PostgresDB db = new PostgresDB();
            Scanner input= new Scanner(System.in);
            Statement st;
            System.out.println("");
            System.out.println("Please, enter your name:");
            String name = input.nextLine();
            System.out.println("Please, enter your surname:");
            String surname = input.nextLine();
            connection = db.getConnection();//getting connection
            String sql = "select name, surname, starting_point, destination, price\n" +
                    "from ticket_info\n" +
                    "inner join user_info on ticket_info.user_id = user_info.user_id\n" +
                    "inner join bus_ticket on ticket_info.ticket_id = bus_ticket.ticket_id\n" +
                    "where name = '" + name + "' and surname = '" + surname + "'";//I did not like the prepared statement method, so I used this
            st = connection.createStatement();
            resultSet = st.executeQuery(sql);//executing the query
            while (resultSet.next()) {//outputting the results
                System.out.println("Name: " + resultSet.getString("name") + "   Surname:: " + resultSet.getString("surname") + "   Starting Point: " + resultSet.getString("starting_point") + "   Destination: " + resultSet.getString("destination") + "   Price: " + resultSet.getInt("price"));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void option3(){//creating option 3 for outputting the sum of all tickets bought by the user
        try {
            Connection connection;//the code here is basically the same as in option2
            ResultSet resultSet;
            PostgresDB db = new PostgresDB();
            Scanner input= new Scanner(System.in);
            Statement st;
            System.out.println("");
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
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }

