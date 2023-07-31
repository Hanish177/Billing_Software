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
public class Add2 {
    public static int ReturnPrice(int Id) throws ClassNotFoundException, SQLException{
        String url="jdbc:mysql://localhost:3306/bookstore";
        String uname="root";
        String upass="2106";
        String query = "select price from items3 where isbn= ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(url,uname,upass);
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String pp = rs.getString("price");
        int price = Integer.parseInt(pp);
        st.close();
        con.close();
        return price;
        
    }
    
}
