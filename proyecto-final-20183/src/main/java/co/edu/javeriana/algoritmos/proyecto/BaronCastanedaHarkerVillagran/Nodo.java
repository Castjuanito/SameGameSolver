package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Casilla;


public class Nodo {
	
	private List<Nodo> hijos = new ArrayList<Nodo>();
	private int puntaje;
	private List<Casilla> jugadas = new ArrayList<Casilla>() ;
	private TableroSG tableroFinal;
	private int visitas;
	private Nodo padre;
	
	
	public Nodo() {
		super();
	}
	
	public Nodo (int puntaje, TableroSG tableroFinal) {
		this.puntaje = puntaje;
		this.tableroFinal = tableroFinal;
	}

	public Nodo (int puntaje, List<Casilla> jugadas, TableroSG tableroFinal) {
		this.puntaje = puntaje;
		this.jugadas = jugadas;
		this.tableroFinal = tableroFinal;
	}

	public List<Nodo> getHijos() {
		return hijos;
	}

	public void setHijos(List<Nodo> hijos) {
		this.hijos = hijos;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public List<Casilla> getJugadas() {
		return jugadas;
	}

	public void setJugadas(List<Casilla> jugadas) {
		this.jugadas = jugadas;
	}

	public TableroSG getTableroFinal() {
		return tableroFinal;
	}

	public void setTableroFinal(TableroSG tableroFinal) {
		this.tableroFinal = tableroFinal;
	}
	
	public void agregarHijo (Nodo nodo) {
		this.hijos.add(nodo);
	}
	
	public Nodo getHijoRandom() {
		int noOfPossibleMoves = this.hijos.size();
        int selectRandom = (int) (Math.random() * noOfPossibleMoves);
        return this.hijos.get(selectRandom);
	}
	
	public Nodo getHijoMayorPuntaje() {
		Nodo mayor = new Nodo();
		int max = Integer.MIN_VALUE;
	    for(int i=0; i<hijos.size(); i++){
	        if(hijos.get(i).getPuntaje() > max){
	            mayor = hijos.get(i);
	        }
	    }
	    return mayor;
	}

	public int getVisitas() {
		return visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}
	
	public void incrementarVisitas() {
		this.visitas++;
	}
	
	public void incrementarPuntaje(int puntaje) {
		this.puntaje+=puntaje;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	
	public List<Nodo> getEstadosPosibles(){
		List<Nodo> estados = new ArrayList<Nodo>();
		
		List<Integer> colores = this.tableroFinal.getColores();
		for(int i=0;i<colores.size();i++) {
			Nodo auxN = new Nodo();
			TableroSG auxTab = new TableroSG(this.tableroFinal);
			auxTab.jugarColor(colores.get(i));
			auxN.setTableroFinal(auxTab); 
			estados.add(auxN);
		}
		return estados;
	}
	
	public void randomPlay()
	{
		List<Integer> colores = this.tableroFinal.getColores();
        int totalPossibilities = colores.size();
        int selectRandom = (int) (Math.random() * totalPossibilities);
        tableroFinal.jugarColor(colores.get(selectRandom));
	}
}
