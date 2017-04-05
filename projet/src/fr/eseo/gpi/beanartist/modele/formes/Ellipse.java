package fr.eseo.gpi.beanartist.modele.formes;

public class Ellipse extends Forme {
	
	public Ellipse (Point position, double largeur, double hauteur){
		super (position, largeur, hauteur);
		
	}
	public Ellipse (){
		this (new Point (), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	public Ellipse (double abs, double ord, double largeur, double hauteur){
		this (new Point (abs , ord), largeur, hauteur);
		
	}
	public Ellipse (double largeur, double hauteur){
		this (new Point (), largeur, hauteur);
		
	}
	public Ellipse (Point position){
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
		return Math.PI*(this.getHauteur()/2)*(this.getLargeur()/2);
	}
	public double perimetre (){
		double a = this.getHauteur()/2;
		double b = this.getLargeur()/2;
		double h = Math.pow((a - b)/(a+b),2);
		return Math.PI*(a + b)*(1 + (3*h)/(10 + Math.sqrt(4-3*h)));
	}
	
	public boolean contient(Point position){
		boolean contientPoint = false;
		
		double a = (this.getCadreMinX() + this.getCadreMaxX())/2;
		double b = (this.getCadreMinY() + this.getCadreMaxY())/2;
		double X = Math.abs((this.getCadreMinX() - this.getCadreMaxX())/2);
		double Y = Math.abs((this.getCadreMinY() - this.getCadreMaxY())/2);
		if (Math.pow((position.getX() - a)/X, 2) + Math.pow((position.getY() - b)/Y, 2) <= 1){
			contientPoint = true;
		}
		return contientPoint;
	}
	public boolean contient(double abs, double ord){
boolean contientPoint = false;
		
		double a = (this.getCadreMinX() + this.getCadreMaxX())/2;
		double b = (this.getCadreMinY() + this.getCadreMaxY())/2;
		double X = Math.abs((this.getCadreMinX() - this.getCadreMaxX())/2);
		double Y = Math.abs((this.getCadreMinY() - this.getCadreMaxY())/2);
		if (Math.pow((abs - a)/X, 2) + Math.pow((ord - b)/Y, 2) <= 1){
			contientPoint = true;
		}
		return contientPoint;
	}

}
