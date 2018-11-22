package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Casilla;
import co.edu.javeriana.algoritmos.proyecto.Jugador;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class JugadorSG implements Jugador {
	private int puntaje;
	private List<CasillaSG> jugadas;
	
	@Override
	public List<Casilla> jugar(Tablero tablero) {
		// TODO Auto-generated method stub
		TableroSG tSG = new TableroSG(tablero);
		//List<Casilla> lisCasillas = jugarColor(tSG , 0);
		tSG.recorrerColores();
		return tSG.getJugadas();
	}

	@Override
	public String identificacionJugador() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
