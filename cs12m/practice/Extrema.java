import java.util.*;



class Extrema{
      
     public static void main(String args []){
          int [] B = {-1,2,61,-13,9,2,-3,-2,11,5,7};
          System.out.println("Max =" + MaxFind(B, 0, B.length-1));
          System.out.println("Min =" + MinFind(B, 0, B.length-1));
     } 

     static int MaxFind(int A[], int p, int r){
          int q = (p+r)/2;
          if( p == r){
             return A[r];
          }
          if(MaxFind(A,p,q) > MaxFind(A,q+1,r)){
             return MaxFind(A,p,q);
          }else{
             return MaxFind(A,q+1,r);
          }
          
          
    }
    static int MinFind(int A[], int p, int r){
          int q = (p+r)/2;
          if(p == r){
             return A[r];
          }
          if(MinFind(A,p,q) > MinFind(A,q+1,r)){
              return MinFind(A,q+1,r);
          }else{ 
              return MinFind(A,p,q);
  
          }   
          
   } 






}
