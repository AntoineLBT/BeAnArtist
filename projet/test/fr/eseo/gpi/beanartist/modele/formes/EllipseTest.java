package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

public class EllipseTest {

	static final double EPSYLON = 1e-7;
	@Test
	public void ConstructeurTest() {
		
		Ellipse elli = new Ellipse(new Point(10,10), 20, 30);
		assertEquals("Test du constructeur", 20,elli.getLargeur(),EPSYLON);
		assertEquals("Test du constructeur", 30,elli.getHauteur(),EPSYLON);
		assertEquals("Test du constructeur", 10,elli.getPosition().getX(),EPSYLON);
		assertEquals("Test du constructeur", 10,elli.getPosition().getY(),EPSYLON);
	}

}
