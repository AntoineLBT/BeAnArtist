package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarreTest {

	static final double EPSYLON = 1e-7;
	@Test
	public void ConstructeurTest1() {
		
		Carre carre = new Carre(new Point(10,10),30);
		assertEquals("Test du constructeur complet", 30,carre.getLargeur(),EPSYLON);
		assertEquals("Test du constructeur complet", 30,carre.getHauteur(),EPSYLON);
		assertEquals("Test du constructeur complet", 10,carre.getPosition().getX(),EPSYLON);
		assertEquals("Test du constructeur complet", 10,carre.getPosition().getY(),EPSYLON);
	}
	@Test
	public void ConstructeurTest2(){
		Carre carre = new Carre();
		assertEquals("Test du constructeur vide", 100,carre.getHauteur(),EPSYLON);
	}
	@Test
	public void ConstructeurTest3(){
		Carre carre = new Carre(new Point(44.671,75.456));
		assertEquals("Test du constructeur point",44.671,carre.getPosition().getX(),EPSYLON);
		assertEquals("Test du constructeur point",75.456,carre.getPosition().getX(),EPSYLON);
	}
	@Test
	public void ConstructeurTest4(){
		Carre carre = new Carre(new Point(50.263,26.205),16.368);
		assertEquals("Test du constructeur point",44.671,carre.getPosition().getX(),EPSYLON);
		assertEquals("Test du constructeur point",75.456,carre.getPosition().getX(),EPSYLON);
		
	}
	@Test
	public void ConstructeurTest5(){
		Carre carre = new Carre(new Point(39.518,48.924),-33.37);
		assertEquals("Test du constructeur point",44.671,carre.getPosition().getX(),EPSYLON);
		assertEquals("Test du constructeur point",75.456,carre.getPosition().getX(),EPSYLON);
		
	}

}
