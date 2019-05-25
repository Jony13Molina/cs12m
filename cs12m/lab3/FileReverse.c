/*
*Jonathan Molina 
*jomolina
*Lab 3 CS12M
*2/26/2015
*Program prints the words backwards 
*
*/
#include<stdio.h>/*imports utilitis we might use*/
#include<stdlib.h>
#include<string.h>
void stringReverse(char* s);

int main(int argc, char* argv[]){
FILE*in;/* file handle for input */
 FILE*out;  /* filehandle for output*/
char word[256]; /* char array to store words from input file *//* check command line for correct number of arguments */


if( argc != 3 ){
printf("Usage: %s <input file> <output file>\n", argv[0]);
exit(EXIT_FAILURE);}
/* open input file for reading */
in = fopen(argv[1], "r");
if( in==NULL ){
printf("Unable to read from file %s\n", argv[1]);
exit(EXIT_FAILURE);
}
/* open output file for writing */
out = fopen(argv[2], "w");
if( out==NULL ){
printf("Unable to write to file %s\n", argv[2]);
exit(EXIT_FAILURE);
}/* read wordsfrominput file, print on separate lines to output file*/
while(fscanf(in, " %s", word)!=EOF){
stringReverse(word);
fprintf(out, "%s\n", word);
}/* close input and output files */
fclose(in);
fclose(out);
return(EXIT_SUCCESS);
}/*closes main */


/*method that reverses the words by swapping indices at i and j*/
void stringReverse(char* s){
int i, j, vart;
i = 0;
j = ((strlen(s))-1);
while(j >=i ){
if((strlen(s)) >= 0){
vart = s[i];
s[i] = s[j];
s[j] = vart;
}
i++;
j--;

 	

    
   }
 } /*closes stringReverse method */  
