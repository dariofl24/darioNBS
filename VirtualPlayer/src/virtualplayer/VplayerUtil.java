
package virtualplayer;

import virtualplayer.nodes.Node;


public class VplayerUtil {
    public static final int Max=1;
    public static final int Min=-1;
    public static final boolean Max_b= true;
    public static final boolean Min_b= false;
    public static final int MAX_LEVEL= 7;
    
    public static final int P_MAX_WINS=0;
    public static final int P_DRAW=1;
    public static final int P_MIN_WINS=2;
    
    private static final String Max_WinState="111";
    private static final String Min_WinState="-1-1-1";
    
    public static boolean checkWins(int[][] state,boolean turn){
        
        String winState;
        String h="",v="",x1="",x2="";
        
        if(turn){
            winState= Max_WinState;
        }else{
            winState= Min_WinState;
        }//if - else
        
        for(int i=0;i<3;i++){
            
            h="";
            v="";
            
            for(int j=0;j<3;j++){
                
                h= state[i][j]+h;
                v= state[j][i]+v;
                
            }//for
            
            if(h.equalsIgnoreCase(winState)||v.equalsIgnoreCase(winState)){
                return true;
            }//if
            
        }//for
        
        for(int i=0; i<3;i++){
            
            x1= state[i][i]+x1;
            x2= state[i][2-i]+x2;
            
        }//for
        
        if(x1.equalsIgnoreCase(winState)||x2.equalsIgnoreCase(winState)){
                return true;
        }//if
        
        return false;
    }//checkWins
    
    public static boolean isDraw(int[][] state){
        
        for(int i=0;i<3;i++){
            
            for(int j=0;j<3;j++){
                if(state[i][j]==0) return false;
            }//for
            
        }//for
        
        return true;
    }//
    
    public static int[][] cloneState(int[][] state){
        
        int[][] clone = new int [3][3];
        
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                clone[i][j]= state[i][j];
            }//for
        
        return clone;
    }//cloneState
    
    public static String getHashCode(int[][] state,boolean turn){
        
        int vec=0;
        String hash="";
        
        for(int i=0;i<3;i++){
            
            vec=0;
            
            for(int j=0;j<3;j++){
                
                if(state[i][j]==1){
                    vec+=10;
                }else if(state[i][j]==-1){
                    vec+=1;
                }//if - else
                
            }//for
            
            hash=hash+vec;
        }//for
            
        hash= hash+( (turn)?"+":"-" );
        
        return hash;
    }//
    
}//class
