package StoredProcedures2;
import java.sql.*;

import javax.swing.JOptionPane;
public class StoredProcedures2 {
    
    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("What's the name of the product to update?");
        int price = Integer.parseInt(JOptionPane.showInputDialog("What's the new quantity?"));

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sql_inventory?user=root", "root", "abc123.");

            CallableStatement cs = conn.prepareCall("{call storedProcedure2(?, ?)}");
            cs.setString(1, name);
            cs.setInt(2, price);

            cs.execute();

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        

    }
}