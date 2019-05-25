/*Jonathan Molina 
 * CS12M Lab 4
 *jomolina
 *program is suppose to read in lines and tell how many 
 *numbers and white spaces and other chars the file has
 *
 *
 *
 *
*/






#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<assert.h>
#include<string.h>
#define MAX_STRING_LENGTH 100

// function prototype 
// void extract_alpha_num(char* s, char* a);
// void extractCaps(char* s , char* caps);
 void extract_chars(char* s, char* a, char* d, char* p, char* w );
 //function main which takes command line arguments 
 int main(int argc, char* argv[]){
          FILE* in;        // handle for input file                  
          FILE* out;       // handle for output file                 
          //char* line;      // string holding input line                           
          char* Num; // string holding all alpha-numeric chars 
          char* word;     // dynamically allocated string holding input word   
          char* WordsC;  // dynamically allocated string holding caps in word 
          char* Pchars;
          char* WhiteSp;                 
          int lineC;
          
	   if( argc != 3 ){
		   printf("Usage: %s input-file output-file\n", argv[0]);
		   exit(EXIT_FAILURE);
	   }

           // open input file for reading 
	   if( (in=fopen(argv[1], "r"))==NULL ){
		   printf("Unable to read from file %s\n", argv[1]);
		   exit(EXIT_FAILURE);
	   }

            // open output file for writing 
	if( (out=fopen(argv[2], "w"))==NULL ){
            printf("Unable to write to file %s\n", argv[2]);
		   exit(EXIT_FAILURE);                                                  }
             
    // allocate strings word and capsWord from heap memory
    word = calloc(MAX_STRING_LENGTH+1, sizeof(char)); 
    WordsC = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
    Num = calloc(MAX_STRING_LENGTH+1, sizeof(char));
    Pchars = calloc(MAX_STRING_LENGTH+1, sizeof(char));
    WhiteSp = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   // assert( word!=NULL &&WordsC!=NULL );
   lineC = 1;

    while(fgets(word,MAX_STRING_LENGTH, in) != NULL){
    extract_chars(word, WordsC, Num, Pchars, WhiteSp);
    
    fprintf(out,"line% d contains: \n", lineC);
    fprintf(out,"%lu contains Alphabetic Chars: %s\n", strlen(WordsC), WordsC);
    fprintf(out,"%lu contains Numeric Chars:  %s\n", strlen(Num), Num);
    fprintf(out,"%lu contains Punctuation Chaars: %s\n", strlen(Pchars), Pchars);    
    fprintf(out,"%lu contains White Space Chars: %s\n", strlen(WhiteSp),WhiteSp);
    lineC++;
    }
    
                                                                                       
          // free heap memory      
           free(word);
           free(WordsC);                                                                                                                                  
           free(Num);
           free(Pchars);
           free(WhiteSp);     
          // close input and output files 
          fclose(in);
          fclose(out);
          return EXIT_SUCCESS;  
        }     
//method inly works with two parameters  
     void extract_chars( char* s, char* a, char* d, char* p, char* w){
      int i = 0, j = 0, k = 0, L = 0, m = 0;
      while(s[i] != '\0' && i < MAX_STRING_LENGTH){
       
      if(isalpha((int)s[i])){
      a[j++] = s[i];
      }
      if(isdigit((int)s[i])){
      d[k++] = s[i];
      }
      if(ispunct((int)s[i])){
      p[L++] = s[i];
      }
      if(isspace((int)s[i])){
      w[m++] = s[i];
      }
      i++;
     
      }
      a[j] = '\0';
      d[k] = '\0';
      p[L] = '\0';
      w[m] = '\0';


        
        
       }  
                                                                                                                                                                                                              
