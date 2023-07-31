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
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Akschaya balaji
 */
public class Cancels {
   

public static int CancelRecord(String cusid){

        
                int status=0;
                int cc = Integer.parseInt(cusid);
		try{
                        String url="jdbc:mysql://localhost:3306/bookstore";
                        String uname="root";
                        String upass="2106";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        PreparedStatement ps=con.prepareStatement("DELETE FROM orderitem WHERE customerid=?");
			ps.setInt(1,cc);
			
                       status= ps.executeUpdate();
			con.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    return status;
                    }
    }
