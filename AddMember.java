    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Darshana_Lap
 */
public class DatabaseConnection {
    private static Connection connection =null;
    public DatabaseConnection(){
        DatabaseConnect();
    }
    private void DatabaseConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/library?useSSL=false","root","DCR0740595093@sql");
                    
        }catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Database Driver Not Found: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Connection Failed: " + e.getMessage());
        }
    }
    
    public static Connection getConnection(){
        if(connection== null){
            new DatabaseConnection();
        }
    
        return connection;
    }
            
}
