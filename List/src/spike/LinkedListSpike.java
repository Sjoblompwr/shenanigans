package spike;

import com.sun.org.apache.xml.internal.utils.Trie;

import list.LinkedList;

/**
 *
 * @author David Sjöblom
 */
public class LinkedListSpike {
    
    public static void main(String []args){
        LinkedList<Integer> list = new LinkedList<>();
        
//        //Test add
//        System.out.println("Expected output 1,2,3.");
//        list.add( 1);
//        list.add( 2);
//        list.add( 3);   
//        list.printToSystem();
//        //Test delete
//        System.out.println("Expected output 1,2.");
//        list.remove( 2);
//        list.printToSystem();
//        //Test findFirst
//        System.out.println("Expected output 0.");
//        System.out.println(list.indexOf( 1));
//        //Test deleteObject
//        System.out.println("Expected output 2.");
//        list.remove( 1);
//        list.printToSystem();
//        System.out.println("Foo bar");
//        list.add( 2);
//        list.add( 3); 
//        list.printToSystem();
//        System.out.println(list.subList(1, 2).get(0));
//        System.out.println(list.subList(1, 2).get(1));
        for(int i = 0;i < 5;i++)
        	list.add(i);
        for(Integer i: list) {
        	System.out.println(i);
        }
        
        
        
    }
    
}
