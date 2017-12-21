
package databasetry;
import java.io.*;
import java.sql.*;
/**
 *
 * @author DarioF
 */
public class Update {
    
    public static void main(String[] args)throws IOException{
        PreparedStatement ps;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Nombre del profesor:");
        String namer=reader.readLine();
        
        System.out.println("Te gusto el cuso del profesor "+namer+"?");
        System.out.println("(si/no)");
        String resp=reader.readLine();
        
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sistema_profesores","root","");
            

            if(resp.equalsIgnoreCase("si") || resp.equalsIgnoreCase("s") ){
                ps = con.prepareStatement("update profesor set likes=likes+1 where nombre= ?");
                ps.setString(1,namer);
            }else{
                ps = con.prepareStatement("update profesor set dislikes=dislikes+1 where nombre= ?");
                ps.setString(1,namer);
            }//if-else
            

            ps.executeUpdate();
            
            con.close();

        }catch(ClassNotFoundException e){
            System.out.println("No esta el Driver");
        }catch(SQLException e){
            System.out.println(e);
        }//try-catch

    }//main
    
}//class
