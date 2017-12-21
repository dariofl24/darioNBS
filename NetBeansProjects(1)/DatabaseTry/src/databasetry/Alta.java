
package databasetry;
import java.io.*;
import java.sql.*;
/**
 *
 * @author DarioF
 */
public class Alta {
    
    public static void main(String[] args)throws IOException{

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Nombre del profesor:");
        String namer=reader.readLine();

        System.out.println("Apellido Paterno:");
        String appatr=reader.readLine();

        System.out.println("Apellido Materno:");
        String apmatr=reader.readLine();

        System.out.println("likes:");
        int likesr= Integer.parseInt( reader.readLine() );

        System.out.println("dislikes:");
        int dislikesr= Integer.parseInt( reader.readLine() );

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sistema_profesores","root","");

            PreparedStatement ps = con.prepareStatement("INSERT INTO profesor(nombre,appat,apmat,likes,dislikes) values(?,?,?,?,?)");
            ps.setString(1,namer);
            ps.setString(2,appatr);
            ps.setString(3,apmatr);
            ps.setInt(4,likesr);
            ps.setInt(5,dislikesr);

            ps.executeUpdate();
            
            con.close();

        }catch(ClassNotFoundException e){
            System.out.println("No esta el Driver");
        }catch(SQLException e){
            System.out.println(e);
        }//try-catch

    }//main
    
}//class
