

package cola;

/**
 *
 * @author Dario
 */
public class Cola<gen> {
    
    private Nodo<gen> current,ult;
    int length;
    
    public Cola(){
        current= null;
        ult= null;
        length=0;
    }//constructor 0
    
    public Cola(gen e){
        current= new Nodo(e);
        ult= current;
        length=1;
    }//constructor 1
    
    public void insert(gen e){
        Nodo<gen> aux;
        
        if(current==null){
            current= new Nodo(e);
            ult= current;
        }else{
            aux= new Nodo<gen>(e);
            ult.next= aux;
            ult= aux;
        }//if-else
        
        length+=1;
    }//insert
    
    public gen getActual(){
        
        if(current==null) return null;
        return current.elem;
        
    }//actual
    
    public gen getNext(){
        
        next();
        if(current==null) return null;
        
        return current.elem;
    }//next
    
    public void next(){
        if(current==null) return;
        
        current= current.next;
        length-=1;
    }//next
    
    public int length(){
        return length;
    }//length

    public boolean empty(){
        return length==0;
    }//empty

    public void reset(){
        current=null;
        length=0;
    }//reset

    private class Nodo<gen>{
        Nodo<gen> next;
        gen elem;

        public Nodo(){
            elem= null;
            next= null;
        }//constructor 1

        public Nodo(gen e){
            elem= e;
            next= null;
        }//constructor 1

        public Nodo(gen e,Nodo<gen> n){
            elem= e;
            next= n;
        }//constructor 2

    }//Nodo

}//class
