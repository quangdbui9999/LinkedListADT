/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: LinkedOrderedList represents a singly linked 
 * implementation of an ordered list.
 */

package jsjf;

import exceptions.NonComparableElementException;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: LinkedOrderedList represents a singly linked 
 * implementation of an ordered list.
 */
public class LinkedOrderedList<T> extends LinkedList<T> 
        implements OrderedListADT<T>{
    /**
     * Creates an empty list.
     */
    public LinkedOrderedList(){
        super();
    }
    
    /**
     * Adds the specified element to this list at the location determined by
     * the element's natural ordering. Throws a NonComparableElementException 
     * if the element is not comparable.
     * @param element the element to be added to this list
     * @throws NonComparableElementException if the element is not comparable
     */
    public void add(T element)
    {
        if((element instanceof Comparable) == false){
            throw new NonComparableElementException("LinkedOrderedList");
        }
        
        LinearNode<T> current = head;
        LinearNode<T> previous = null;
        LinearNode<T> newElement = new LinearNode<T>(element);
        Comparable<T> comparableElement = (Comparable<T>)element;
        // previous.getNext() -> current
        if(this.isEmpty()){ // the list is empty
            head = newElement;
            tail = newElement;
        }else if(comparableElement.compareTo(head.getElement()) == -1){
            // if newElement is smallest value in the list
            newElement.setNext(head);
            head = newElement;
        }else if(comparableElement.compareTo(tail.getElement()) == 1){
            // if newElement is largest value in the list
            tail.setNext(newElement);
            tail = newElement;
        }else{
            // if newElement is the range of value in the list
            // between the smallest and largest value
            while(comparableElement.compareTo(current.getElement()) > 0){
                previous = current;
                current = current.getNext();
            }
            previous.setNext(newElement);
            newElement.setNext(current);
            //previous.setNext(newElement);
        }
        
        count++;
        modCount++;
    }
}