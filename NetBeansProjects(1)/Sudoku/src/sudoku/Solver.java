

package sudoku;

/**
 *
 * @author DarioF
 */
public class Solver {

    int[][] sud;
    
    public int[][] solve(int[][] gam){
        int i=0,j=0;
        sud=gam;
        
        while(sud[i][j]!=0){
           i=(j==8)?i+1:i; 
           j=(j+1)%9; 
        }//while
        
        if(genS(i,j)){
           return sud; 
        }//if
        System.out.println("null");
        return null;
    }//solve
    
    private boolean genS(int i,int j){
        int jn=j,in=i;
        
        do{
           in=(jn==8)?in+1:in; 
           jn=(jn+1)%9;
           if(in==9) break; 
        }while(sud[in][jn]!=0);
         
        Lista_dob<Integer> num= nums(i,j);
       // System.out.println(i+" "+j);
        //if(j==2 ||j==5||j==6||j==7||j==8) print(sud);
        
        for(int k=1;k<=num.lenght;++k){
            sud[i][j]= num.elemento();
            
            if(i==8 && j==8) return true;
            if(in==9) return true;
            if(genS(in,jn)) return true;
            num.avanza();
        }//for
        
        sud[i][j]=0;
        return false;  //***
    }//genS
    
    
    private Lista_dob<Integer> nums(int i,int j){
        boolean[] use= new boolean[9];
        Lista_dob<Integer> nums= new Lista_dob<Integer>();
        
        for(int k=0;k<9;++k){
            if(sud[i][k]!=0)
            use[ sud[i][k]-1 ]= true;
        }//for
        
        for(int k=0;k<9;++k){
            if(sud[k][j]!=0)
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
        
        return nums;
        
    }//nums
    
}//class
