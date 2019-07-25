/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: LinkedUnorderedList represents a singly linked 
 * implementation of an unordered list.
 */

package jsjf;

import exceptions.ElementNotFoundException;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: LinkedUnorderedList represents a singly linked 
 * implementation of an unordered list.
 */

public class LinkedUnorderedList<T> extends LinkedList<T> 
        implements UnorderedListADT<T>{
    /**
     * Creates an empty list.
     */
    public LinkedUnorderedList(){
        super();
    }

    /**
     * Adds the specified element to the front of this list.
     * @param element the element to be added to the list
     */
    @Override
    public void addToFront(T element) {
        LinearNode<T> newNode = new LinearNode<T>(element);
        
        if(this.isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
        count++;
        modCount++;
    }

    /**
     * Adds the specified element to the rear of this list.
     * @param element the element to be added to the list
     */
    @Override
    public void addToRear(T element) {
        LinearNode<T> newNode = new LinearNode<T>(element);
        
        if(this.isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
        modCount++;
    }

    /**
     * Adds the specified element to this list after the given target.
     * @param  element the element to be added to this list
     * @param  target the target element to be added after
     * @throws ElementNotFoundException if the target is not found
     */
    @Override
    public void addAfter(T element, T target) {
        if(this.isEmpty()){
            throw new ElementNotFoundException("Linked List");
        }
        
        boolean isFoundTarget = false;
        LinearNode<T> newNode = new LinearNode<T>(element);
        LinearNode<T> current = head;
        
        while(current != null && isFoundTarget == false){
            if(current.getElement().equals(target)){
                isFoundTarget = true;
            }else{
                current = current.getNext();
            }
        }
        
        if(isFoundTarget == false){
            throw new ElementNotFoundException("LinkedList");
        }
        
        /*
        a list 1 2 3 5
        target = 3
        newNode = 4
        current = 3;
        current.getNext = 5
        newNode.setNext() -> 4 point to 5
        current.setNext(newNode);
        current = 3 but newNode = 4 so current.setNext(newNode) => cuurent = 4
        */
        
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        
        count++;
        modCount++;
    }
}