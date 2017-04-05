package fr.eseo.gpi.beanartist.modele.formes;


public class Cercle extends Ellipse {

	public Cercle(){
		this(new Point(), Forme.LARGEUR_PAR_DEFAUT);
	}
	public Cercle(Point position){
		this(position, Forme.LARGEUR_PAR_DEFAUT);
	}
	public Cercle(double longueur){
		this(new Point(), longueur);
	}
	public Cercle(Point position, double longueur){
		super(position, longueur, longueur);
	}
	public Cercle(double abs,double ord,double longueur){
		this(new Point(abs, ord), longueur);
	}
	
	public void setLargeur(double largeur){
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
	public void setHauteur(double hauteur){
		super.setLargeur(hauteur);
		super.setHauteur(hauteur);
	}
	public double perimetre(){
		return Math.PI*2*this.getHauteur()/2;
	}
}
