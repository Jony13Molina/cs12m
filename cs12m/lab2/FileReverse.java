/*========================================*/
/*Jonathan Molina                         */
/*jomolina                                */
/*Lab 2 : FileReverse                     */
/*CS12M                                   */
/*Description: This programs takes in a   */
/* file of words and then prints words    */ 
/* backwards.                             */
/*                                        */
/*========================================*/  




//import all utilities we might use 
import java.io.*;
import java.util.Scanner;
import java.lang.*;

class FileReverse{
	static  String[] token;
	static  Scanner in;// takes in input 
	static  String  h;// takes care of the first character of the string Token
	static  String  e;//takes care of the second character
	static  String  f;//takes care of 3rd character 
	static  String  g;//takes care of 4th character
	static  String  r;//this is all the characters added together
	public  static void main(String[] args) throws IOException{
		in  = null;
		PrintWriter out = null;
		String line = null;
		String b = null;
		token = null;//array of strings stores the words  
		int i, n;

		//check command line for arguements
		if(args.length < 2){
			System.out.println("Usage: FileToken INFILE and OUTFILE");
			System.exit(1);
		}

		//open file 
		in = new Scanner( new File(args[0])); 
		out = new PrintWriter(new FileWriter(args[1]));

		//read lines from in, extract and print tokens from each line 
	
                 while(in.hasNextLine()){
			//trim leading and trailing space
			//split works on blank lines
			line = in.nextLine().trim()+ " ";

			//split line around white space
			token = line.split("\\s+");

			//print out tokens 
			n = token.length;
			for( i = 0; i < n ; i++){
				out.println(stringReverse(token[i], n));
			}
		}
		in.close();
		out.close();
	}//closes main method
	public static String  stringReverse(String s, int n){
	int i;

		char a, b, c, d;//characters that break up the words into parts
		n = s.length();//n is the length of the words 
		i = (n -1);//the last word 
		if(i >= 0){
			a = s.charAt(i);//gets last word
			h = Character.toString(a);//converts word to string
		}


		i = (n - 2);//the second to last word        
		if(i >= 0){
			b = s.charAt(i);//gets 2nd to to last word
			e = Character.toString(b);
		}
		i = (n-3);//third to last word
                if(i >= 0){
			c = s.charAt(i);
			f = Character.toString(c);
		} 
		i = (n-4);//4th to last word
                if( i >= 0){
			d = s.charAt(i);
			g = Character.toString(d);

		}
//checks the the length of words so that it returns words that have length 1,2,3  
		if(s.length() == 1){//checks if word has lenght 1 
			return h;//returns 1 char 
		}else if( s.length() == 2){//checks if word has length 2
			String reverse;
			reverse = h+e;//returns 2 chars
			return reverse;//re
		}else if( s.length() == 3){// checks if word has length 3
			String reverse2 = h+e+f;
			return reverse2;//returns only 3 chars
		}
		r = (h+e+f+g);// if a word is length 4 then all the four characters are returned 

		return r; //returns all the four chars 


	}//closes the method for reverse
}//closes the class

