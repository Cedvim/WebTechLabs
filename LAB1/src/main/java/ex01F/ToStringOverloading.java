package ex01F;

import org.apache.log4j.Logger;

public class ToStringOverloading {
	
	//Définition des logs
	protected static Logger log = Logger.getLogger(ToStringOverloading.class);
	
	public static void main(String[] args) {
		//Création de deux cercles
		Circle c1 = new Circle(0, 0, 5);
		Circle c2 = new Circle(0, 0, 3);
		
		//On affiche c1
		System.out.println("C1 => " + c1);
		System.out.println("");
		
		//Affichage des valeurs de tous les cercles
		log.info("Value of circles :");
		log.info("c1 = " + c1);
		log.info("c2 = " + c2);
	}
}