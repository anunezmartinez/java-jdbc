package connection;
import java.sql.*;

public class ConnectionDB {
    
    public static void main(String[] args) {
        try {

            //Start connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "abc123.");
            //Declare statement
            Statement myStatement = conn.createStatement();
            //Ejecute SQL
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM sql_inventory.products");
            //Run every line of the table.
            while(myResult.next()){
                System.out.println(myResult.getString("product_id") + " " + (myResult.getString("name")));
            }


        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Database not connected");
            e.printStackTrace();
        }
    }










}