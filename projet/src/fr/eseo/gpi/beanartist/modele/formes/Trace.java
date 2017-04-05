package fr.eseo.gpi.beanartist.modele.formes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;




public class Trace extends Forme {
	
private List<Point> points;
	

	public Trace(Point pos1){
		super(pos1,0,0);
		points = new ArrayList<Point>();
		ajouterPoint(pos1);
			
	}
	public Trace(Point pos1, Point pos2){
		this(pos1);
		ajouterPoint(pos2);
	}
	
	public List<Point> getPoints(){
		return this.points;
	}
	public void ajouterPoint(Point pos){
		if(getPoints().isEmpty()){
			setLargeur(0);
			setHauteur(0);
			setPosition(pos);
		} else {
			if(pos.getX() < this.getCadreMinX()){
				super.setLargeur(this.getLargeur()+(this.getPosition().getX()-pos.getX()));
				super.setPosition(new Point(pos.getX(),this.getY()));
				System.out.println("Cas1");
			}
			if(pos.getY() < this.getCadreMinY()){
				super.setHauteur(this.getHauteur()+(this.getPosition().getY()-pos.getY()));
				super.setPosition(new Point(this.getX(), pos.getY()));
				System.out.println("Cas1");
			}
			if(pos.getX() > this.getCadreMaxX()){
				super.setLargeur(pos.getX()-this.getPosition().getX());
				
				System.out.println("Cas2");
			}
			if(pos.getY() > this.getCadreMaxY()){
				super.setHauteur(pos.getY()-this.getPosition().getY());
				
				System.out.println("Cas2");
			}
		} 
		
		this.points.add(pos);
	}
	public void setPosition(Point position){
		super.setPosition(position);
	}
	public void setLargeur(double largeur){
		
		double largeurCourante = this.getLargeur();
		double ratio = largeur/largeurCourante;
		for(Point p : getPoints()){
			p.setX((p.getX()-this.getX())*ratio + this.getX());
		}
		super.setLargeur(largeur);
		
	}
	public void setHauteur(double hauteur){
		
		double hauteurCourante = this.getHauteur();
		double ratio = hauteur/hauteurCourante;
		for(Point p:points){
			p.setY((p.getY()-this.getY())*ratio + this.getY());
		}
		super.setHauteur(hauteur);
		
	}
	public void setX(double abs){
		double xEcart = abs - this.getX();
		for(Point p:points){
			p.setX(p.getX()+xEcart);
		}
		super.getPosition().setX(abs);
	}
	public void setY(double ord){
		double yEcart = ord  - this.getY();
		for(Point p:points){
			p.setY(p.getY()+yEcart);
		}
		super.getPosition().setY(ord);
	}
	public void deplacerVers(double nX, double nY){
		setPosition(new Point(getCadreMinX(),getCadreMinY()));
		double saveX, saveY, deltaX, deltaY;
		saveX = this.getX();
		saveY = this.getPosition().getY();
		setPosition(new Point(nX,nY));
		// création d'un vecteur de déplacement du point coin
		deltaX = this.getPosition().getX() - saveX;
		deltaY = this.getPosition().getY() - saveY;
		for(Point p : points){
			p.setX(deltaX);
			p.setY(deltaY);
		}

	}
	public void deplacerDe(double dX, double dY){
		for(Point p:points){
			p.setX(p.getX()+dX);
			p.setY(p.getY()+dY);
		}
	}
	
	
	public String toString(){
		DecimalFormat precision = new DecimalFormat("#.##");
		String str = "";
		return str += "[" + this.getClass().getSimpleName()+ "]" + " pos : (" + precision.format(this.getX()) + 
				" , " + precision.format(this.getY()) + ") dim : "+this.getLargeur()+" x "+this.getHauteur()
				+ " longueur : "+this.perimetre() + " nbSegments : "+this.getPoints();
		
	}
	
	public double getCadreMinX(){
		double minX = this.getPoints().get(0).getX();
		for(int i = 0;i <= this.getPoints().size()-1;i++){
			minX = Math.min(minX,this.getPoints().get(i).getX());
		}
		return minX;
	}
	public double getCadreMinY(){
		double minY = this.getPoints().get(0).getY();
		for(int i = 0;i <= this.getPoints().size()-1;i++){
			minY = Math.min(minY,this.getPoints().get(i).getY());
		}
		return minY;
	}
	
	public double getCadreMaxX(){
		double maxX = this.getPoints().get(0).getX();
		for(int i = 0;i <= this.getPoints().size()-1;i++){
			maxX = Math.max(maxX,this.getPoints().get(i).getX());
		}
		return maxX;
	}
	public double getCadreMaxY(){
		double maxY = this.getPoints().get(0).getY();
		for(int i = 0;i <= this.getPoints().size()-1;i++){
			maxY = Math.max(maxY,this.getPoints().get(i).getY());
		}
		return maxY;
	}
	
	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double aire() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean contient(Point position) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contient(double abs, double ord) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
