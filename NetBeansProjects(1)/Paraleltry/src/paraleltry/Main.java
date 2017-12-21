

package paraleltry;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        Printer p= new Printer();
        
        Individual ind1= new Individual("1",p);
        Individual ind2= new Individual("2",p);
        Individual ind3= new Individual("3",p);
        
        Individual ind4= new Individual("4",p);
        Individual ind5= new Individual("5",p);
        
        ind1.start();
        ind2.start();
        ind3.start();
        ind4.start();
        ind5.start();
        
        System.out.println("started");
    }//main

}//class
