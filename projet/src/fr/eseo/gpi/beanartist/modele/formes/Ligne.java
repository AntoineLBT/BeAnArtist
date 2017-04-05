package fr.eseo.gpi.beanartist.modele.formes;

import java.text.DecimalFormat;

public class Ligne extends Forme {
	
	public static final double EPSILON = 1e-7;
	
	public Ligne(){
		this(new Point(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	public Ligne(Point position, double largeur, double hauteur){
		super(position, largeur, hauteur);
	}
	public Ligne(Point position){
		this(position, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	public Ligne(double x, double y, double largeur, double hauteur){
		this(new Point(x, y), largeur, hauteur);
	}
	public Ligne(double largeur, double hauteur){
		this(new Point(), largeur, hauteur);
	}
	
	public Point getP1(){
		return this.getPosition();
	}
	public void setP1(Point position){
		this.setHauteur(this.getHauteur() - (position.getY() - this.getP1().getY()));
		this.setLargeur(this.getLargeur() - (position.getX() - this.getP1().getX()));
		this.setPosition(position);
	}
	public Point getP2(){
		return new Point(this.getX()+this.getLargeur(), this.getY()+this.getHauteur());
	}
	public void setP2(Point position){
		this.setHauteur(this.getHauteur() - (this.getP2().getY()- position.getY()));
		this.setLargeur(this.getLargeur() - (this.getP2().getX()- position.getX()));
	}
	
	@Override
	public double getCadreMinX(){
		return super.getCadreMinX();
	}
	public double getCadreMaxX(){
		return super.getCadreMaxX();
	}
	public double getCadreMinY(){
		return super.getCadreMinY();
	}
	public double getCadreMaxY(){
		return super.getCadreMaxY();
	}
	
	public double perimetre() {
		return Math.sqrt(Math.pow(this.getP1().getX()-this.getP2().getX(),2) + Math.pow(this.getP1().getY()-this.getP2().getY(), 2));
	}
	
	public double aire() {
		return 0;
	}
	
	public boolean contient(Point position) {
		double p1p = Math.sqrt(Math.pow(position.getX()-this.getP1().getX(), 2) + Math.pow(position.getY()-this.getP1().getY(), 2));
		double pp2 = Math.sqrt(Math.pow(this.getP2().getX()-position.getX(), 2) + Math.pow(this.getP2().getY()-position.getY(), 2));
		double p1p2 = Math.sqrt(Math.pow(this.getP2().getX()-this.getP1().getX(), 2) + Math.pow(this.getP2().getY()-this.getP1().getY(), 2));
		boolean point = false;
		if (p1p + pp2 - p1p2 <= EPSILON) {
			point = true;
		}
		return point;
	}
	
	public boolean contient(double abs, double ord) {
		double p1p = Math.sqrt(Math.pow(abs-this.getP1().getX(), 2) + Math.pow(ord-this.getP1().getY(), 2));
		double pp2 = Math.sqrt(Math.pow(this.getP2().getX()-abs, 2) + Math.pow(this.getP2().getY()-ord, 2));
		double p1p2 = Math.sqrt(Math.pow(this.getP2().getX()-this.getP1().getX(), 2) + Math.pow(this.getP2().getY()-this.getP1().getY(), 2));
		boolean point = false;
		if (p1p + pp2 - p1p2 <= EPSILON) {
			point = true;
		}
		return point;
	}
	public String toString(){
		DecimalFormat precision = new DecimalFormat("#.##");
		String str = "";
		return str += "[" + this.getClass().getSimpleName()+ "]" + " p1 : ("+ precision.format(this.getX()) + " , " + precision.format(this.getY())+ ")"+ " p2 : ("+ precision.format(this.getP2().getX()) + " , " + precision.format(this.getP2().getY())+ ") longueur : "+ precision.format(this.perimetre());
	}

}
