package delete;
import java.sql.*;

public class DeleteDB {
    
    public static void main(String[] args) {
        try {

            //Start connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "abc123.");
            //Declare statement
            Statement myStatement = conn.createStatement();
            //Ejecute SQL
            
            String sqlInstruction = "DELETE FROM sql_inventory.products WHERE product_id = '11'";
            myStatement.executeUpdate(sqlInstruction);

            System.out.println("Item added, updated or deleted successfully");

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Database not connected");
            e.printStackTrace();
        }
    }










}