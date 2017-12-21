

package evaluator;

/**
 *
 * @author Dario
 */
public class Pila<gen>{

    private Nodo<gen> current;
    private int length;

    public Pila(){
        current= null;
        length= 0;
    }//constructor 0

    public Pila(gen e){
        current= new Nodo<gen>(e);
        length=1;
    }//constructor 1


    public void push(gen e){
        Nodo<gen> aux;

        if(current==null){
            current= new Nodo(e);
        }else{
            aux= new Nodo<gen>(e);
            aux.next= current;
            current= aux;
        }//if-else
            length+=1;
    }//push

    public gen top(){

        if(current==null) return null;

        return current.elem;
    }//top

    public gen pop(){
        gen el;

        if(current==null) return null;
        el= current.elem;
        current= current.next;
        length-=1;
        return el;
    }//pop

    public int length(){
        return length;
    }//length

    public boolean empty(){
        return length==0;
    }//vacia

    public void reset(){
        current= null;
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
