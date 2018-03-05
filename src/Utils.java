import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class Utils {
	
//	public static void main(String[] args) {
////		Nodo n = new Nodo(null, 2, 2);
////		Variables.setTarget(n);
////		Nodo inicial = new Nodo(null,8,8);
////		Variables.setInicial(inicial);
////		Variables.setAbierta( new ArrayList<Nodo>());
////		List<Nodo> cerr = new ArrayList<Nodo>();
////		Variables.setCerrada(cerr);
////		
////		high  = 10;
////		width = 10;
////		int[][] map = construyeMap();
////		addFail(map, 5, 5);
////		addFail(map, 4, 3);
////		addFail(map, 4, 4);
////		
////		ACtrl a_Est = new ACtrl(Variables.getInicial(), map);
////		
////		a_Est.calculaPathMinimo();
////		
////		
////		List<Nodo> path = pathHastaInicio();
////		
////		path.toString();
//	}
	
	public static void pathHastaInicio() {
		//List<Nodo> path = new ArrayList<Nodo>();
		
		Nodo actual = Variables.getTarget();
		boolean esInicio = Variables.getInicial().getX() == actual.getX() && Variables.getInicial().getY()== actual.getY();
		
		while ( !esInicio && actual != null ) {
			//path.add(actual);
			if(actual != Variables.getTarget())
				Variables.getMap()[actual.getX()][actual.getY()] = 1;
			actual = actual.getPadre();
			
			esInicio = Variables.getInicial().getX() == actual.getX() && Variables.getInicial().getY() == actual.getY();
		}
		//Variables.getMap()[actual.getX()][actual.getY()] = 1;
		//path.add(actual);
	}
	
	public static void addFail(int x, int y) {
		Variables.getMap()[x][y] = -1;
	}
	
	public static void addIni(int x, int y) {
		for(int i = Variables.getWidth()-1; i >=0; i--) {
			for(int j=0; j<Variables.getHeigh(); j++) {
				if(Variables.getMap()[i][j] == 2)
					Variables.getMap()[i][j] = 0;
			}
			
		}
		
		Variables.getMap()[x][y] = 2;
	}
	
	public static void addFin(int x, int y) {
		for(int i = Variables.getWidth()-1; i >=0; i--) {
			for(int j=0; j<Variables.getHeigh(); j++) {
				if(Variables.getMap()[i][j] == 3)
					Variables.getMap()[i][j] = 0;
			}
			
		}
		
		Variables.getMap()[x][y] = 3;
	}
	
	public static void construyeMap() {
		int[][] m = new int[Variables.getWidth()][Variables.getHeigh()];
//		for (int i = 0; i < high; i++) {
//			for(int j = 0; j < width; j++) {
//				m[i][j] = 0;
//			}
//		}	
		
		for(int i = Variables.getWidth()-1; i >=0; i--) {
			for(int j=0; j<Variables.getHeigh(); j++) {
				m[i][j] = 0;
			}
			
		}
		
		Variables.setMap(m);
	}
	
	public static void limpiaDatos() {
		Variables.setTarget(null);
		Variables.setInicial(null);
		
		
		
	}

}
