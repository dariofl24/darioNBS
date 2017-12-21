
package db_try;
import java.sql.*;


public class DB_try {
    
    static int where;

    
    public static void main(String[] args) {
        
        
        
        try{
            
            int n,len=1,index;
            
            Class.forName("com.mysql.jdbc.Driver");
            
            String connectionUrl="jdbc:mysql://localhost/ticket?"+"user=root&password=32253225";
            
            Connection con= DriverManager.getConnection(connectionUrl);
            
            System.out.println(" *** ");
            
            Statement stmt;
            ResultSet rs;
            
            
            String SQL="SELECT * FROM cliente,comprobante,contribuyente WHERE comprobante.CLIENTE_ID_FK=cliente.CTE_ID_PK AND comprobante.CONTRIBUYENTE_ID_FK=contribuyente.CONTR_ID_PK AND comprobante.FECHA_CREACION BETWEEN '2013-01-01' AND '2013-02-28' ORDER BY comprobante.FECHA_CREACION ASC";
            
            stmt= con.createStatement();
            
            rs=stmt.executeQuery(SQL);
            
            
            while(rs.next()){
                
                if(len==1){
                    System.out.println("Lenght least one...\n");
                }//if
                    
                len=len+1;
            }//while
            
            
            Cliente[] carray=new Cliente[len];
            index=0;
            
            
            if(rs.first()){
                
                //System.out.println( ") "+ rs.getString("CLIENTE_ID_FK") +" : " + rs.getString("FECHA_CREACION") +" : " + rs.getString("CONTRIBUYENTE_ID_FK") +" : " + rs.getString("CONTR_ID_PK"));
                
                if( !Existe(rs.getString("CTE_ID_PK"),carray) ){
                    carray[index]=new Cliente(rs);
                    index=index+1;
                }else{
                    carray[where].AddCoco(rs);    
                }//if-else
                
                
                while(rs.next()){
                
                //System.out.println( ") "+ rs.getString("CLIENTE_ID_FK") +" : " + rs.getString("FECHA_CREACION") +" : " + rs.getString("CONTRIBUYENTE_ID_FK") +" : " + rs.getString("CONTR_ID_PK"));
                
                if( !Existe(rs.getString("CTE_ID_PK"),carray) ){
                    
                    carray[index]=new Cliente(rs);
                    index=index+1;
                    
                }else{
                    carray[where].AddCoco(rs);    
                }//if-else
                
                }//while
                
                
            }//if
            
            for(int i=0;i<= index;++i){
                carray[i].Print(false);
            }//for
            
            System.out.println("Clientes que facturaron en Enero y NO en Febrero: \n");
            
            for(int i=0;i<= index;++i){
                carray[i].Print(true);
            }//for
            
            
        }catch(SQLException e){
            
            System.out.println("ERROR 1");
            
        }catch(ClassNotFoundException CE){
            System.out.println("ERROR 2");
        }//try-catch
        
    }//main
    
    public static boolean Existe(String IDD, Cliente[] carr){
        
        for(int i=0;i< carr.length;i++){
            
            if( carr[i]== null ){
                return false;
            }//if
                
                if(carr[i].IsId(IDD)){
                    where=i;
                    return true;
                }//if
                    
              
        }//for 
        
        return false;
    }//Existe
   
}//class