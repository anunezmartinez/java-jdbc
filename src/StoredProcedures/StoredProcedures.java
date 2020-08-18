package StoredProcedures;
import java.sql.*;



public class StoredProcedures {


    public static void main(String[] args) {
        try {
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sql_inventory?user=root", "root", "abc123.");

        CallableStatement storedProcedure = conn.prepareCall("{call storedProcedure}");
       // CALL `sql_inventory`.`new_procedure`();



        ResultSet rs = storedProcedure.executeQuery();

        while(rs.next()){

            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " "  + rs.getString(5) + " " + rs.getString(6));
        };
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
    }

}