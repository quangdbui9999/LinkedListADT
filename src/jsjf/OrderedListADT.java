/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: OrderedListADT defines the interface to an ordered 
 * list collection. Only Comparable elements are stored, kept in 
 * the order determined by the inherent relationship among the elements.
 */

package jsjf;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: OrderedListADT defines the interface to an ordered 
 * list collection. Only Comparable elements are stored, kept in 
 * the order determined by the inherent relationship among the elements.
 */
public interface OrderedListADT<T> extends ListADT<T>{
    /**
     * Adds the specified element to this list at the proper location
     * @param element the element to be added to this list
     */
    public void add(T element);
}