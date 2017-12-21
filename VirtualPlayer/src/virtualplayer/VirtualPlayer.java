
package virtualplayer;

import java.util.ArrayList;
import virtualplayer.nodes.Node;


public class VirtualPlayer {

    
    public static void main(String[] args) {
        
        int[][] state={{1,-1,0},
                       {0,-1,1},
                       {0,0,0}};
        
        //int[][] state, boolean turn, int level
        Node root= new Node(state,false,0);
        
        double[] rootval;
        
        rootval = root.generateChildren();
        
        ArrayList<Node> allNodes= new ArrayList<Node>();
        
        allNodes.add(root);
        
        Node aux;
        
        for(int i=0;i<allNodes.size();i++){
            
            aux= allNodes.get(i);
            allNodes.addAll(aux.getChildren());
            System.out.println(i+" "+aux);
        }//for
        
    }//main
    
}//class
