package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {
	
	static final double EPSYLON = 1e-7;
	@Test
	public void ConstructeurTest() {
		
		Rectangle rec = new Rectangle(new Point(10,10), 20, -30);
		assertEquals("Test du constructeur", 20,rec.getLargeur(),EPSYLON);
		assertEquals("Test du constructeur", -30,rec.getHauteur(),EPSYLON);
		assertEquals("Test du constructeur", 10,rec.getPosition().getX(),EPSYLON);
		assertEquals("Test du constructeur", 10,rec.getPosition().getY(),EPSYLON);
	}

	
	
	/**
	 * try{
	 * carre.setLargeur(-49);
	  fail("largeur nef");
	}catch(IllegalArgumentException exception){
		assert(exception.getMessage().contains())
	}
	 
	 */
	  
		
}
