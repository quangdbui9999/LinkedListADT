/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: LinearNode represents a node in a linked list.
 */

package jsjf;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: LinearNode represents a node in a linked list.
 */
public class LinearNode<E> {
    private E element;
    private LinearNode<E> next;
    
    /**
     * Creates an empty node.
     */
    public LinearNode(){
        element = null;
        next = null;
    }
    
    /**
     * Creates a node storing the specified element.
     *
     * @param elem the element to be stored within the new node
     */
    public LinearNode(E elem){
        element = elem;
        next = null;
    }
    
    /**
     * Returns the node that follows this one.
     * @return the node that follows the current one
     */
    public LinearNode<E> getNext()
    {
        return next;
    }
    
    /**
     * Sets the node that follows this one.
     * @param node the node to be set to follow the current one
     */
    public void setNext(LinearNode<E> node)
    {
        next = node;
    }
    
    /**
     * Returns the element stored in this node.
     * @return the element stored in this node
     */
    public E getElement()
    {
        return element;
    }
    
    /**
     * Sets the element stored in this node.
     * @param elem the element to be stored in this node
     */
    public void setElement(E elem)
    {
        element = elem;
    }
}