

package sudoku;

/**
 *
 * @author DarioF
 */
public class Sudoku {
    
    int[][] sud;
    int[] lev={28,35,39,45,47,50,54,58,60};
    
    public void GetS(){
        
        sud= new int[9][9];
        
        if(genS(0,0)){
            
            for(int i=0;i<9;++i){
                for(int j=0;j<9;++j){
                    System.out.print(sud[i][j]);
                }//for
                System.out.print("\n");
            }//for
            
        }//if
        
    }//genS
    
    
    
    public int[][] Getg(){
        int n,k=1,i=0,j=0;
        int[][] game= new int[9][9];
        sud= new int[9][9];
        
        
        if(genS(0,0)){ print(sud); 
            
             n=lev [(int) ((Math.round(Math.random() * 10)) % 9)];
             
             System.out.println("Gen: "+n);
             
             while(k<=n){
                 i=(int) (((Math.round(Math.random() * 10)) % 9));
                 j=(int) (((Math.round(Math.random() * 10)) % 9));
                 
                 if(game[i][j]==0){
                     game[i][j] =sud[i][j]; 
                     k+=1;
                 }//if
                 
             }//while
             
             return game;
        }//if
        
        return null;
    }//Getg
    
    
    
    public void print(int[][] sud){
        for(int i=0;i<9;++i){
                for(int j=0;j<9;++j){
                    System.out.print(sud[i][j]);
                }//for
                System.out.print("\n");
            }//for
    }//print
    
    private boolean genS(int i,int j){
        int jn=(j+1)%9;
        int in=(j==8)?i+1:i; 
        Lista_dob<Integer> num= nums(i,j);
       // System.out.println(i+" "+j);
        //if(j==2 ||j==5||j==6||j==7||j==8) print(sud);
        
        for(int k=1;k<=num.lenght;++k){
            sud[i][j]= num.elemento();
            
            if(i==8 && j==8) return true;
            if(genS(in,jn)) return true;
            num.avanza();
        }//for
        
        sud[i][j]=0;
        return false;  //***
    }//genS
    
    private Lista_dob<Integer> nums(int i,int j){
        boolean[] use= new boolean[9];
        Lista_dob<Integer> nums= new Lista_dob<Integer>();
        
        for(int k=0;k<j;++k){
            use[ sud[i][k]-1 ]= true;
        }//for
        
        for(int k=0;k<i;++k){
            use[ sud[k][j]-1 ]= true;
        }//for
        
        int k=0,l=0;
        
        if(3<=i && i<=5) k=3;
        if(6<=i && i<=8) k=6;
        
        if(3<=j && j<=5) l=3;
        if(6<=j && j<=8) l=6;
        
        for(int p=k;p<=k+2;++p)
            for(int q=l;q<=l+2;++q){ 
                if(sud[p][q]!=0)
                    use[ sud[p][q]-1 ]= true;
            }//for
        
        for(int p=0;p<9;++p){
            if(!use[p])
                nums.insertarUltimo(p+1);
        }//for 
        
        
        Lista_dob<Integer> rn= new Lista_dob<Integer>();
        int n;
        
        //if(nums.lenght<=3) return nums;
        
        while(nums.lenght!=rn.lenght){
            n=(int) (((Math.round(Math.random() * 10)) % 9) + 1);
            
            if(nums.Existe(n))
                if(!rn.Existe(n)) 
                    rn.insertarUltimo(n);
        }//while
        
        return rn;
    }//nums
    
    
    
    
    
    
}//class
