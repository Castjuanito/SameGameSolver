package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Casilla;

public class Nodo {
	private List<Nodo> hijos = new ArrayList<Nodo>();
	private int puntaje;
	private List<Casilla> jugadas = new ArrayList<Casilla>() ;
	private TableroSG tableroFinal;
	
	
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
	
	
}
