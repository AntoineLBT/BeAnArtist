package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CercleTest {

	static final double EPSYLON = 1e-7;
	@Test
	public void ConstructeurTest() {
		
		Cercle cercle = new Cercle(new Point(2,5), 20);
		assertEquals("Test du constructeur", 20,cercle.getLargeur(),EPSYLON);
		assertEquals("Test du constructeur", 20,cercle.getHauteur(),EPSYLON);
		assertEquals("Test du constructeur", 2,cercle.getPosition().getX(),EPSYLON);
		assertEquals("Test du constructeur", 5,cercle.getPosition().getY(),EPSYLON);
	}

}
