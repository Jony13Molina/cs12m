/*
*Jonathan Molina 
*jomolina
*CS12B
* Lab7 
*
*
*this file implements methods from DictionaryInterface
*
*
*
*
*
*
*
*
* 
*/ 









import java.io.*;
//import java.util.Scanner;
import java.util.*;



class Dictionary implements DictionaryInterface{
       
        

       class Node{
		String key, value;
		Node next, left, right;
		Node(String pairA, String pairB){
			key = pairA;
			value = pairB; 
	
                         left = null;
                         right = null;

	    }
     }
    
        
	public Node head;// makes 
        private int numPairs;
	
       //private methods helper functions
       private Node findKey(Node R, String k){
      
      if(R == null || k.compareTo(R.key) == 0){ 
      return R;
      }
      if( (k.compareTo(R.key)) < 0){ 
      return findKey(R.left, k);
      }
      else{ // strcmp(k, R->key)>0
      return findKey(R.right, k);
      }   							                                                               
      }//closes findkey
      
private  Node findParent(Node N, Node R){
   Node P =null;
   if( N!=R ){
      P = R;
      while( P.left != N && P.right!= N ){
         if(N.key.compareTo(P.key)< 0){
            P = P.left;
         }else{
            P = P.right;
          }
      }
   }
   return P;
}

private Node findLeftmost(Node R){
  Node L = R; 
   if( L !=  null ){
     for( L = R ; L.left != null; L = L.left){
     }
    } 
     return L;
    }  

private String printInOrder( Node R){
  /* if( R != null ){
      //StringBuffer sb = new StringBuffer();
      b += printInOrder(b, R.left);
     b += R.key +" "+ R.value +"\n";
     b += printInOrder( b, R.right);
   }
   return b;*/

if( R!= null ){
      printInOrder( R.left);
      System.out.printf( "%s %s\n", R.key, R.value);
      printInOrder( R.right);
   }


return "";
}
private void  deleteAll(Node N){
   if( N != null ){
      deleteAll(N.left);
      deleteAll(N.right);
      
   }
} 
//Public Methods//
public Dictionary(){
   
 
   head  = null;
   numPairs = 0;
}
public boolean isEmpty(){
return(numPairs == 0);

}
public int size(){
return numPairs;
}
public String lookup(String key){
 
if(findKey(head, key)  == null){
  return null;
}else{
 Node H = findKey(head, key);
  return( H == null? null: H.value);
}
}
public void insert( String key, String value)
	     throws KeyCollisionException{
Node A, N , B;
     if(lookup(key) != null ){
       throw new KeyCollisionException("Cannot insert duplicate keys");
     }
   N = new Node(key, value);
   B = null;
   A = head;
   while( A != null ){
      B = A;
      if(key.compareTo(A.key)< 0){ 
      A = A.left;
      }else{
      A = A.right;
      }
   }
   if( B == null ){
    head = N;
   }else if(key.compareTo(B.key) < 0){
    B.left = N;
   }else{ 
   B.right = N;
   }
   numPairs++;
   
    
  

}
public void delete(String key) throws KeyNotFoundException{
   Node N, P, S;
   N = findKey(head, key);
   if( lookup(key) == null ){
      throw new KeyNotFoundException("Cannot Delete Non-existent key");
   }
   if( N.left== null && N.right==null ){
      if( N == head ){
         head = null;
      }else{
         P = findParent(N, head);
         if( P.right== N ) 
         P.right = null;
         else 
         P.left = null;
        
      }
   }else if( N.right == null ){
      if( N == head ){
         head  = N.left;
         
      }else{
         P = findParent(N, head);
         if( P.right==N ) P.right = N.left;
         else P.left = N.left;
        
      }
   }else if( N.left == null ){
      if( N == head ){
         head = N.right;
        
      }else{
         P = findParent(N, head);
         if( P.right==N ) P.right = N.right;
         else P.left = N.right;
         
      }
   }else{  // N->left!=NULL && N->right!=NULL
      S = findLeftmost(N.right);
      N.key = S.key;
      N.value = S.value;
      P = findParent(S, N);
      if( P.right==S ) P.right = S.right;
      else P.left = S.right;
      
   }
   numPairs--;
}

public void makeEmpty(){	
         head = null;
         numPairs = 0;
}	
public String  toString(){
 Node H = head;
 String s = ""; 
return printInOrder( H );
    
    
   
}  

}
