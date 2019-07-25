/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Tuesday, October 16th, 2018
 *  Description: ArrayOrderedList represents an array implementation 
 * of an ordered list.
 */

package jsjf;

import exceptions.NonComparableElementException;

/**
 * Programmed by: Quang Bui
 * Due Date: Tuesday, October 16th, 2018
 * Description: ArrayOrderedList represents an array implementation 
 * of an ordered list.
 */
public class ArrayOrderedList<T> extends ArrayList<T> 
        implements OrderedListADT<T>{
    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayOrderedList(){
        super();
    }
    
    /**
     * Creates an empty list using the specified capacity.
     * @param initialCapacity the initial size of the list
     */
    public ArrayOrderedList(int initialCapacity)
    {
        super(initialCapacity);
    }
    
    /**
     * Adds the specified Comparable element to this list, keeping
     * the elements in sorted order.
     * @param element the element to be added to the list
     */
    public void add(T element){
        if(!(element instanceof Comparable))
            throw new NonComparableElementException("OrderedList");
        
        Comparable<T> comparableElement = (Comparable<T>)element;
        
        if(size() == list.length){
            expandCapacity();
        }
        
        int scan = 0;
        
        // find the insertion location
        while(scan < rear && comparableElement.compareTo(list[scan]) > 0){
            scan++;
        }
        
        // shift existing elements up one
        for(int shift = rear; shift > scan; shift--){
            list[shift] = list[shift - 1];
        }
        
        //insert element
        list[scan] = element;
        rear++;
        modCount++;
    }
}