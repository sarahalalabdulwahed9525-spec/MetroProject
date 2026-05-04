/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package riyadhmetroproject;

public class Node1<E> {

    private E element;
    private Node1<E> next;
    
      public Node1(E element) {
        this.element = element;
 
    }
    public Node1(E element, Node1<E> next) {
        this.element = element;
        this.next = next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(Node1<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node1<E> getNext() {
        return next;
    }
}


