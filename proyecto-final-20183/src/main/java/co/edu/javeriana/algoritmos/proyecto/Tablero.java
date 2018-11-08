/**
 * 
 */
package co.edu.javeriana.algoritmos.proyecto;

import co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran.CasillaSG;

/**
 * La implementación que se utilizará dentro del robot la suministraré yo, pero es buena idea
 * que ustedes generen la suya para probar.
 *
 */
public interface Tablero extends Cloneable {

    /**
     * Efectúa una jugada sobre el tablero.
     * 
     * @param jugada La jugada a realizar
     * @return puntaje de la jugada
     * @throws IllegalArgumentException si la jugada no es válida
     */
    int efectuarJugada( Casilla jugada ) throws IllegalArgumentException;
    
    int simularJugada( Casilla jugada ) throws IllegalArgumentException;
    
    int getNumeroColores();
    
    int getFilas();
    
    int getColumnas();
    
    int colorCasilla (int i, int j);
    
    int[][] coloresTablero ();
    
}
