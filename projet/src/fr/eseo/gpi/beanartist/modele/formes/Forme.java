package fr.eseo.gpi.beanartist.modele.formes;

import java.text.DecimalFormat;

public abstract class Forme {

	
	public static final double LARGEUR_PAR_DEFAUT = 100;
	public static final double HAUTEUR_PAR_DEFAUT = 150;
	/* Les variables d ' instances privées de la classe abstraite */
	private double largeur ;
	private double hauteur ;
	private Point position ;
	
	/*
	* Les constructeurs de la classe abstraite Forme .
	* Ils ne peuvent pas être utilisés pour construire des Formes
	* ( une classe abstraite ne pouvant pas avoir d ' instance )
	* mais pourront l ' être par ses sous classes .
	*/
	public Forme (){
		this (new Point (),LARGEUR_PAR_DEFAUT,HAUTEUR_PAR_DEFAUT);
	}
	public Forme (double abs, double ord, double largeur, double hauteur){
		this (new Point (abs, ord), largeur, hauteur);
	}
	public Forme (Point position, double largeur, double hauteur){
		if(this.getClass().getSimpleName().equals("Rectangle") || this.getClass().getSimpleName().equals("Ellipse") || this.getClass().getSimpleName().equals("Carre") || this.getClass().getSimpleName().equals("Cercle")){
			if(largeur < 0 || hauteur < 0){
				throw new IllegalArgumentException("Largeur ou Hauteur négative");
			}
		}
		if(this.getClass().getSimpleName().equals("Trace")){
			this.largeur = largeur;
			this.hauteur = hauteur;
			this.position = position;
		} else {
		setPosition(position);
		setLargeur(largeur);
		setHauteur(hauteur);
		}
	}
	public Forme (double largeur, double hauteur){
		this (new Point (),largeur,hauteur);
	}
	public Forme (Point position){
		this (position, LARGEUR_PAR_DEFAUT,HAUTEUR_PAR_DEFAUT);
	}
	/*
	* Les méthodes d ' instances de la classe abstraite Forme
	* seront héritées par les sous - classes de Forme .
	* Ces dernières pourront donc les utiliser .
	*/
	
	public Point getPosition(){
		return this.position;
	}
	public double getX(){
		return this.getPosition().getX();
	}
	public double getY(){
		return this.getPosition().getY();
	}
	public double getHauteur(){
		return this.hauteur;
	}
	public double getLargeur(){
		return this.largeur;
	}
	public double getCadreMinX(){
		if(this.getLargeur() < 0){
			return this.getX()+this.getLargeur();
		} else {
			return this.getX();
		}
	}
	public double getCadreMinY(){
		if(this.getHauteur() < 0){
			return this.getY()+this.getHauteur();
		} else {
			return this.getY();
		}
	}
	public double getCadreMaxX(){
		if(this.getLargeur() < 0){
			return this.getX();
		} else {
			return this.getX()+this.getLargeur();
		}
	}
	public double getCadreMaxY(){
		if(this.getHauteur() < 0){
			return this.getY();
		} else {
			return this.getY()+this.getHauteur();
		}
	}
	public void setPosition (Point position){
		this.position = position ;
	}
	public void setX(double abs){
		this.position.deplacerVers(abs, this.position.getY());
	}
	
	public void setY(double ord){
		this.position.deplacerVers(this.position.getX(), ord);
	}
	public void setHauteur(double hauteur){
		if(this.getClass().getSimpleName().equals("Rectangle") || this.getClass().getSimpleName().equals("Ellipse") || this.getClass().getSimpleName().equals("Carre") || this.getClass().getSimpleName().equals("Cercle")){
			if(hauteur < 0){
				throw new IllegalArgumentException("Largeur ou Hauteur négative");
			}
		}
		this.hauteur = hauteur;
	}
	public void setLargeur(double largeur){
		if(this.getClass().getSimpleName().equals("Rectangle") || this.getClass().getSimpleName().equals("Ellipse") || this.getClass().getSimpleName().equals("Carre") || this.getClass().getSimpleName().equals("Cercle")){
			if(largeur < 0){
				throw new IllegalArgumentException("Largeur ou Hauteur négative");
			}
		}
		this.largeur = largeur;
	}
	public void deplacerVers(double nX,double nY){
		this.position.deplacerVers(nX,nY);
	}
	public 	void deplacerDe(double dX,double dY){
		this.position.deplacerDe(dX,dY);
	}
	public String toString(){
		DecimalFormat precision = new DecimalFormat("#.##");
		String str = "";
		return str += "[" + this.getClass().getSimpleName()+ "]" + " pos (" + precision.format(this.getX()) + " , " + precision.format(this.getY()) + ") dim " + precision.format(this.getLargeur()) + 
				" x " + precision.format(this.getHauteur()) + " périmètre : " + precision.format(this.perimetre()) + " aire : " + precision.format(this.aire());
	}
	
	public abstract double perimetre();
	
	public abstract double aire();
	
	public abstract boolean contient(Point position);
	
	public abstract boolean contient(double abs, double ord);
}

