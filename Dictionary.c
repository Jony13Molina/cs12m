/*Joanthan Molina
*CS12B
*Lab 5
*jomolina
*
*
*Program looks up words contain in an array
*deletes stuff from array
*adds stuff to list 
*/ 
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"


//private types 
typedef struct NodeObj{
     char* key;
     char* value;
     struct NodeObj* next;
}NodeObj;

//Node 
typedef NodeObj* Node;

//newNode()
//contructor of NodeType
Node newNode(char* A, char* B){
Node Al = malloc(sizeof(NodeObj));
assert(Al != NULL);
Al->key = A;
Al->value = B;
Al->next = NULL;
return(Al);
}

//freenode 
//destructs Node
void freeNode(Node *pAl){
   if(pAl != NULL && *pAl != NULL){
   free(*pAl);
   *pAl = NULL;
   }

}
//DictionaryObj array
typedef struct DictionaryObj{
  Node head;
  int  numItems;
}DictionaryObj;
//a reference of a Dictionary obj
typedef DictionaryObj* Dictionary; 
//helper function for Dictionary                              
 Node findKey(Dictionary D, char* key){
     Node Al = D->head;
      for(; Al!= NULL; Al = Al->next){
	    if(strcmp(Al->key, key)==0){

                return Al;
            } 
    }	
    return NULL;        
}
//public functions// 
//constructs Dictionary obj
Dictionary newDictionary(void){
   Dictionary D = malloc(sizeof(DictionaryObj));
   assert(D != NULL);
   D->head = NULL;
   D->numItems = 0;
   return D;
}
//free Dictionary
//destructor for Dictionary
void freeDictionary(Dictionary* pD){
   if(pD != NULL && *pD != NULL){
      if( !isEmpty(*pD)) 
      makeEmpty(*pD);
      free(*pD);
      *pD = NULL;
    
   }
}
//isEmpty()
//returns 1(true) if D is empty, 0 (false) otherwise
//pre: none
int isEmpty(Dictionary D){
  if(D == NULL){
    fprintf(stderr, "Stack Error: Calling isEmpty() on Null Dictionary Reference\n");
    exit(EXIT_FAILURE);
   }
   return(D->numItems==0);
}
//size()
//returns the size of the list
//pre: None
int size(Dictionary D){
return(D->numItems);
}
//looks up word
char* lookup(Dictionary D, char* k){
if(findKey(D, k)==NULL){
    return NULL;
  }else{
    Node Al;
    Al = findKey(D, k);
    return Al->value;
  }
}

//inserts keys and values 
void insert(Dictionary D, char* k, char* v){
Node Al = D->head;
if( D == NULL){
   fprintf(stderr, "Dictionary Error: Calling Insert on Null Dictionary reference\n");
   exit(EXIT_FAILURE);
  }else if(lookup(D,k)!=NULL){
    fprintf(stderr, "Dictionary Error: Inserting Duplicate key\n");
    exit(EXIT_FAILURE);
  }else{
    if(D->head == NULL){
      Al = newNode(k,v);
      D->head = Al;
      D->numItems++;
    }else{
      while(Al != NULL){
        if( Al->next == NULL){
          break;
        }
        Al = Al->next;
      }
      Al->next = newNode(k,v);
      D->numItems++;
    }
  }
}
//deletes keys  
void delete(Dictionary D, char* k){
   Node Al = D->head;
   if( D == NULL ){
      fprintf(stderr, "Dictionary Error: calling delete() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }else if( lookup(D, k) == NULL ){
      fprintf(stderr, "Dictionary Error: cannot delete none existing key\n");
      exit(EXIT_FAILURE);
    }else{
    if(D->numItems<=1){;
      freeNode( &Al);
    }else{
      if( Al->key == k){
        Node P = D->head;
        D->head = Al->next;
        D->numItems--;
        freeNode(&P);
      }else{
        while(Al->next->key != k){
          Al = Al->next;
        }
        Node P =  Al->next;
        Al->next = Al->next->next;
        freeNode(&P);
        D->numItems--;
      }
    }
  }
}
//returns everything to an empty state
void makeEmpty(Dictionary D){
 D->numItems = 0;
 freeNode(&D->head);
 }

//prints the values and keys 
void printDictionary(FILE* out, Dictionary D){

Node Al = D->head;
  while( Al != NULL){
    fprintf(out,"%s %s \n",Al->key,Al->value);
    Al = Al->next;
  
}
}











  
