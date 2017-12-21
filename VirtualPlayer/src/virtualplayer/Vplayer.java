
package virtualplayer;

import java.util.ArrayList;
import virtualplayer.nodes.Node;


public class Vplayer {
   
    private final int MAX_LEVEL= VplayerUtil.MAX_LEVEL;
    private final int Max= VplayerUtil.Max;
    private final int Min= VplayerUtil.Min;
    private final boolean Max_b= VplayerUtil.Max_b;
    private final boolean Min_b= VplayerUtil.Min_b;
    
    public Node getNextMove(int[][] state,boolean turn){
        
        Node root= new Node(state,turn,0);
        
        if(root.isWins()) return root;
        
        double[] rootval;
        
        rootval = root.generateChildren();
        
        ArrayList<Node> children= new ArrayList<Node>();
        
        System.out.println("-------------------------------------------------");
        
        for(Node ch:root.getChildren()){ System.out.println(ch);
            
            if(children.size()>0){
                
                if(ch.getMAX_WinChance()== children.get(0).getMAX_WinChance()){
                    
                    children.add(ch);
                    
                }else if(ch.getMAX_WinChance() > children.get(0).getMAX_WinChance()){
                    
                    children.clear();
                    children.add(ch);
                }//if - else
                
            }else{
                children.add(ch);
            }//if
            
        }//for
        
        System.out.println("-------------------------------------------------");
        
        int random= (int) Math.floor(Math.random() *children.size() ) ;
        
        Node aux= children.get(random);
        
        if(children.size()>1){
            
            for(int i=0;i<children.size();i++){
                
                if(children.get(i).getMIN_WinChance()< aux.getMIN_WinChance() )
                    aux= children.get(i);
                
            }//for
            
        }//if
        
        
        return aux;
    }//getNextMove
    
    
}//class
