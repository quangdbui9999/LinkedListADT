/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: LinkedList represents a linked implementation of a list.
 */

package jsjf;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: LinkedList represents a linked implementation of a list.
 */
public abstract class LinkedList<T> implements ListADT<T>, Iterable<T>{
    protected int count;
    protected LinearNode<T> head, tail;
    protected int modCount;
    
    /**
     * Creates an empty list.
     */
    public LinkedList(){
        count = 0;
        head = tail = null;
        modCount = 0;
    }
    
    /**
     * Removes the first element in this list and returns a reference
     * to it. Throws an EmptyCollectionException if the list is empty.
     * @return a reference to the first element of this list
     * @throws EmptyCollectionException if the list is empty
     */
    public T removeFirst() throws EmptyCollectionException
    {
        if(this.isEmpty())
            throw new EmptyCollectionException("LinkedList");
        
        LinearNode<T> headElement = head;
        if(head == null){
            tail = null;
        }else if(this.size() == 1){
            head = tail = null;
        }else{
            /**
             * A list is 1 2 3 4 5 6
             * I delete the node 1
             * head.getElement() is 1
             * head.getNext().getElement() = 2
             * head = head.getNext => head.getElement() = 2
             * the element 1 is deleted
             */
            head = head.getNext();
        }
        count--;
        modCount++;
        //headElement.getElement() is the headElement's value, not address
        return headElement.getElement();
    }
   
    /**
     * Removes the last element in this list and returns a reference
     * to it. Throws an EmptyCollectionException if the list is empty.
     * @return the last element in this list
     * @throws EmptyCollectionException if the list is empty    
     */
    public T removeLast() throws EmptyCollectionException
    {
        if(this.isEmpty())
            throw new EmptyCollectionException("LinkedList");
        
        LinearNode<T> previous = null;
        LinearNode<T> current = head;
        LinearNode<T> tailElement = tail;
        //current.getNext()
        while(current.getNext() != null){
            previous = current;
            current = current.getNext();
        }
        
        /**
         * A list is 1 2 3 4 5 6
         * I delete the node 6
         * previous.getElement() is 5
         * tail.getElement() is 6 
         * tail = previous; // tail.getElement() = 5
         */
        tail = previous;
        if(tail == null) // there is only 1 element in the list
        {
            head = null;
        }else{
            /*
             * tail.setNext(null); element 6 will be deleted
             * the element 6 is deleted
             */
            tail.setNext(null);
        }
        
        count--;
        modCount++;
        //tailElement.getElement() is the tailElement's value, not address
        return tailElement.getElement();
    }
    
    /**
     * Removes the first instance of the specified element from this
     * list and returns a reference to it. Throws an EmptyCollectionException 
     * if the list is empty. Throws a ElementNotFoundException if the 
     * specified element is not found in the list.
     * @param  targetElement the element to be removed from the list
     * @return a reference to the removed element
     * @throws EmptyCollectionException if the list is empty
	 * @throws ElementNotFoundException if the target element is not found
     */
    public T remove(T targetElement) throws EmptyCollectionException, 
            ElementNotFoundException{
        if(this.isEmpty())
            throw new EmptyCollectionException("LinkedList");
        
        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = head;
        
        while(current != null && found == false){
            if(targetElement.equals(current.getElement())){
                found = true;
            }else{
                previous = current;
                current = current.getNext();
            }
        }
        
        if(found == false)
            throw new ElementNotFoundException("LinkedList");
        if(this.size() == 1) // only one element in the list
            head = tail = null;
        else if(current.equals(head)) // target is at the head
        {
            /**
             * A list is 1 2 3 4 5 6
             * I delete the node 1
             * head.getElement() is 1
             * current.getElement() is 1
             * current.getNext().getElement() = 2
             * head = current.getNext => head.getElement() = 2
             * the element 1 is deleted
             */
            head = current.getNext();
        }
        else if(current.equals(tail)) // target is at the tail
        {
            /**
             * A list is 1 2 3 4 5 6
             * I delete the node 6
             * previous.getElement() is 5
             * tail.getElement() is 6
             * tail = previous; // tail.getElement() = 5
             * tail.setNext(null); element 6 will be deleted
             * the element 6 is deleted
             */
            tail = previous;
            tail.setNext(null);
        }else // target is in the middle
        {
            /**
             * A list is 1 2 3 4 5 6
             * I delete the node 3
             * previous.getElement() is 2
             * current.getElement() is 3
             * current.getNext().getElement() is 4
             * previous.setNext(current.getNext()) 
             * equals previous.setNext(4);
             * the element 3 is break and delete
             */
            previous.setNext(current.getNext());
        }
        count--;
        modCount++;
        //current.getElement() is the current's value, not address
        return current.getElement();
    }
    
    /**
     * Returns the first element in this list without removing it. 
     * @return the first element in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public T first() throws EmptyCollectionException{
        if(this.isEmpty()){
            throw new EmptyCollectionException("Linked List");
        }
        return head.getElement();
    }
    
    /**
     * Returns the last element in this list without removing it. 
     * @return the last element in this list  
     * @throws EmptyCollectionException if the list is empty
     */
    public T last() throws EmptyCollectionException{
        if(this.isEmpty()){
            throw new EmptyCollectionException("Linked List");
        }
        return tail.getElement();
    }
    
    /**
     * Returns true if the specified element is found in this list and 
     * false otherwise. Throws an EmptyCollectionException if the list 
     * is empty.
     * @param  targetElement the element that is sought in the list
     * @return true if the element is found in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public boolean contains(T targetElement) throws EmptyCollectionException{
        if(this.isEmpty()){
            throw new EmptyCollectionException("Linked List");
        }
        boolean isContainElement = false;
        LinearNode<T> current = head;
        
        while(current != null && isContainElement == false){
            if(current.getElement().equals(targetElement)){
                isContainElement = true;
            }else{
                current = current.getNext();
            }
        }
        
        return isContainElement;
    }
    
    /**
     * Returns true if this list is empty and false otherwise.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        if(count == 0)
            return true;
        return false;
    }
    
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in the list
     */
    public int size()
    {
        return count;
    }
    
    /**
     * Returns a string representation of this list.
     * @return a string representation of the list    
     */
    public String toString(){
        LinearNode<T> current = head;
        String out = "";
        
        if(this.size() == 0){
            out += "Empty LinkedList.\n";
        }else{
            while(current != null){
                out += current.getElement() + "\t";
                current = current.getNext();
            }
        }
        
        return out;
    }
    
    /**
     * Returns an iterator for the elements in this list. 
     * @return an iterator over the elements of the list
     */
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }
    
    /**
     * LinkedIterator represents an iterator for a linked list of linear nodes.
     */
    private class LinkedListIterator implements Iterator<T>{
        private int iteratorModCount; // the number of elements in the collection
        private LinearNode<T> current; // the current position
        
        /**
         * Sets up this iterator using the specified items.
         * @param collection  the collection the iterator will move over
         * @param size        the integer size of the collection
         */
        public LinkedListIterator(){
            current = head;
            iteratorModCount = modCount;
        }
        
        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException{
            if(iteratorModCount != modCount)
                throw new ConcurrentModificationException();
            return (current != null);
        }
        
        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws ConcurrentModificationException{
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T result = current.getElement();
            current = current.getNext();
            return result;
        }
        
        /**
         * The remove operation is not supported.
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }
    }
}