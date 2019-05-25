/*================================================*/
/*Jonathan Molina                                 */  
/*jomolina                                        */
/*Lab 1 CS12M                                     */  
/*4/3/2015                                        */
/*Program prints a different more cooler greeting */
/*================================================*/   

import java.util.*;// imports utilities 



//this is the main class of the program
class HelloUser2{
//this is the main method of the class that prints a greeting 
	public static void main( String[] args ){
		String userName = System.getProperty("user.name");
		String os = System.getProperty("os.name");
		String osVer = System.getProperty("os.version");
		String jre = System.getProperty("java.runtime.name");
		String jreVer = System.getProperty("java.runtime.version");
		String jvm = System.getProperty("java.vm.name");
		String jvmVer = System.getProperty("java.vm.version");
		String javaHome = System.getProperty("java.home");
		long freemem = Runtime.getRuntime().freeMemory();
		long time = System.currentTimeMillis();
		System.out.println("Good Morning, Evening or Whatever time in the day it is "+userName);
		System.out.println("This Is The Operating System: "+os+" "+osVer);
		System.out.println("Runtime environment: "+jre+" "+jreVer);
		System.out.println("Virtual machine: "+jvm+" "+jvmVer);
		System.out.println("Java home directory: "+javaHome);
		System.out.println("Free memory: "+freemem+" bytes");
		System.out.printf("Yo This Is The Time: %tc.%n", time);
	}// closing bracket of the main method inside the main class
}//closes the bracket of the main class

