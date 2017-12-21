

package pila;

/**
 *
 * @author Dario
 */
public class Main {

    public static void main(String[] args) {

        Pila<String> pil= new Pila<String>();

        System.out.println("length: "+pil.length());

        pil.push("a");

        System.out.println("length: "+pil.length());
        System.out.println(pil.top());

        pil.push("b");
        pil.push("c");
        pil.push("d");
        pil.push("e");
        pil.push("f");

        System.out.println("length: "+pil.length());

        while(pil.length()>0){

            System.out.println(pil.pop());

        }//while

    }//main

}//class
