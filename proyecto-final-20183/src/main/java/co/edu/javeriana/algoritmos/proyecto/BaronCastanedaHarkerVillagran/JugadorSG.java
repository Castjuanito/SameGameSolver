package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Casilla;
import co.edu.javeriana.algoritmos.proyecto.Jugador;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class JugadorSG implements Jugador {
	private int puntaje;
	private List<CasillaSG> jugadas;
	/**
	* Dado un tablero realiza las jugadas a travez de la clase TableroSG
	* @param tablero : Tablero en donde se van a efectuar las jugadas
	* @return : lista ordenada de jugadas que se deben efectuar sobre el tablero
	*/
	@Override
	public List<Casilla> jugar(Tablero tablero) {

		TableroSG tSG = new TableroSG(tablero);

		tSG.recorrerColores();
		return tSG.getJugadas();
	}

	@Override
	public String identificacionJugador() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
