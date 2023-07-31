/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat;
import java.sql.*;
/**
 *
 * @author Akschaya balaji
 */
public class DCInfo{
    public static int AddDetails(String accno, String cvv){
        int status=0;
       
		try{
                        String url="jdbc:mysql://localhost:3306/bookstore";
                        String uname="root";
                        String upass="2106";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        PreparedStatement ps=con.prepareStatement("insert into dc1 values(?,?)");
			ps.setString(1,accno);
                        ps.setString(2,cvv);
                        
                        
                        
                        
			status=ps.executeUpdate();
			con.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    return status; 
    }}
        
    
