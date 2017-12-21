
package rieman_calc;

/**
 *
 * @author DarioF
 */
public class Rieman_calc {

    
    public static void main(String[] args) {
        
        String[] xs={"t","x","y","z"};
        String[][][] cris= new String[4][4][4];
        String[][][][] cris_d= new String[4][4][4][4];
        String[][][][] trie= new String[4][4][4][4];
        String sum="",aux1,aux2;
        boolean flag;
        int n=1;
        
        for(int i=0;i<=3;++i){
            
            for(int j=0;j<=3;++j){
                cris[i][j][i]="F,"+xs[j];
                cris[i][i][j]="F,"+xs[j];        
            }//for
            
        }//for
        
        for(int i=1;i<=3;++i){
            cris[0][i][i]="F,t";
            cris[i][0][0]="F,"+xs[i];
        }//for
        
        for(int i=1;i<=3;++i){
            
            for(int j=1;j<=3;++j){
                
                if(i!=j){
                    cris[i][j][j]="-F,"+xs[i];
                }//if
                
            }//for
        }//for
        
        //***************************************************
        
        for(int i=0;i<=3;++i){
            
            for(int j=0;j<=3;++j){
                
                for(int k=0;k<=3;++k){
                   
                    if(cris[i][j][k]!=null){
                        
                        for(int l=0;l<=3;++l)
                            cris_d[i][j][k][l]="("+cris[i][j][k]+","+xs[l]+")";
                        
                        cris[i][j][k]="("+cris[i][j][k]+")";
                    }//if
                    for(int l=0;l<=3;++l) trie[i][j][k][l]="";

                }//for
            }//for
        }//for
        
        //***************************************************************
        
        for(int i=0;i<=3;++i){
            for(int j=0;j<=3;++j){         
                for(int k=0;k<=3;++k){
                    
                    for(int l=0;l<=3;++l){
                        aux1=""; aux2="";
                        
                        if(cris_d[i][j][l][k]!=null) aux1=cris_d[i][j][l][k];
                        
                        if(cris_d[i][j][k][l]!=null) aux2=cris_d[i][j][k][l];
                        
                        if(!aux1.equalsIgnoreCase(aux2)) 
                        trie[i][j][k][l]=aux1+"-"+aux2;
                        
                        aux1=""; aux2="";
                        
                        sum=" {"; flag=false;
                        for(int p=0;p<=3;++p){
                            
                            if( (cris[i][p][k]!=null )&&(cris[p][j][l]!=null) ){
                                sum=sum+cris[i][p][k]+cris[p][j][l]+"+";
                                flag=true;
                            }//if
                            
                        }//for p
                        sum= sum+"} ";
                        if(flag) aux1=sum; 
                            //trie[i][j][k][l]=trie[i][j][k][l]+"+"+sum;
                        
                        sum=" {"; flag=false;
                        for(int p=0;p<=3;++p){
                            
                            if( (cris[i][p][l]!=null )&&(cris[p][j][k]!=null) ){
                                sum=sum+cris[i][p][l]+cris[p][j][k]+"+";
                                flag=true;
                            }//if
                            
                        }//for p
                        sum= sum+"} ";
                        if(flag) aux2=sum; 
                            //trie[i][j][k][l]=trie[i][j][k][l]+"-"+sum;
                        
                        if(!aux1.equalsIgnoreCase(aux2)){
                            trie[i][j][k][l]=trie[i][j][k][l]+"+"+aux1+"-"+aux2;
                        }//if
                        
                        
                    }//for
                }//for
            }//for
        }//for
        
        //******************************
        
        for(int i=0;i<=3;++i){
            for(int j=0;j<=3;++j){
                for(int k=0;k<=3;++k){
                    for(int l=0;l<=3;++l){
                        
                        if(!trie[i][j][k][l].equalsIgnoreCase("")){
                            System.out.print(n+";("+xs[i]+xs[j]+xs[k]+xs[l]+")");
                            System.out.println(":  "+trie[i][j][k][l]+"\n");
                            
                            n=n+1;
                        }//if
                        
                    }//for
                    
                }//for
            }//for
        }//for
        
        
        
    }//main 
}//class
