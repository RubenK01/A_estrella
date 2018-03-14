import java.util.ArrayList;

public class Utils {
	
	public static void pathHastaInicio() {
		
		Nodo actual = Variables.getTarget();
		boolean esInicio = Variables.getInicial().getX() == actual.getX() && Variables.getInicial().getY()== actual.getY();
		
		while ( !esInicio && actual != null ) {
			if(actual != Variables.getTarget())
				Variables.getMap()[actual.getX()][actual.getY()] = 1;
			actual = actual.getPadre();
			
			esInicio = Variables.getInicial().getX() == actual.getX() && Variables.getInicial().getY() == actual.getY();
		}
	}
	
	public static void addFail(int x, int y) {
		Variables.getMap()[x][y] = -1;
	}
	
	public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
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
		Variables.setWayPoints(new ArrayList<Nodo>());
		
		
		
	}

}
