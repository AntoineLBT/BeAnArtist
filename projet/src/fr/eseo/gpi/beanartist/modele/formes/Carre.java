package fr.eseo.gpi.beanartist.modele.formes;



public class Carre extends Rectangle  {
	
	public Carre(){
		this(new Point(), Forme.LARGEUR_PAR_DEFAUT);
	}
	public Carre(Point position){
		this(position, Forme.LARGEUR_PAR_DEFAUT);
	}
	public Carre(double longueur){
		this(new Point(), longueur);
	}
	public Carre(Point position, double longueur){
		super(position, longueur, longueur);
	}
	public Carre(double abs,double ord,double longueur){
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
	
	

}
