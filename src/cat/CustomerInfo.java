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
public class CustomerInfo {
    public static int AddDetails(String Name, String Phone, String Email, String Passwords, String Address){
        int status=0;
       
		try{
                        String url="jdbc:mysql://localhost:3306/bookstore";
                        String uname="root";
                        String upass="2106";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        String sql ="insert into signupdata4(Name,Phone,Email,Passwords,Address) values(?,?,?,?,?)";
                        PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,Name);
                        ps.setString(2,Phone);
                        ps.setString(3,Email);
                        ps.setString(4,Passwords);
                        ps.setString(5,Address);
                        
                        
                        
			status=ps.executeUpdate();
			con.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    return status; 
        }
 
    }
       
