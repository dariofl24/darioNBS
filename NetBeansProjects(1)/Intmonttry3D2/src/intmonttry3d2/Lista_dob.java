package intmonttry3d2;

/**
 *
 * @author Dario
 */
public class Lista_dob<gen>{

    NodoD<gen> actual;
    private NodoD<gen> ult;
    private NodoD<gen> prim;
    int lenght=0;

    public Lista_dob(){
        actual=null;
        ult=null;
        prim=null;
    }//constructor0

    public Lista_dob(gen e){
        actual= new NodoD<gen>(e);
        ult=actual;
        prim=actual; lenght+=1;
    }//constructor1

    /**
     * Inserta un elemento justo antes del elemento actual.
     * NO IMPORTA QUE EL ELEMENTO YA EXISTA
     * @param e
     */
    public void insetarAntes(gen e){

        if(actual==null){
            actual=new NodoD<gen>(e);
            ult=actual;
            prim=actual; lenght+=1;
        }else{
            NodoD<gen> aux=new NodoD<gen>(e,actual);

            if(actual.ant==null){
                actual.ant=aux;
                prim=aux;
            }else{
                aux.ant=actual.ant;
                actual.ant.sig=aux;
                actual.ant=aux;
            }//if-else
            lenght+=1;
        }//if-else
    }//agregaAntes

    /**
     * Inserta un elemento justo despues del elemento acutual.
     * NO IMPORTA QUE EL ELEMENTO YA EXISTA
     * @param e
     */
    public void insertarDespues(gen e){

        if(actual==null){
            actual=new NodoD<gen>(e);
            ult=actual;
            prim=actual; lenght+=1;
        }else{
            NodoD<gen> aux=new NodoD<gen>(actual,e);

            if(actual.sig==null){
                actual.sig=aux;
                ult=aux;
            }else{
                aux.sig=actual.sig;
                actual.sig.ant=aux;
                actual.sig=aux;
            }//if-else
            lenght+=1;
        }//if-else

    }//insertarDespues

    /**
     * Inserta un elemento al final de la lista.
     * NO IMPORTA QUE EL ELEMENTO YA EXISTA
     * @param e
     */
    public synchronized void insertarUltimo(gen e){

        if(prim==null){
            prim= new NodoD<gen>(e);
            ult= prim;
            actual=prim;
        }else{
            ult.sig= new NodoD<gen>(ult,e);
            ult= ult.sig;
        }//if-else
        lenght+=1;
    }//insertar

    /**
     * Inserta un elemento al principio de la lista.
     * NO IMPORTA QUE EL ELEMENTO YA EXISTA
     * @param e
     */
    public void insertarPrimero(gen e){

        if(prim==null){
            prim= new NodoD<gen>(e);
            ult= prim;
            actual=prim;
        }else{
            prim.ant=new NodoD<gen>(e,prim);
            prim=prim.ant;
        }//if-else
        lenght+=1;
    }//insertarPimero

    /**
     * Borra el elemento actual de la lista.
     */
    public void borrarActual(){
        if(actual==null) return;

        if( actual==(prim) ){
            prim=actual.sig;
            actual=actual.sig;
            if(actual!=null)actual.ant=null;
            ult=(actual==null)?null:ult; lenght-=1;
            return;
        }//if

        if( actual==(ult) ){
            ult=actual.ant;
            actual=actual.ant;
            if(actual!=null)actual.sig=null;//
            prim=(actual==null)?ult:prim; lenght-=1;
            return;
        }//if

        actual.sig.ant=actual.ant;
        actual.ant.sig=actual.sig;
        actual=actual.sig; lenght-=1;
    }//borarActual

    /**
     * Borra la primera ocurrencia del elemento.
     * @param e
     */
    public void borrar(gen e){
        primero();

        for(int i=0;i<lenght;i++){
            if( actual.elem.equals(e) ){
                borrarActual();
                primero();
                return;
            }//if
            avanza();
        }//for
        primero();
    }//borrar

    public gen elemento(){
        return (actual==null)?null:actual.elem;
    }//elemento
    
    public gen elementoant(){
        if(actual==null) return null;
        if(actual.ant==null) return null;
        
        return actual.ant.elem;
    }//elemento

    public gen elementosig(){
        if(actual==null) return null;
        if(actual.sig==null) return null;
        
        return actual.sig.elem;
    }//elemento
    
    public synchronized gen elementoav(){
        gen aux= elemento();
        avanza();
        if(actual==null){
           prim=null;
           lenght=0;
        }//
        if(actual!=null){
            if(actual.ant==prim) prim=actual; 
            actual.ant=null;
            lenght=lenght-1;
        }//if
        return aux;
    }//
    
    public void cambiarelemento(gen e){
        if(actual!=null) actual.elem=e;
    }//cambiarelemento

    public void avanza(){//Mont mo
        if(actual==null) return;
        //actual=(actual.sig==null)?actual:actual.sig;
        actual=(actual.sig==null)?null:actual.sig;
    }//avanza

    public void retrocede(){
        if(actual==null) return;
        actual=(actual.ant==null)?actual:actual.ant;
    }//retocede

    /**
     * Regresa al primer elemento de la lista.
     */
    public void primero(){
        actual=prim;
    }//principio

    /**
     * Va hacia el ultimo elemento de la lista.
     */
    public void ultimo(){
        actual=ult;
    }//ultimo

    public boolean estaAlFinal(){
        return (actual==null)?false:actual.equals(ult);
    }//estaAlFinal

    public boolean estaAlPrincipio(){
        return (actual==null)?false:actual.equals(prim);
    }//estaAlPrincipio

    /**
     * Informa si la lista esta vacia o no.
     * @return true si esta vacia, false si tiene por lo menos un elemento.
     */
    public boolean Vacia(){//Mont mod
        return lenght==0;
        //return prim==null;
    }//Vacia

    /**
     * Informa si un elemento ya existe en la lista
     * @param comp
     * @return true si existe en la lista.
     */
    public boolean Existe(gen comp){

        NodoD<gen> nod= prim;

        if(nod==null) return false;

        while(nod!=null){
            if(nod.elem.equals(comp)) return true;
            nod=nod.sig;
        }//while

        return false;
    }//Existe

    public void limpiar(){
        prim=null;
        actual=null;
        ult=null;
        lenght=0;
    }//limpiar


    @Override
    public String toString(){
        String s="";
        NodoD nod= prim;

        while(nod!=null){
            s=s+nod.elem.toString()+"\n";
            nod=nod.sig;
        }//while

        return s;
    }//toString


    private class NodoD<gen>{
        NodoD<gen> sig,ant;
        gen elem;

    public NodoD(){
        ant=null;
        sig=null;
        elem=null;
    }//constructor0

    public NodoD(gen e){
        ant=null;
        sig=null;
        elem=e;
    }//constructor1

    public NodoD(NodoD<gen> a,gen e){
        ant=a;
        sig=null;
        elem=e;
    }//constructor2

    public NodoD(gen e,NodoD<gen> s){
        ant=null;
        sig=s;
        elem=e;
    }//constructor3

    public NodoD(gen e,NodoD<gen> a,NodoD<gen> s){
        ant=a;
        sig=s;
        elem=e;
    }//constructor4
    }//class






}//class

