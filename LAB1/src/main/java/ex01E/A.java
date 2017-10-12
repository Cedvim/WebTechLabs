package ex01E;

import org.apache.log4j.Logger;

class A {
	
	//Définition des logs
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
		
		//"super" appelle les variables de la classe mère
		a = super.x; //Ici seul C est instanciée, donc "super" réfère à B
		log.debug("super.x = " + a);
		log.debug("x = " + x);
		
		//"((B)this)" fait référence à B
		a = ((B)this).x;
		log.debug("((B)this).x = " + a);
		
		//"((A)this)" fait référence à A
		a = ((A)this).x;
		log.debug("((A)this).x = " + a);
		
		System.out.println("");
		log.info("super.m() returns :");
		super.m();
		
		System.out.println("");
		log.info("((B)this).m() returns :");
		((B)this).m(); // (1)
		}
	
	public static void main(String[] args) {
		C c = new C();
		c.test();
	}
}