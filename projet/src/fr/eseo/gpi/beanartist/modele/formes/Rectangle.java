package fr.eseo.gpi.beanartist.modele.formes;



public class Rectangle extends Forme {

	public Rectangle (Point position, double largeur, double hauteur){
		super (position, largeur, hauteur);
		
	}
	public Rectangle (){
		this (new Point (), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	public Rectangle (double abs, double ord, double largeur, double hauteur){
		this (new Point (abs , ord), largeur, hauteur);
		
	}
	public Rectangle (double largeur, double hauteur){
		this(new Point(), largeur, hauteur);
	}
	public Rectangle (Point position){
		this (position, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	/*
	* Implémentation des méthodes abstraites de la classe Forme
	*/
	
	public void setHauteur(double hauteur){
		
		super.setHauteur(hauteur);
	}
	public void setLargeur(double largeur){
		
		super.setLargeur(largeur);
	}
	public double aire (){
		return getLargeur()* getHauteur();
	}
	
	public double perimetre (){
		return 2*( getLargeur()+ getHauteur());
	}
	
	public boolean contient(Point position){
		boolean point = false;
		if(this.getCadreMinX() < position.getX() && position.getX() < this.getCadreMaxX() && this.getCadreMinY() < position.getY() && position.getY() < this.getCadreMaxY()){
			point = true;
		}
		return point;
	}
	public boolean contient(double abs, double ord){
		boolean point = false;
		if(this.getCadreMinX() < abs && abs < this.getCadreMaxX() && this.getCadreMinY() < ord && ord < this.getCadreMaxY()){
			point = true;
		}
		return point;
	}
}
