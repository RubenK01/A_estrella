import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Variables {
	private static  List<Nodo> abierta;
	private static List<Nodo> cerrada;
	private static List<Nodo> wayPoints = new ArrayList<Nodo>();
	private static Nodo target;
	private static Nodo inicial;
	private static int heigh;
	private static int width;
	private static int[][] map;
	public static int[][] getMap() {
		return map;
	}
	public static void setMap(int[][] map) {
		Variables.map = map;
	}
	public static List<Nodo> getAbierta() {
		return abierta;
	}
	public static void setAbierta(List<Nodo> abierta) {
		Variables.abierta = abierta;
		Collections.sort(Variables.abierta);
	}
	public static List<Nodo> getCerrada() {
		return cerrada;
	}
	public static void setCerrada(List<Nodo> cerrada) {
		Variables.cerrada = cerrada;
	}
	public static Nodo getTarget() {
		return target;
	}
	public static void setTarget(Nodo target) {
		Variables.target = target;
	}
	public static Nodo getInicial() {
		return inicial;
	}
	public static void setInicial(Nodo inicial) {
		Variables.inicial = inicial;
	}
	public static int getWidth() {
		return width;
	}
	public static void setWidth(int width) {
		Variables.width = width;
	}
	public static int getHeigh() {
		return heigh;
	}
	public static void setHeigh(int heigh) {
		Variables.heigh = heigh;
	}
	public static List<Nodo> getWayPoints() {
		return wayPoints;
	}
	public static void setWayPoints(List<Nodo> wayPoints) {
		Variables.wayPoints = wayPoints;
	}
	

}
