package modificate;
import java.sql.*;

public class ModificateDB {
    public static void main(String[] args) {
        try {

            //Start connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "abc123.");
            //Declare statement
            Statement myStatement = conn.createStatement();
            //Insert
            String sqlInstruction = "INSERT INTO sql_inventory.products (product_id, name, quantity_in_stock, unit_price) VALUE ('11', 'Bleach','124','1.5')";

            myStatement.executeUpdate(sqlInstruction);

            System.out.println("Item added, updated or deleted successfully");

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Database not connected");
            e.printStackTrace();
        }
    }
}