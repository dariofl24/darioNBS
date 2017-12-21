

package gatov;

/**
 *
 * @author DarioF
 */
public class Vplayer {
    
    int nodesLim;
    boolean Turn;
    Lista_dob<Node> nodes;
    
    
    public Vplayer(int nlim){
        nodesLim= nlim;
        
    }//constructor0
    
    public int[] move(int[][] tab,int f,boolean tu){
        Lista_dob<Node> posiv= new Lista_dob<Node>();
        Lista_dob<Node> aux;
        genNodes(new Node(tab,f,tu));
        int n;
        
        nodes.primero();
        aux= nodes.elemento().nexts;
        aux.primero();
        
        posiv.insertarUltimo( aux.elemento() );
        aux.avanza();
        
        for(int i=2;i<=aux.lenght;i++){
            
            if(posiv.elemento().WC==aux.elemento().WC)
                posiv.insertarUltimo(aux.elemento());
            
            if(posiv.elemento().WC<aux.elemento().WC){
                posiv.limpiar();
                posiv.insertarUltimo(aux.elemento());
            }//if
            
            aux.avanza();
        }//for
        
        n= (int)(Math.round(Math.random() * 10) % posiv.lenght + 1);
        posiv.primero();
        
        for(int i=1;i<n;++i){
            posiv.avanza();
        }//for
        
        return posiv.elemento().cord;
    }//move 
    
    public void pp1(int[][] tab,int ff, boolean t){
        
        genNodes(new Node(tab,ff,t));
        System.out.println("OK");
        nodes.primero();
        for(int i=1;i<= nodes.lenght;++i){
            
                System.out.println("n:"+i);
                nodes.elemento().string();
            
            
            nodes.avanza();
        }//for
    }//pp1
    
    private void genNodes(Node node){
        nodes= new Lista_dob<Node>(node);
        Node naux; 
        int wc=0;
        
        while(nodes.lenght<=nodesLim){
            naux= nodes.elemento();
            naux.genNexts();
            nodes.addlistend( naux.nexts );
            
            if(nodes.estaAlFinal()) break;
            nodes.avanza();
        }//while
        
        nodes.ultimo(); 
        
        for(int i=1;i<=nodes.lenght;++i){
            naux= nodes.elemento();
            wc=0;
            
            if(naux.ngen){
                naux.nexts.primero();
                
                for(int j=1;j<=naux.nexts.lenght;++j){
                    wc=wc+ naux.nexts.elemento().WC;
                    naux.nexts.avanza();
                }//for
               naux.WC= wc; 
               naux.nexts.primero();
            }//if
            
            nodes.retrocede();
        }//for
        nodes.primero();
        
    }//genNodes
    
    
    
    
    private class Node{//true 1; false -1
        
        Lista_dob<Node> nexts= new Lista_dob<Node>();
        int[][] tab;
        int[] cord= new int[2];
        int ff, val,WC;
        boolean turn,ngen=false;
        
        public Node(boolean tu){
            tab= new int[3][3];
            ff=9;
            turn= tu;
            val= 0;
            WC= val;
        }//constructor0
        
        public Node(int[][] t,int f,boolean tu,int i,int j){
            tab= copytab(t);
            tab[i][j]= (tu)?1:-1;
            ff=f;
            turn= tu;
            cord[0]= i;
            cord[1]= j;
            val= winner(tab);
            WC= val;
        }//constructor 1
        
        public Node( int[][] t,int f,boolean tu){
            tab= copytab(t);
            ff=f;
            turn=tu;
            val=0;
            WC= val;
        }//constructor2
        
        public void genNexts(){
            if(ngen) return;
            if(ff==0) return;
            if(val!=0) return;
            Node naux;
            
            for(int i=0;i<=2;++i)
                for(int j=0;j<=2;++j){
                    
                    if(tab[i][j]!=0) continue;
                    naux= new Node(tab,ff-1,!turn,i,j);
                    
                    if(naux.val==1 || naux.val==-1){
                        nexts.limpiar();
                        nexts.insertarUltimo(naux); ngen= true;
                        return;
                    }//if
                    
                    nexts.insertarUltimo(naux);
                }//for
            
            ngen= true;
        }//genNexts
        
        public void string(){
            for(int i=0;i<=2;++i){
                for(int j=0;j<=2;++j){
                    if(tab[i][j]==-1) System.out.print("X");
                    if(tab[i][j]==0) System.out.print("_");
                    if(tab[i][j]==1) System.out.print("O");
                }//for
                System.out.print("\n");
            }//for
            System.out.print("  WC:"+WC+" ngen:"+ngen+" ij:"+cord[0]+" "+cord[1]+"\n\n");
        }//sting
        
    }//class
    
    
    private int winner(int[][] tab){
        int w1=0,w2=0,w3=0,w4=0;
        
        for(int i=0;i<=2;++i){
            w1=0; w2=0;
            
            w3+= tab[i][i];
            w4+= tab[i][2-i];
            
            for(int j=0;j<=2;++j){
                w1+=tab[i][j];
                w2+=tab[j][i];
            }//for
            
            if(w1==3 || w1==-3) return (w1==3)?1:-1;//
            if(w2==3 || w2==-3) return (w2==3)?1:-1;
        }//for
        
        if(w3==3 || w3==-3) return (w3==3)?1:-1;
        if(w4==3 || w4==-3) return (w4==3)?1:-1;
        
        return 0;
    }//winner
    
    
    
    
    
    private int[][] copytab(int[][] t){
        int[][] cp= new int[3][3];
        
        for(int i=0;i<=2;++i)
            for(int j=0;j<=2;++j){
                cp[i][j]= t[i][j];
            }//for
            
        return cp;
    }//copytab
    
    
}//class
