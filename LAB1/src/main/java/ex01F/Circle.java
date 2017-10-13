package ex01F;

import org.apache.log4j.Logger;

public class Circle {
	
	//Définition des logs
	protected static Logger log = Logger.getLogger(Circle.class);
	
	int x;
	int y;
	int radius;

	//Constructeur de cercle
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	//La méthode toString() est redéfinie
	public String toString() {
		
		log.debug("toString() is called on Circle(" + this.x + ", " + this.y + ", " + this.radius + ")");
		
		return (String.format("Circle with center (%d,%d) and radius %d (Perimter is %,.2f)",
				this.x, this.y,
				this.radius, (2 * java.lang.Math.PI * this.radius)));
	}
}