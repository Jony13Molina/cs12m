/*=================================================================*/
/*Jonathan Molina                                                  */
/*CS12B Lab6                                                       */  
/*jomolina                                                         */
/*Test file for the program                                        */
/*this tests the functionality of the program.                     */
/*                                                                 */
/*                                                                 */  
/*=================================================================*/


class ListTest class{
public static void main(String[] args){
      List<String> A = new List<String>();
      List<String> B = new List<String>();
      List<List<String>> C = new List<List<String>>();
      int i, j, k;

//tests the insert function
//prints out of order
/*      A.add(3, "bad");
      A.add(5, "twin");
      A.add(7, "dog");
      B.add(9, "tent");
      B.add(11, "sandwich");
*/



      //System.out.println("A: "+A);
      //System.out.println("B: "+B);
      //System.out.println("C: "+C);
//checks if the equals function works
    /*  System.out.println("A.equals(A) is "+A.equals(B));
      System.out.println("A.equals(B) is "+A.equals(A));
      System.out.println("A.equals(C) is "+A.equals(C));

*/ //error gets thrown 
//size seems to work
      System.out.println("A.size() is "+A.size());
      System.out.println("B.size() is "+B.size());
      System.out.println("C.size() is "+C.size());
//exceptions work properly
    /*
     try{
         System.out.println(A.get(200));
      }catch(ListIndexOutOfBoundsException e){
         System.out.println("Caught Exception: ");
         System.out.println(e);
         System.out.println("Continuing without interuption");
      }
     */
//checks what is at the indicated indices A.get B.get and so on
      System.out.println("A.get(2) is "+A.get(2));
      System.out.println("C.get(1) is "+C.get(1));  



//new test for the insert function
      A.add(1, "one");
      A.add(2, "two");
      A.add(3, "three");
      B.add(1, "ten");
      B.add(2, "twenty");
      B.add(3, "thirty");
      C.add(1, A);
      C.add(2, B);

      System.out.println("A: "+A);
     
//things get printed in order
//new test for the equals function
//
      System.out.println("A.equals(A) is "+A.equals(A));
      System.out.println("A.equals(B) is "+A.equals(B));
      System.out.println("A.equals(C) is "+A.equals(C));
      System.out.println("A.size() is "+A.size());
      System.out.println("B.size() is "+B.size());
      System.out.println("C.size() is "+C.size());



}































