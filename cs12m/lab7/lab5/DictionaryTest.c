/*Jonathan Molina
 *CS12M Lab 5
 *jomolina
 *checks the methods that will be used by dictionaryclient
 *
 *
*/




#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "Dictionary.h"

#define MAX_LEN 180

int main(int argc, char* argv[]){
   Dictionary A = newDictionary();
   char* k;
   char* v;
   //first test for insertions of keys and values 
   //char* word1[] = {"one","two","three","four","five","six","seven"};
   //char* word2[] = {"family","soccer","ufc","cookies","anime","boxing","pie"};
   // for(i=0; i<7; i++){//printed out of order
     // insert(A, word1[i], word2[i]);
  // }
  //Second test for insertion of keys and values
   char* word1[] = {"one","two","three","four","five","six","seven"};
   char* word2[] = {"foo","bar","blah","galumph","happy","sad","blue"};
   int i;//printed in order with change in insert based off dictionary.java

   for(i=0; i<7; i++){
      insert(A, word1[i], word2[i]);
   }
   //prints in order 
   //printDictionary(stdout, A);// keys and values printed out of order
   //delete(A, "one");//deletion does not work properly
   //delete(A, "three");//deletion works properly with new method based Dictionary.java
   //delete(A, "seven");
  
   //test foor found not found 
   //for(i=0; i<7; i++){
     // k = word1[i];
     // v = lookup(A, k);
     // printf("key=\"%s\" %s\"%s\"\n", k, (v==NULL?"not found ":"value="), v);
   //}//does not work properly 
    

//make empty works
   printf("%d\n", size(A));
   printDictionary(stdout, A); 
   printf("%s\n", (isEmpty(A)?"true":"false")); 
   makeEmpty(A);
   printf("%s\n", (isEmpty(A)?"true":"false"));

//second test for found not found 
for(i=0; i<7; i++){
      k = word1[i];
      v = lookup(A, k);
printf("key=\"%s\" %s\"%s\"\n", k, (v==NULL?"not found ":"value="), v);


//checks exceptions 
 // delete(A, "one");  // error: key not found
 // insert(A, "five", "glow"); // error: key collision

//second test for deletion
delete(A, "one");
delete(A, "three");
delete(A, "seven");

//checks if makeEmpty still works 
 printf("%s\n", (isEmpty(A)?"true":"false"));
 printf("%d\n", size(A));
 makeEmpty(A);
 printf("%s\n", (isEmpty(A)?"true":"false"));






   }
   }
