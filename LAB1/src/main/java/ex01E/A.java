package ex01E;

import org.apache.log4j.Logger;

class A {
	
	protected static Logger log = Logger.getLogger(A.class);
	
	int x;

	void m() {
		System.out.println("Je suis dans la méthode m d'une instance de A");
	}
}

class B extends A {
	int x;

	void m() {
		System.out.println("Je suis dans la méthode m d'une instance de B");
	}
}

class C extends B {
	int x, a;

	void m() { 
		System.out.println("Je suis dans la méthode m d'une instance de C");
		}

	void test() { 
		a = super.x;
		log.debug("super.x = " + a);
		log.debug("x = " + x);
		
		a = ((B)this).x;
		log.debug("((B)this).x = " + a);
		
		a = ((A)this).x;
		log.debug("((A)this).x = " + a);
		
		super.m();
		((B)this).m(); // (1) 
		}
	
	public static void main(String[] args) {
		C c = new C();
		c.test();
	}
}