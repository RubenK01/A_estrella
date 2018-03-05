
public class Nodo implements Comparable<Nodo> {
	private int x;
	private int y;
	private double f;
	//private double distanciaAlPadre;
	//private Nodo target;
	private Nodo padre;
	
	public Nodo(Nodo padre, int x, int y) {
		this.padre = padre;
		this.x = x;
		this.y = y;
		
		calculaF();
	}
//	
//	public Nodo (int x, int y) {
//		
//	}
	 @Override
     public int compareTo(Nodo o) {
         if ( this.f < o.f) {
             return -1;
         }
         if (this.f > o.f) {
             return 1;
         }
         return 0;
     }
	 
	 public double calculaDistAlInicio() {
		 if(this.padre != null) { //no es nodo inicial
			 if(this.padre.getX() != this.x && this.padre.getY() != this.y) { //diagonal
				 return 1.41 + this.padre.calculaDistAlInicio();
			 }
			 else
				 return 1 + this.padre.calculaDistAlInicio();
		 }
		 else 
			 return 0;
	 }
	 
	 public void calculaF() {
		 this.f = calculaG() + calculaH();
	 }
	  
	 private double calculaG() {
		 double resul;
		 
		 resul = calculaDistAlInicio();
		 
		 return resul;
	 }
	 
	 private double calculaH() {
		 double resul = 0.0;
		 
		 if (Variables.getTarget() != null)
			 resul = Math.sqrt(Math.pow(Variables.getTarget().getX()-this.x, 2) + Math.pow(Variables.getTarget().getY()-this.y, 2));
		 
		 return resul;
	 }
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getF() {
		return f;
	}
	public void setF(double f) {
		this.f = f;
	}
	public Nodo getPadre() {
		return padre;
	}
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	
	
}
