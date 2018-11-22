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
	
	/**
	 * Dado un color y el tablero se realiza una accion de eliminar
	 * casillas vecinas con el mismo color
	 * 
	 * @param tSG
	 * @param c
	 * @return
	 */
	public List<Casilla> jugarColor(TableroSG tSG, int c){
		
		this.puntaje=0; //Puntaje total de jugar un color
		this.jugadas = new ArrayList<CasillaSG>(); 

		for(int i=0; i < tSG.getFilas(); i++){
			for(int j=0; j< tSG.getColumnas(); j++){
				if(tSG.getTableroSG().get(i).get(j) != null){
					if(tSG.getTableroSG().get(i).get(j).getColor() == c){
						List<CasillaSG> vecinos = buscarVecinos(i, j, c, tSG);
						if(vecinos.size() < 4 && vecinos.size() > 1){
							jugadas.add(vecinos.get(0));
							puntaje+= arribaAbajo(vecinos, tSG);
						}else if(vecinos.size() > 0){
							jugadas.add(vecinos.get(0));
							puntaje += quitarConjunto(vecinos, tSG);
						}
					}
				}
			}
		}

		//this.tNuevo = actualizarTablero( tSG, t); //nuevo trablero resultante al jugar un color
		return null;
	}
	
	/**
	 * Dado la posicion de una casilla, un color y el tablero de juego se 
	 * buscan los vecinos con el mismo color
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param tSG
	 * @return una secuencia con los vecinos cercanos a la casilla del mismo color
	 */
	private List<CasillaSG> buscarVecinos(int x, int y, int color, TableroSG tSG){
		CasillaSG c =  (tSG.getTableroSG().get(x).get(y) != null)? tSG.getTableroSG().get(x).get(y) : null;
		List<CasillaSG> vecinos = new ArrayList<CasillaSG>();

		if( x < 0 || y < 0 || x>=tSG.getColumnas() || y>=tSG.getFilas()|| c.getColor() != color || !c.isVisitado() || c == null){
			return vecinos;
		}

		tSG.getTableroSG().get(x).get(y).setVisitado(true);
		vecinos.add(c);
		vecinos.addAll(buscarVecinos(x,y-1,color,tSG));
		vecinos.addAll(buscarVecinos(x+1,y,color,tSG));
		vecinos.addAll(buscarVecinos(x,y+1,color,tSG));
		vecinos.addAll(buscarVecinos(x-1,y, color,tSG));

		return vecinos;
	}
	
	/**
	 * Eliminar del tablero el conjunto de elementos que tengan una misma caracteristica
	 * @param grupo
	 * @param tSG
	 * @return
	 */
	private int quitarConjunto(List<CasillaSG> grupo,TableroSG tSG){
		for(CasillaSG c : grupo){
			for(int i = c.getFila(); i>-1; i--){
				if(tSG.getTableroSG().get(i-1).get(c.getColumna()) != null){
					tSG.getTableroSG().get(i).replace(c.getFila(), tSG.getTableroSG().get(i-1).get(c.getColumna()));
				}else{
					break;
				}
			}
		}
		return 0;
	}
	
	/**
	 * Verifica el tablero para que las casillas arriba del espacio eliminado caigan o se muevan a la izquierda
	 * @param tSG
	 * @return
	 */
	private Tablero actualizarTablero(TableroSG tSG){
		TableroSG tNuevo = new TableroSG(tSG.getFilas(),tSG.getColumnas());
		for(int i=0; i<tSG.getFilas();i++){
			for(int j=0; j<tSG.getColumnas(); j++){
				if(tSG.getTableroSG().get(i).get(j) != null){
					tNuevo.getTableroSG().get(i).get(j).setColor(tSG.getTableroSG().get(i).get(j).getColor());
				}else{
					tNuevo.getTableroSG().get(i).get(j).setColor(-1);
				}
			}
		}	
		return tNuevo;
	}

	/**
	 * Se verifica si existe un conjunto del mismo color en una secuencia seleccionada
	 * @param vecinos
	 * @param tSG
	 * @return
	 */
	private int arribaAbajo(List<CasillaSG> vecinos, TableroSG tSG){
		int puntaje=0;
		for(Casilla c : vecinos){
			if(tSG.getTableroSG().get(c.getFila()-1).get(c.getColumna()).getColor() == tSG.getTableroSG().get(c.getFila()+1).get(c.getColumna()).getColor()){
				puntaje = quitarConjunto(vecinos, tSG);
				break;
			}
		}
		return puntaje;
	}



}
