#include <string.h> 
#include <stdio.h>
#include <stdlib.h> 
#include <stdint.h>
int maxf(int*A, int*p, int*r);
int minf(int*A, int*p, int*r); 
int *B;
   int main(){
   
   B = (int*)malloc(sizeof(int)*10);
   printf("%d\n", maxf(B,0,sizeof(B)-1)); 

   printf("d\n",  minf(B,0,sizeof(B)-1));





   }

   int maxf(int *A, int *p, int *r){
      int q = ((*p)+(*r))/2;
      if( p == r){
         return A[*r];
      }
      if(maxf(A,p,q) > maxf(A,q+1,r)){
         return maxf(A,p,q);
      }else{
         return maxf(A,q+1,r);
      }
   }
   int minf(int *A, int *p, int *r){
      int q = ((*p)+(*r))/2;
      if(p == r){
         return A[*r];
      }
      if(minf(A,p,q) > minf(A,q+1,r)){
         return minf(A,q+1,r);
      }else{ 
         return minf(A,p,q);
  
      }     
   }
