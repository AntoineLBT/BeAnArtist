package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TraceTest {

	@Test
	public void testConstructeur() {
		Point pos = new Point(0,0);
		Trace trace1 = new Trace(pos);
		assertEquals("On test le constructeur", 0,trace1.getHauteur(),0);
		
	}
	
	@Test
	public void testConstructeur3() {
		
		Trace trace1 = new Trace(new Point(25.879,93.3),new Point(80.316,6.069));
		assertEquals("On test le constructeur3", 25.879,trace1.getX(),0);
		System.out.println(trace1.getX());
	}

}
