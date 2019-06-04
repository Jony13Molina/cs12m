/*----------------------------------------------------------------------------*/
/* Jonathan Molina jomolina                                                   */  
/* CS12B Lab 6                                                                */
/* IntegerList.java                                                           */
/* Linked List implementation of the IntegerList ADT                          */
/*----------------------------------------------------------------------------*/

public class List<T> implements ListInterface<T> {

   // private  Node class
   private class Node<T> {
      T item;
      Node next;

      Node(T x){
         item = x;
         next = null;
      }
   }

   // Node and numitems for list
   private Node<T> head;     // the first Node
   private int numItems;  // length of list

   // List()
   // constructs the List class 
   public List(){
      head = null;
      numItems = 0;
   }


   // private helper function

   // find()
   // returns a reference to the Node at position index in the list
   private Node find(int item){
      Node<T> N = head;
      for(int i=1; i<item; i++){
      N = N.next;
    }
      return N;
   }


   // ADT operations

   // isEmpty()
   // pre: none
   // post: returns true if this IntgerList is empty, false otherwise
   public boolean isEmpty(){
      return(numItems == 0);
   }

   // size()
   // pre: none
   // post: returns the number of elements in this IntegerList
   public int size() {
      return numItems;
   }

   // get()
   // pre: 1 <= index <= size()
   // post: returns item at position index in this IntegerList
   public T get(int index) throws ListIndexOutOfBoundsException {
      
      if( index<1 || index>numItems ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList Error: get() called on invalid index: " + index);
      }
      Node<T> N = find(index);
      return N.item;
   }

   // add()
   // inserts newItem into this IntegerList at position index
   // pre: 1 <= index <= size()+1
   // post: !isEmpty(), items to the right of newItem are renumbered
   public void add(int index, T newItem) 
      throws ListIndexOutOfBoundsException{
      
      if( index<1 || index>(numItems+1) ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList Error: add() called on invalid index: " + index);
      }
      if(index==1){
         Node H = new Node<T>(newItem);
         H.next = head;
         head = H;
      }else{
         Node Pre = find(index-1); // at this point index >= 2
         Node Temp = Pre.next;
         Pre.next = new Node(newItem);
         Pre = Pre.next;
         Pre.next = Temp;
      }
      numItems++;
   }

   // remove()
   // deletes item at position index from this IntegerList
   // pre: 1 <= index <= size()
   // post: items to the right of deleted item are renumbered
   public void remove(int index)
      throws ListIndexOutOfBoundsException{
      if( index<1 || index>numItems ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList Error: remove() called on invalid index: " + index);
      }
      if(index==1){
         Node H = head;
         head = head.next;
         H.next = null;
      }else{
         Node Pre = find(index-1);
         Node H = Pre.next;
         Pre.next = H.next;
         H.next = null;
      }
      numItems--;
   }

   // removeAll()
   // pre: none
   // post: isEmpty()
   public void removeAll(){
      head = null;
      numItems = 0;
   }

   // toString()
   // pre: none
   // post:  prints current state to stdout
   // Overrides Object's toString() method
   public String toString(){
      StringBuffer sb = new StringBuffer();
      

      for(Node N = head ; N!=null; N=N.next){ 
      sb.append(N.item).append(" ");
      }
      return new String(sb);
   }

   
   
}
