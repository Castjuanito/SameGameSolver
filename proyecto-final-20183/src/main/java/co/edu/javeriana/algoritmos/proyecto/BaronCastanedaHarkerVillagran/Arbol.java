package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Casilla;

public class Arbol {
	private Nodo raiz;

	
	
	public Arbol() {
		super();
		raiz = new Nodo();
	}

	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public List<Casilla> mejorRama (){
		List<Casilla> jugadasMejores = mejorRamaAux(this.raiz);
		jugadasMejores.remove(jugadasMejores.size()-1);
		return jugadasMejores;

	}
	
	protected List<Casilla> mejorRamaAux (Nodo nodo){
		List<Casilla> jugadasMejores = nodo.getJugadas();
		//la ultima posición guarda el pontaje total
		if (nodo.getHijos().size()==0){
			jugadasMejores.add(new Casilla(nodo.getPuntaje(), 0));
			return jugadasMejores;
		}
		List<List<Casilla>> puntaje = new ArrayList<List<Casilla>> ();
		for(Nodo n : nodo.getHijos()){
			puntaje.add (mejorRamaAux (n));	
		}
		int mayorPuntaje = 0;
		List<Casilla> mejorJugadasNodo = new ArrayList<Casilla>();
		for(int i=0; i<puntaje.size(); i++){
			if(puntaje.get(i).get(puntaje.get(i).size()-1).getFila()>mayorPuntaje){
				mayorPuntaje = puntaje.get(i).get(puntaje.get(i).size()-1).getFila();
				mejorJugadasNodo = puntaje.get(i);
			}
		}
		mejorJugadasNodo.remove(mejorJugadasNodo.size()-1);
		jugadasMejores.addAll(mejorJugadasNodo);
		jugadasMejores.add(new Casilla(nodo.getPuntaje() + mayorPuntaje, 0));
		return jugadasMejores;
	}

	
}
