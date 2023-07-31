/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Akschaya balaji
 */
public class OrderInfo {
    public static int AddDetails(int id, String itemno,String quantity,String price,String amount,String discount,String netTotal){
        int status=0;
       
		try{
                        String url="jdbc:mysql://localhost:3306/bookstore";
                        String uname="root";
                        String upass="2106";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection(url,uname,upass); 
                        PreparedStatement ps=con.prepareStatement("insert into orderitem(CustomerId,ItemNo,Quantity,Price,Amount,Discount,NetTotal) values(?,?,?,?,?,?,?)");
                        
			ps.setInt(1,id);
                        ps.setString(2,itemno);
                        ps.setString(3,quantity);
                        ps.setString(4,price);
                        ps.setString(5,amount);
                        ps.setString(7,discount);
                        ps.setString(6,netTotal);
                        
                        
                        
			status=ps.executeUpdate();
			con.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    return status; 
    }
    
}
