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
        Scanner input= new Scanner(System.in);package EndtermProject;


import java.util.*;//importing this package to read input
public class StartingMethod {
    UI ui = new UI();//creating and object of UI class
    public void start(){//creating start method
        Scanner input= new Scanner(System.in);//creating scanner object
        Options op = new Options();//creating object of Options class
        try{
            System.out.println("Hello, welcome to my program!");
            while (true){//infinite loop, as true is always true
                ui.Hello_Message();//printing hello message
                int option = input.nextInt();//reading the input
                if(option == 1){//if the input is 1
                    op.option1();//call the method option1 from Options class
                }
                if(option==2){//if the input is 2
                    op.option2();//call the method option2 from Options class
                }
                if(option == 3){//if the input is 3
                    op.option3();//call the method option3 from Options class
                }
                if(option==4){//if the input is 4 from Options class
                    break;//break the loop (exit the program)
                }
            }
        }
    catch (InputMismatchException a) {//if the user input something other that an integer(let's say "a", the scanner won't be able to read it and the program will throw this exception)
        System.out.println("Input must be an integer from 1 to 4");
        input.nextLine(); // to ignore incorrect input
    }
        catch (Exception e) {
        System.out.println(e.getMessage());
    }

        System.out.println("*************************");
    }
}

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
