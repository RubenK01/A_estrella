import java.util.List;

public class ACtrl {
	private int[][] map;
	private Nodo actual;
	
	public ACtrl(Nodo actual, int[][] map ) {
		//this.inicial = inicial;
		
		this.actual = actual;
		this.map = map;
		
		buscaYAniadeNodos(actual);
	}
		
	private boolean noEsPadre(Nodo padre, int x, int y) {
		
		if(padre != null)
			if (padre.getX() == x && padre.getY() == y)
				return false;
		
		
				
		return true;
	}
	
	private void creaAñadeMejorNodo(Nodo padre, int x, int y) {
		boolean encontrado = false;
		for(Nodo n : Variables.getCerrada()) {
			if (n.getX() == x && n.getY() == y) {
				encontrado = true;
				Nodo nuevoPadre = new Nodo(padre, x, y);
				if(nuevoPadre.getF() < n.getF()) {
					n.setPadre(padre);
					n.calculaF();
				}
				
			}
		}
		for(Nodo n : Variables.getAbierta() ) {
			if (n.getX() == x && n.getY() == y) {
				encontrado = true;		
				
			}
		}
		
		if(!encontrado) {
			//es target
			if(Variables.getTarget().getX() == x && Variables.getTarget().getY() == y) {
				if (Variables.getTarget().getPadre() == null) {
					Variables.getTarget().setPadre(padre);
					Variables.getTarget().calculaF();
					
				}
					
				else {
					Nodo nuevoPadre = new Nodo(padre, x, y);
					if(nuevoPadre.getF() < Variables.getTarget().getF()) {
						Variables.getTarget().setPadre(padre);
						Variables.getTarget().calculaF();
					}
				}
				Variables.getAbierta().add(Variables.getTarget());
				
			}
			else {
				Nodo nNodo = new Nodo(padre,  x, y);
				List<Nodo> lAbierta = Variables.getAbierta();
				lAbierta.add(nNodo);
				Variables.setAbierta(lAbierta);
			}
			 
		}
	}
	
	private void buscaYAniadeNodos(Nodo n) {
		
		//busca arriba
		if(n.getY()+1 < this.map[0].length && this.map[n.getX()][n.getY()+1] != -1 && noEsPadre(n.getPadre(), n.getX(), n.getY()+1) ) {
			creaAñadeMejorNodo(n, n.getX(), n.getY()+1);
			
		}
		
		//busca abajo
		if(n.getY() > 0 && n.getY()-1 >= 0 && this.map[n.getX()][n.getY()-1] != -1 && noEsPadre(n.getPadre(), n.getX(), n.getY()-1)) {
			creaAñadeMejorNodo(n, n.getX(), n.getY()-1);
		}
		
		//busca izq
		if(n.getX()-1 >= 0 && this.map[n.getX()-1][n.getY()] != -1 && noEsPadre(n.getPadre(), n.getX()-1, n.getY())) {
			creaAñadeMejorNodo(n, n.getX()-1, n.getY());
		}
		
		//busca dcha
		if(n.getX()+1 < this.map.length && this.map[n.getX()+1][n.getY()] != -1 && noEsPadre(n.getPadre(), n.getX()+1, n.getY())) {
			creaAñadeMejorNodo(n, n.getX()+1, n.getY());
		}
		
		//busca diag izq-arriba
		if(n.getX()-1 >= 0 && n.getY()+1 < this.map[0].length && this.map[n.getX()-1][n.getY()+1] != -1 && noEsPadre(n.getPadre(), n.getX()-1, n.getY()+1)) {
			creaAñadeMejorNodo(n, n.getX()-1, n.getY()+1);
		}
		
		//busca diag dcha-arriba
		if(n.getX()+1 < this.map.length && n.getY()+1 < this.map[0].length && this.map[n.getX()+1][n.getY()+1] != -1 && noEsPadre(n.getPadre(), n.getX()+1, n.getY()+1)) {
			creaAñadeMejorNodo(n, n.getX()+1, n.getY()+1);
		}
		
		//busca diag izq-abajo
		if(n.getX()-1 >= 0 && n.getY()-1 >= 0 && this.map[n.getX()-1][n.getY()-1] != -1 && noEsPadre(n.getPadre(), n.getX()-1, n.getY()-1)) {
			creaAñadeMejorNodo(n, n.getX()-1, n.getY()-1);
		}
		
		//busca diag dcha-abajo
		if(n.getX()+1 < this.map.length && n.getY()-1 >= 0 && this.map[n.getX()+1][n.getY()-1] != -1 && noEsPadre(n.getPadre(), n.getX()+1, n.getY()-1)) {
			creaAñadeMejorNodo(n, n.getX()+1, n.getY()-1);
		}
		
		
		
	}
	
	
	
	
	public void calculaPathMinimo() {//CALCULAR PATH EN EL MAIN (TIRANDO DE SUS PADRES)
		//si actual es main.TARGET y nada en abierta imprimir soluc
//		if(this.actual.equals(Variables.getTarget()) /*&& this.abierta.isEmpty()*/) {
//			return pathHastaInicio();
//		}
//		else {
			//poner el actual a cerrada y quitar de abierta
			List<Nodo> cerr = Variables.getCerrada();
			cerr.add(actual);
			Variables.setCerrada(cerr);
			List<Nodo> ab = Variables.getAbierta();
			ab.remove(actual);
			Variables.setAbierta(ab);
			if(Variables.getCerrada().size() >= 80) {
				int i = 1;
				
				i++;
			}
			if(!Variables.getAbierta().isEmpty()) {
				ACtrl aEst = new ACtrl(Variables.getAbierta().get(0), this.map );
				aEst.calculaPathMinimo();
			}
//			else 
//				return null;
		
		
	}		
}
