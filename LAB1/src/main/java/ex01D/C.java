package ex01D;

import org.apache.log4j.Logger;

public class C {
	
	protected static Logger log = Logger.getLogger(C.class);
	
	static void method1(int i, StringBuffer s) {
		i++;
		s.append("d");
	}

public static void main(String [] args) {
	int i = 0;
	StringBuffer s = new StringBuffer("abc"); 
	
	log.info("i = " + i);
	log.info("s = " + s);
	
	method1(i, s); System.out.println("i=" + i + ", s=" + s); // i=0, s=abcd 
	}
}