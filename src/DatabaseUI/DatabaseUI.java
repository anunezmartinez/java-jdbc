package DatabaseUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class DatabaseUI {

	public static void main(String[] args) {
		
		JFrame myFrame = new myFrameUI();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myFrame.setVisible(true);

	}

}

class myFrameUI extends JFrame{
	
	public myFrameUI(){
		
		setTitle ("BBDD query");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel options=new JPanel();
		
		options.setLayout(new FlowLayout());
		
		menuSections=new JComboBox();
		
		menuSections.setEditable(false);
		
		menuSections.addItem("All");
		
		country=new JComboBox();
		
		country.setEditable(false);
		
		country.addItem("All");
		
		result= new JTextArea(4,50);
		
		result.setEditable(false);
		
		add(result);
		
		options.add(menuSections);
		
		options.add(country);	
		
		add(options, BorderLayout.NORTH);
		
		add(result, BorderLayout.CENTER);
		
		JButton queryBttn=new JButton("Search");	
		
		add(queryBttn, BorderLayout.SOUTH);
        
        queryBttn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();

            }
                
        });

        //Database Connection
        try {

            //Start connection
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "abc123.");
            //Declare statement
            Statement myStatement = conn.createStatement();
            //First query search.

            String query0 = "SELECT type FROM sql_inventory.products GROUP BY type";
            ResultSet myResult = myStatement.executeQuery(query0);
            
            while(myResult.next()){
                menuSections.addItem(myResult.getString(1));
            }
            

            String query1 = "SELECT country FROM sql_inventory.products GROUP BY country";
            myResult = myStatement.executeQuery(query1);

            while(myResult.next()){
                country.addItem(myResult.getString(1));
            }


            myResult.close();


        } catch (Exception e) {
            System.out.println("Database not connected");
            e.printStackTrace();
        }
		
	}	
    
    private void onClick(){
        ResultSet rs = null;

        result.setText("");
        try {
            String section = (String)menuSections.getSelectedItem();
            String menuCountry = (String) country.getSelectedItem();

            if(section == "All"){
                sendCountryQuery = conn.prepareStatement(countryQuery);

                sendCountryQuery.setString(1, menuCountry);

                rs = sendCountryQuery.executeQuery();

            } else if(menuCountry == "All"){
                sendSectionQuery = conn.prepareStatement(sectionQuery);

                sendSectionQuery.setString(1, section);

                rs = sendSectionQuery.executeQuery();

            } else if (section != "All" && menuCountry != "All"){

                sendFinalQuery = conn.prepareStatement(finalQuery);

                sendFinalQuery.setString(1 , section);
                sendFinalQuery.setString(2, menuCountry);
                rs = sendFinalQuery.executeQuery();


            }
            
            while(rs.next()){
                result.append(rs.getString(1));
                result.append(" - ");
                result.append(rs.getString(2));
                result.append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private Connection conn;
    private PreparedStatement sendCountryQuery;
    private PreparedStatement sendSectionQuery;
    private PreparedStatement sendFinalQuery;
    private final String sectionQuery = "SELECT product_id, name FROM sql_inventory.products WHERE type = ?";
    private final String countryQuery = "SELECT product_id, name FROM sql_inventory.products WHERE country = ?";
    private final String finalQuery = "SELECT product_id, name FROM sql_inventory.products WHERE type = ? AND country = ?";
	private JComboBox menuSections;
	
	private JComboBox country;
	
	private JTextArea result;	
	

	
}


