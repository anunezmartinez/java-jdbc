package update;
import java.sql.*;

public class UpdateDB {
    public static void main(String[] args) {
        try {

            //Start connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "abc123.");
            //Declare statement
            Statement myStatement = conn.createStatement();
            //Insert
            String sqlInstruction = "UPDATE sql_inventory.products SET NAME ='Updated Bleach' WHERE product_id='11'";

            myStatement.executeUpdate(sqlInstruction);

            System.out.println("Item added, updated or deleted successfully");

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Database not connected");
            e.printStackTrace();
        }
    }
}