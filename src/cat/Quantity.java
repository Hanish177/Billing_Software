/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Akschaya balaji
 */
public class Quantity {
    public static void ChangeQ(int quantity,int quantity1,String itemno){
        try{
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","2106");
                int qt = quantity1 - quantity;
                String sql = "update items4 set quantity = '"+qt+"' where isbn ='"+itemno+"' ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.executeUpdate();
               
                
  
                
                con.close();
                
                
 }
        catch(Exception e){
            
        }

    }
    
}
