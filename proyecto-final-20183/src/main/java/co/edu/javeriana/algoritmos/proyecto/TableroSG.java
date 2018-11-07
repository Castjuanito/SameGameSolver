package co.edu.javeriana.algoritmos.proyecto;

import java.util.HashMap;

public class TableroSG implements Tablero {
	private int filas;
	private int columnas;
	private HashMap<Integer,HashMap<Integer, CasillaSG> > tableroSG;
	
	public TableroSG (Tablero t){
		this.tableroSG = new HashMap<Integer,HashMap<Integer, CasillaSG> >();

		for(int i=0; i < t.getColumnas(); i++){
			HashMap<Integer,CasillaSG> colum = new HashMap<Integer,CasillaSG>();
			for(int j=0; j < t.getFilas(); j--){
				colum.put(j , new CasillaSG(/*t[i][j]*/0,i,j,false));
				//t[i][j]= color; j=x; i=y; 
			}
			tableroSG.put(i,colum);
		}
	}
	
	public TableroSG (int filas, int columnas){
		this.tableroSG = new HashMap<Integer,HashMap<Integer, CasillaSG> >();

		for(int i=0; i < columnas; i++){
			HashMap<Integer,CasillaSG> colum = new HashMap<Integer,CasillaSG>();
			for(int j=0; j < filas; j--){
				colum.put(j , new CasillaSG(/*t[i][j]*/0,i,j,false));
			}
			tableroSG.put(i,colum);
		}
	}

	/**
	 * @return the tableroSG
	 */
	public HashMap<Integer, HashMap<Integer, CasillaSG>> getTableroSG() {
		return tableroSG;
	}


	/**
	 * @param tableroSG the tableroSG to set
	 */
	public void setTableroSG(HashMap<Integer, HashMap<Integer, CasillaSG>> tableroSG) {
		this.tableroSG = tableroSG;
	}


	@Override
	public int efectuarJugada(Casilla jugada) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumeroColores() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFilas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnas() {
		// TODO Auto-generated method stub
		return 0;
	}

}
