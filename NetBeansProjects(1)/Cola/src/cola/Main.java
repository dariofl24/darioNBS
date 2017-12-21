

package cola;

/**
 *
 * @author Dario
 */
public class Main {

    
    public static void main(String[] args) {

        Cola<String> col= new Cola<String>();

        System.out.println(col.length);

        col.insert("a");
        col.insert("b");
        col.insert("c");
        col.insert("d");
        col.insert("e");

        System.out.println(col.length);

        while(col.length>0){

            System.out.println(col.getActual());
            col.next();
        }//while

        System.out.println(col.length);

        col.insert("1");
        col.insert("2");
        col.insert("3");
        col.insert("4");
        col.insert("5");

        while(!col.empty()){

            System.out.println(col.getActual());
            col.next();
        }//while

    }//main

}//class
