/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package jsjf;

import java.util.Scanner;


/**
 * DRIVE FILR
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class ListTester {
    public static void main(String[] args) {
        ArrayUnorderedList<Integer> myIntArray = new 
                            ArrayUnorderedList<Integer>(5);
        myIntArray.addToFront(35);
        myIntArray.addToFront(93);
        myIntArray.addToRear(67);
        myIntArray.addToFront(127);
        myIntArray.addAfter(90, 93);
        myIntArray.addToRear(154);
        myIntArray.addAfter(51, 35);
        
        System.out.println("Actual size: " + myIntArray.size());
        System.out.println("Physics size: " + myIntArray.getPhysicsSize());
        System.out.println("Display element: " + myIntArray);
        System.out.println("\nSublist [-1, 22]: "
                + "" + myIntArray.subList(-1, 22));
        System.out.println("Sublist [6, 1]: " + myIntArray.subList(6, 1));
        System.out.println("Sublist [0, 8]: " + myIntArray.subList(0, 8));
        System.out.println("Sublist [0 - 6]: " + myIntArray.subList(0, 6));
        System.out.println("Sublist [0 - 7]: " + myIntArray.subList(0, 7));
        System.out.println("Sublist [2 - 5]: " + myIntArray.subList(2, 5));
        System.out.println("Sublist [3 - 7]: " + myIntArray.subList(3, 7));
        
        System.out.println("\nThe front element of "
                + "the List: " + myIntArray.first());
        System.out.println("The rear element of "
                + "the List: " + myIntArray.last());
        System.out.println("The list is contained "
                + "the element 91: " + myIntArray.contains(91));
        System.out.println("The list is contained "
                + "the element 93: " + myIntArray.contains(93));
        System.out.println("\nRemove the last "
                + "element: " + myIntArray.removeLast());
        System.out.println("Actual size: " + myIntArray.size());
        System.out.println("Physics size: " + myIntArray.getPhysicsSize());
        System.out.println("Display element: " + myIntArray);
        
        System.out.println("\nRemove the first "
                + "element: " + myIntArray.removeFirst());
        System.out.println("Actual size: " + myIntArray.size());
        System.out.println("Physics size: " + myIntArray.getPhysicsSize());
        System.out.println("Display element: " + myIntArray);
        
        System.out.println("\nRemove the element"
                + ": " + myIntArray.remove(51));
        System.out.println("Actual size: " + myIntArray.size());
        System.out.println("Physics size: " + myIntArray.getPhysicsSize());
        System.out.println("Display element: " + myIntArray);
        
        System.out.println("\nDelete all elements in the list.");
        myIntArray.clearList();
        System.out.println("Display element: " + myIntArray);
    }
}

/*
run:
Actual size: 7
Physics size: 10
Display element: 127 93 90 35 51 67 154 

Sublist [-1, 22]: null
Sublist [6, 1]: null
Sublist [0, 8]: null
Sublist [0 - 6]: 127 93 90 35 51 67 
Sublist [0 - 7]: 127 93 90 35 51 67 154 
Sublist [2 - 5]: 90 35 51 
Sublist [3 - 7]: 35 51 67 154 

The front element of the List: 127
The rear element of the List: 154
The list is contained the element 91: false
The list is contained the element 93: true

Remove the last element: 154
Actual size: 6
Physics size: 10
Display element: 127 93 90 35 51 67 

Remove the first element: 127
Actual size: 5
Physics size: 5
Display element: 93 90 35 51 67 

Remove the element: 51
Actual size: 4
Physics size: 5
Display element: 93 90 35 67 

Delete all elements in the list.
Display element: Empty List
BUILD SUCCESSFUL (total time: 0 seconds)

*/