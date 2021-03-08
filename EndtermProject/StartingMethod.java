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
        Options op = new Options();
        try{
            System.out.println("Hello, welcome to my program!");
            while (true){
                ui.Hello_Message();
                int option = input.nextInt();
                if(option == 1){
                    op.option1();
                }
                if(option==2){
                    op.option2();
                }
                if(option == 3){
                    op.option3();
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
