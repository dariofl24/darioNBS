

package gsltry;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Dario
 */
public class Salida{
    
    int n=0;
    //SalidaDeDisco sad_Reg;
    
    BufferedWriter sad_Reg;

    
    
            
    public Salida(){
        try{
            sad_Reg = new BufferedWriter(new FileWriter("Registros.txt"));    
        }catch(IOException ex){
            System.out.println("error: Salida: constructor\n");
            System.out.println(ex.getMessage());
            System.exit(-1);
        }//try-catch
        
    }//C_salida
    
    public Salida(String archivo){
        try{
               sad_Reg =new BufferedWriter(new FileWriter("Registros_"+archivo+".txt"));
        }catch(IOException ex){
            System.out.println("error: Salida: constructor\n");
            System.out.println(ex.getMessage());
            System.exit(-1);
        }//try-catch
        
    }//C_archivo 
    
    
   
    
    
    public void G_int(int i){ 
        try{
            sad_Reg.write(""+i);sad_Reg.newLine();
        }catch(IOException ex){
            System.out.println("error: Salida: G_int\n");
            System.out.println(ex.getMessage());
            System.exit(-1);
        }//try-catch
         
    }//G_int
    
    public void G_s(String s){ 
        try{
            sad_Reg.write(s);sad_Reg.newLine();
        }catch(IOException ex){
            System.out.println("error: Salida: G_s\n");
            System.out.println(ex.getMessage());
            System.exit(-1);
        }//try-catch
         
    }//G_s
    
    public void cierra(){
        try{
            sad_Reg.close();
        }catch(IOException ex){
            System.out.println("error: Salida: G_s\n");
            System.out.println(ex.getMessage());
            System.exit(-1);
        }//try-catch
        
    }//cierra
    
    
    
}//class