package riyadhmetroproject;




// instance variables of the SinglyLinkedList
public class SinglyLinkedList<E> {

    private Node1<E> head;
    private Node1<E> tail;
    private Node1<E> curr;
    private int size;

    public SinglyLinkedList() {

        head = null;
        tail = null;
        curr=null;
        size = 0;
    }

// access methods
    public int size() {//O(1)
        return size;
    }

    public boolean isEmpty() {//O(1)
        return size == 0;
    }

    public E first() { //O(1)
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() { //O(1)
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

// update methods
    public void addFirst(E e) { //O(1)
        head = new Node1<>(e, head); 
        if (size == 0) {
            tail = head; 
        }
        size++;
    }

    
    public void addLast(E e) { //O(1)
        Node1<E> newest = new Node1<>(e, null); 
        if (isEmpty()) {
            head = newest; 
        } 
        else 
        {
            tail.setNext(newest); 
        }
        tail = newest; 
        size++;
    }

    
    public E removeFirst() { //O(1)
        if (isEmpty()) {
            return null; 
        }
        E answer = head.getElement();
        head = head.getNext(); 
        size--;
        if (size == 0) {
            tail = null; 
        }
        return answer;
    }
    
    
    
    
    
  public E removeLast() { //O(n)
        if (isEmpty()) {
            return null; 
        }
        E answer = tail.getElement();
        
        if(head==tail)
        {head=tail=null;
               }
        else        {
        curr=head;
        while(curr.getNext()!=tail)
        curr=curr.getNext();
        tail=curr;
        curr.setNext(null);
               
        }
        size--;
        return answer;
    }
  
  public void add(E element, int index)//O(n)
    {
        if (index < 0 || index > size) {
            System.out.println("Out of bound!");
            return;
        }
        Node1<E> newest = new Node1<E>(element, null);
        if (index == 0) 
        {
            newest.setNext(head);
            head = newest;
            if (tail == null) {
                tail = head;
            }
        } else // add the middle 
        {
            curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            newest.setNext(curr.getNext());
            curr.setNext(newest);
            if (tail == curr) {
                tail = tail.getNext();
            }
        }
        size++;
    }

    //removing node at index i
    public E remove(int index) {//O(n)
        if (index < 0 || index >= size) {
            System.out.println("Out of bound!");
            return null;
        }
        E element;
        if (index == 0) 
        {
            element = head.getElement();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else 
        {
            curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            element =(E) curr.getNext().getElement();
            if (tail == curr.getNext()) {
                tail = curr;
            }
            curr.setNext(curr.getNext().getNext());
        }

        size--;
        return element;
    }
    
    

      public void print() {//O(n)
       if(head==null)
           return;
       
        curr = head;
        while (curr != null) {
            System.out.println(curr.getElement());
            curr = curr.getNext();
        }
}
      
      public void moveToStart() {//O(1)
        curr = head;
    }
      
    public void next() {//O(1)
        if (curr != tail) {
            curr = curr.getNext();
        }
    }
    

    public void moveToEnd() {//O(1)
        curr = tail;
    }

    

    public E getValue() {//O(1)
        return curr.getElement();
    }

    //return the postion of current element
    public int CurrPos() {//O(n)
        Node1<E> temp = head;
        int i = 0;
        while (temp != curr) {
            temp = temp.getNext();
            i++;
        }
        return i;
    }

    
    //move curr to postion 
    public void moveToPos(int pos) {//O(n)
        if (pos < 0 || pos >= size) {
            System.out.println("Position out of range!");
            return;
        } else {
            curr = head;
            for (int i = 0; i < pos; i++) {
                curr = curr.getNext();
            }
        }
    }

    
    

  
    
}
