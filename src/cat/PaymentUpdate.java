/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Akschaya balaji
 */
public class PaymentUpdate {
    public static void UpdatePay(int CusId){
        try{
               
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","2106");
                
                String sql = "update orderitem set Status = 'Paid' where CustomerId = ? ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, CusId);
                pst.executeUpdate();
               
                
  
                
                con.close();
                
                
 }
        catch(Exception e){
        
}
    }
}

