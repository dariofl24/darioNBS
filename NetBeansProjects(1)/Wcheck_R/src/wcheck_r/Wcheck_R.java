
package wcheck_r;
import java.io.*;

/**
 *
 * @author Dario
 */
public class Wcheck_R {

    
    public static void main(String[] args) {
        
        try{
            String line="",wd="";
            int lim=355;
            String[] wds1= new String[lim];
            String[] wds2= new String[lim];
            
            BufferedReader r1= new BufferedReader(new FileReader("wds1.txt"));
            BufferedReader r2= new BufferedReader(new FileReader("wds2.txt"));
            BufferedReader reader= new BufferedReader(new FileReader("texto.txt"));
            BufferedWriter wr= new BufferedWriter(new FileWriter("OK.txt"));
            
            for(int i=0;i<lim;i++){
                
                wd=r1.readLine().trim();
                wds1[i]=wd;
                //System.out.println(wds1[i]);
                
                wd=r2.readLine().trim();
                wds2[i]=wd;
                //System.out.println(wds2[i]);
                
            }//for
            
            r1.close();
            r2.close();
            
            line= reader.readLine();
            
            while(line!=null){
                
                line=line.trim();
                line=" "+line+" ";
                
                for(int i=0;i<lim;i++){
                    
                    if(line.contains( " "+wds1[i]+" " ) || line.contains(wds1[i]+"." ) || line.contains(wds1[i]+":" )|| line.contains(wds1[i]+"," ) || line.contains(wds1[i]+";" )){
                        System.out.println(line);
                        System.out.println( wds1[i]+" ; "+wds2[i] );
                        line=line.replace(wds1[i], "#textcolor{blue}{"+wds2[i]+"}");
                        System.out.println(line);
                        System.out.println("\n**********************************************************************************");
                    }//if
                    
                }//for
                
                wr.write(line);
                wr.newLine();
                
                line= reader.readLine();
            }//while
            
            wr.close();
            
        }catch(IOException e){
            
        }//try-catch
        
        
    }//main
    
}//class
