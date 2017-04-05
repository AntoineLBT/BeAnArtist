package fr.eseo.gpi.beanartist.modele.formes;

import java.text.DecimalFormat;

public class Point{

	double abs, ord;
	String couleur = "";

	public Point(){
		this.abs = 0.0;
		this.ord = 0.0;
	}
	public Point(double abs, double ord){
		this.abs = abs;
		this.ord = ord;
	}

	public double getX(){
		return this.abs;
	}
	public void setX(double abs){
		this.abs = abs;
	}
	public double getY(){
		return this.ord;
	}
	public void setY(double ord){
		this.ord = ord;
	}
	public void deplacerVers(double nX, double nY){
		this.abs = nX;
		this.ord = nY;	
	}

	public void deplacerDe(double dX, double dY){
		this.abs = this.abs + dX;
		this.ord = this.ord + dY;	
	}
	public String toString(){
		DecimalFormat precision = new DecimalFormat("#.##");
		
		String str = "";
		return str += "("+ precision.format(this.getX()) + " , " + precision.format(this.getY())+ ")";
	}

}
