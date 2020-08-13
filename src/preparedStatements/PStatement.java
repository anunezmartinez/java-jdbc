package preparedStatements;
import java.sql.*;

public class PStatement {
    
    public static void main(String[] args) {
        try {

            //Start connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "abc123.");
            //Declare prepared statement
            PreparedStatement mySentence = conn.prepareStatement("SELECT * FROM sql_inventory.products WHERE name = ?");
            //Add statement parameters.
            mySentence.setString(1, "Bleach");

            ResultSet rs = mySentence.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString(1) + " " +rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

            rs.close();

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Database not connected");
            e.printStackTrace();
        }
    }

}