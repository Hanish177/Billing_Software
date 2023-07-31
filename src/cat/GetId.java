/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat;
import java.sql.*;
import static cat.User.us;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Akschaya balaji
 */
public class GetId
{
    static int id;
    static String Email;
    public static int ReturnId(String email){
        int CusId = 0;
        int status=0;
		try{
                        String url="jdbc:mysql://localhost:3306/bookstore";
                        String uname="root";
                        String upass="2106";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        PreparedStatement ps=con.prepareStatement("select CustomerId from signupdata4 where Email = ?");
                        ps.setString(1,email);
                        
                         ResultSet rs=ps.executeQuery();
                    
                        while(rs.next()){
                            CusId=rs.getInt(1);
                            
                        }
                    con.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                
        return CusId;
    }
    public static int GetCustomerId(){
        
        int a = GetId.ReturnId(Email);
        id = a;
        System.out.println(a);
               
        return id;
    }
    public static void EmailSet(String email){
        
        Email= email;
        System.out.println(Email+"Email");
    }
}
    

