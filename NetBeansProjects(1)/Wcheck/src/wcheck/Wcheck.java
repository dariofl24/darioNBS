
package wcheck;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Wcheck {

    
    public static void main(String[] args) {
        
        try{
            String line="",word="",c="",list="";
            String[] words= new String[500];
            int j=0;
           
            BufferedReader r1= new BufferedReader(new FileReader("texto.txt"));
            //BufferedWriter wr= new BufferedWriter(new FileWriter("ortc.txt"));
            
            
            line= r1.readLine();
            
            while(line != null){
                line= line.trim();
                line=line+" ";
                
                if( line.contains("#'") ){
                    
                    word="";
                    
                    for(int i=0;i<line.length();i++){
                        
                        if(line.charAt(i)!=' '){
                            
                            word=word+line.charAt(i);
                            
                        }else{
                            
                            //if(j==209)System.out.println(word+"********************************************");
                            
                            word=word.replace("#chapter{","");
                            word=word.replace("#section{","");
                            word=word.replace("#subsubsection{","");
                            word=word.replace("#subsection{","");
                            word=word.replace("#paragraph","");
                            word=word.replace("#emph{","");
                            word=word.replace("#part","");
                            word=word.replace(".##","");
                            word=word.replace("##","");
                            word=word.replace("(","");
                            word=word.replace(")","");
                            word=word.replace(")","");
                            word=word.replace(",","");
                            word=word.replace(";","");
                            word=word.replace(":","");
                            word=word.replace(".","");
                            word=word.replace("?","");
                            word=word.replace("{","");
                            word=word.replace("}","");
                            word=word.replace("``","");
                            word=word.replace("%","");
                            
                            word=word.toLowerCase();
                            
                            
                            if(word.contains("#'") &&(!list.contains(" "+word+" ")) ){
                                
                                
                                words[j]=word;
                                list=list+(" "+word+" ");
                                j=j+1;
                                System.out.println(word);
                            }//if
                            word="";
                            
                        }//if-else
                        
                    }//for
                    
                    
                    
                }//if
                
                
                line= r1.readLine();
            }//while
            
            r1.close();
            
            System.out.println("\n"+"*******************************************");
            
            String[] words_2= new String[j];
            
            for(int i=0;i<j;i++){
                
                c=words[i];
                
                c=c.replace("#'a","á");
                c=c.replace("#'e","é");
                c=c.replace("#'i","í");
                c=c.replace("#'o","ó");
                c=c.replace("#'u","ú");
                
                words[i]=c;
                
                c=c.replace("á","a");
                c=c.replace("é","e");
                c=c.replace("í","i");
                c=c.replace("ó","o");
                c=c.replace("ú","u");
                
                words_2[i]=c;
                
                System.out.println(words[i]);
                
            }//for
            
            System.out.println("\n"+"*******************************************");
            
            for(int i=0;i<j;i++) System.out.println(words_2[i] );
                
                
            
        }catch(IOException e){
            
            System.out.println(e.getMessage());
            
        }//try-catch
        
        
    }//main
}//class
