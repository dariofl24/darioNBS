
package databasetry;
import java.sql.*;
/**
 *
 * @author DarioF
 */
public class DatabaseTry {

    
    public static void main(String[] args) {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sistema_profesores","root","");
            
            
            PreparedStatement ps = con.prepareStatement("select * from profesor");
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                int id= rs.getInt(1);
                String nombre= rs.getString(2);
                String appat= rs.getString(3);
                String apmat= rs.getString(4);
                int likes= rs.getInt(5);
                int dislikes= rs.getInt(6);
                
                System.out.printf("%d) %s %s %s, lkes:%d dislikes:%d \n",id,nombre,appat,apmat,likes,dislikes);
                
            }//while

            con.close();

        }catch(ClassNotFoundException e){
            System.out.println("No esta el Driver");
        }catch(SQLException e){
            System.out.println(e);
        }//try-catch
        
    }//main
    
}//class
