
package databasetry;
import java.io.*;
import java.sql.*;
/**
 *
 * @author DarioF
 */
public class Baja {
    
    public static void main(String[] args)throws IOException{

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Nombre del profesor:");
        String namer=reader.readLine();

        

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sistema_profesores","root","");

            PreparedStatement ps = con.prepareStatement("delete from profesor where nombre= ?");
            ps.setString(1,namer);
            

            ps.executeUpdate();
            
            con.close();

        }catch(ClassNotFoundException e){
            System.out.println("No esta el Driver");
        }catch(SQLException e){
            System.out.println(e);
        }//try-catch

    }//main
    
}//class
