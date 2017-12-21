
package sudoku;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        Sudoku su= new Sudoku();
        Solver so= new Solver();
        //int[][] g= su.Getg();
        //su.GetS();
     
        //su.print(g);
        //System.out.println("\n************************\n");
        
        int[][] ga={{1,0,0,0,0,7,0,9,0},
                    {0,3,0,0,2,0,0,0,8},
                    {0,0,9,6,0,0,5,0,0},
                    {0,0,5,3,0,0,9,0,0},
                    {0,1,0,0,8,0,0,0,2},
                    {6,0,0,0,0,4,0,0,0},
                    {3,0,0,0,0,0,0,1,0},
                    {0,4,0,0,0,0,0,0,7},
                    {0,0,7,0,0,0,3,0,0}};
        
        su.print( so.solve(ga) );
        
        
    }//main

}//class
