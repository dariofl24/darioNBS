package virtualplayer.nodes;

import java.util.ArrayList;
import java.util.HashMap;
import virtualplayer.VplayerUtil;

public class Node {

    private final int MAX_LEVEL = VplayerUtil.MAX_LEVEL;
    private final String Max_s="O";
    private final String Min_s="X";
    private final int Max = VplayerUtil.Max;
    private final int Min = VplayerUtil.Min;
    
    private final int P_Max_Wins=VplayerUtil.P_MAX_WINS;
    private final int P_Min_Wins=VplayerUtil.P_MIN_WINS;
    private final int P_Draw=VplayerUtil.P_DRAW;
    
    private final boolean Max_b= VplayerUtil.Max_b;
    private final boolean Min_b= VplayerUtil.Min_b;
    private int[][] state;
    private boolean turn;
    private int level;
    private boolean wins,draw;
    private int value;
    private ArrayList<Node> children = new ArrayList<Node>();
    private String hashValue;
    private double[] values= new double[3];

    
    
    public Node(int[][] state, boolean turn, int level) {

        this.state = state;
        this.turn = turn;
        this.level = level;

        this.wins = VplayerUtil.checkWins(this.state, turn);

        if (wins) {
            value = (turn) ? this.Max : this.Min;
        } else {
            this.value = 0;
        }//if - else
        
        if(value==this.Max){
            
           this.values[this.P_Max_Wins]=1; 
           
        }else if(value==this.Min){
            
            this.values[this.P_Min_Wins]=1;
            
        }else{
            
            if(VplayerUtil.isDraw(this.state)){
                this.draw= true;
                this.values[this.P_Draw]=1;
            }//if
            
        }//if - else

        this.hashValue= VplayerUtil.getHashCode(state, turn);
    }//0

    
    
    public double[] generateChildren() {

        if (this.wins || this.draw || (this.level >= MAX_LEVEL)) {
            return values;
        }//if

        Node newChild;
        ArrayList<Node> Wchildren = new ArrayList<Node>();
        double[] newValue;
        int move = (this.turn) ? -1 : 1;
        int[][] temp;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (state[i][j] == 0) {

                    temp = VplayerUtil.cloneState(state);
                    temp[i][j] = move;

                    newChild = new Node(temp, !this.turn, this.level + 1);

                    if (newChild.wins) {
                        Wchildren.add(newChild);
                    }else{
                        this.children.add(newChild);
                    }//if - else
                    
                }//if

            }//for
        }//for
        
        if(Wchildren.size()>0){
            this.children.clear();
            this.children.addAll(Wchildren);
        }//if

        Wchildren.clear();
        
        if (this.children.size() > 0) {

            for (Node child : this.children) {
                newValue = child.generateChildren();
                
                this.values[this.P_Max_Wins] += newValue[this.P_Max_Wins];
                this.values[this.P_Min_Wins] += newValue[this.P_Min_Wins];
                this.values[this.P_Draw] += newValue[this.P_Draw];
            }//for

            //this.value = newValue;
        }//if

        return this.values;
    }//generateChildren

    public int[][] getState() {
        return state;
    }

    public boolean isTurn() {
        return turn;
    }

    public int getLevel() {
        return level;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public String getHashValue() {
        return hashValue;
    }
    
    public boolean isDraw(){
        return this.draw;
    }
    
    public boolean isWins(){
        return this.wins;
    }
    
    public double getMAX_WinChance(){
        return this.values[this.P_Max_Wins]/(this.values[this.P_Max_Wins]+this.values[this.P_Min_Wins]+this.values[this.P_Draw]);
    }//
    
    public double getMIN_WinChance(){
        return this.values[this.P_Min_Wins]/(this.values[this.P_Max_Wins]+this.values[this.P_Min_Wins]+this.values[this.P_Draw]);
    }//
    
    public double getDRAW_Chance(){
        
        return this.values[this.P_Draw]/(this.values[this.P_Max_Wins]+this.values[this.P_Min_Wins]+this.values[this.P_Draw]);
    }//
    
    public String stateString(){
        String s="";
        
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                s=s+ state[i][j]+"|";
            }//for
        
        return s.substring(0,state.length-1);
    }//
    
    @Override
    public String toString(){
        String s="";
        
        s="Turn: ";
        s=s+ ((turn)?"Max("+this.Max_s+")":"min("+this.Min_s+")")+"\n";
        
        s=s+"Value: "+this.value+"\n";
        s=s+"Max:"+this.getMAX_WinChance()+" Draw:"+this.getDRAW_Chance()+" Min:"+this.getMIN_WinChance()+"\n";
        
        s=s+"Hash: "+this.hashValue+"\n";
        s=s+"Level: "+this.level+" ";
        s=s+"Children: "+this.children.size()+"\n"+"\n";
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                s=s+( (this.state[i][j]==0)?" ": ( (this.state[i][j]==Max)?this.Max_s:this.Min_s ) );
            }//for
            s=s+"\n";
        }//for
        
        s=s+"\n";
        
        return s;
    }//toString
    
}//class
