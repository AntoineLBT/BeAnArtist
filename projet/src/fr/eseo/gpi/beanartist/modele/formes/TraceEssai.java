package fr.eseo.gpi.beanartist.modele.formes;

public class TraceEssai {

	public static void main(String[] args) {
		Point pos1 = new Point(0, 0);
		Point pos2 = new Point(10, 20);
		Trace trace1 = new Trace(pos1);
		System.out.println(trace1.getHauteur());

	}

}
