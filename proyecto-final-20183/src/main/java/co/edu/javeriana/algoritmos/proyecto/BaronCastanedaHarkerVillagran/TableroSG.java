package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Casilla;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class TableroSG implements Tablero {
	private int filas;
	private int columnas;
	private int numeroColores; 
	private HashMap<Integer,HashMap<Integer, CasillaSG> > tableroSG;
        private int puntaje =0;
        private List<Casilla> jugadas = new ArrayList<Casilla>();
	
	class Pareja {
		int minimo =0;
		int maximo =0;
		Pareja (){
			minimo =0;
			maximo =0;
		}
	}
        public TableroSG(TableroSG t){
            this.jugadas = new ArrayList<Casilla>();
            this.tableroSG = new HashMap<Integer,HashMap<Integer, CasillaSG> >();
            this.filas = t.getFilas();
            this.columnas = t.getColumnas();
            for(int i=0; i < t.getColumnas(); i++){
		HashMap<Integer,CasillaSG> colum = new HashMap<Integer,CasillaSG>();
		for(int j=0; j < t.getFilas(); j--){
			colum.put(j , new CasillaSG(t.colorCasilla(i, j),i,j,false));
		}
		tableroSG.put(i,colum);
            }
            this.puntaje = t.getPuntaje();
            this.jugadas.addAll(t.getJugadas());
        }
	
	public TableroSG (Tablero t){
		this.tableroSG = new HashMap<Integer,HashMap<Integer, CasillaSG> >();
		this.filas = t.getFilas();
		this.columnas = t.getColumnas();
		for(int i=0; i < t.getColumnas(); i++){
			HashMap<Integer,CasillaSG> colum = new HashMap<Integer,CasillaSG>();
			for(int j=0; j < t.getFilas(); j++){
				colum.put(j , new CasillaSG(t.colorCasilla(j, i),j,i,false));
			}
			tableroSG.put(i,colum);
		}
	}
	
	public TableroSG (int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
		this.tableroSG = new HashMap<Integer,HashMap<Integer, CasillaSG> >();

		for(int i=0; i < columnas; i++){
			HashMap<Integer,CasillaSG> colum = new HashMap<Integer,CasillaSG>();
			for(int j=0; j < filas; j++){
				colum.put(j , new CasillaSG(-1,j,i,false));
			}
			tableroSG.put(i,colum);
		}
	}
	
	public void modificarCasilla (int x, int y, int color) {
		tableroSG.get(y).get(x).setColor(color);
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
	public int simularJugada( Casilla jugada ) throws IllegalArgumentException{
		if (jugada.getFila()<0 || jugada.getColumna()<0 || jugada.getFila()>= this.filas || jugada.getColumna()>= this.columnas) {
			throw new IllegalArgumentException("La Judada debe estar dentro del tablero actual");
		}
		if (this.tableroSG.get(jugada.getColumna()).get(jugada.getFila()).getColor()==-1) {
			throw new IllegalArgumentException("La casilla seleccionada esta vacia");
		}
		
		List<Casilla> vecinos = buscarVecinos(jugada.getFila(), jugada.getColumna());
		if (vecinos.size() <= 1) {
			throw new IllegalArgumentException("La Judada debe ser de mas de una casilla");
		}
		return 0;
	}
	
	@Override
	public int efectuarJugada(Casilla jugada) throws IllegalArgumentException {
		if (jugada.getFila()<0 || jugada.getColumna()<0 || jugada.getFila()>= this.filas || jugada.getColumna()>= this.columnas) {
			throw new IllegalArgumentException("La Judada debe estar dentro del tablero actual");
		}
		if (this.tableroSG.get(jugada.getColumna()).get(jugada.getFila()).getColor()==-1) {
			throw new IllegalArgumentException("La casilla seleccionada esta vacia");
		}
		
		List<Casilla> vecinos = buscarVecinos(jugada.getFila(), jugada.getColumna());
		if (vecinos.size() <= 1) {
			throw new IllegalArgumentException("La Judada debe ser de mas de una casilla");
		}
		
		Casilla c = new Casilla(jugada.getFila(), jugada.getColumna());
		this.jugadas.add(c);
		
		HashMap<Integer, Pareja> datosEliminar = new HashMap<Integer, Pareja>();
		for (int i = 0; i < vecinos.size(); i++) {
			if(!datosEliminar.containsKey(vecinos.get(i).getColumna())){
				Pareja p = new Pareja();
				p.maximo = vecinos.get(i).getFila();
            			p.minimo = vecinos.get(i).getFila();
				datosEliminar.put(vecinos.get(i).getColumna(), p);
			}else {
				if(datosEliminar.get(vecinos.get(i).getColumna()).maximo< vecinos.get(i).getFila()) {
					datosEliminar.get(vecinos.get(i).getColumna()).maximo = vecinos.get(i).getFila();
				}else if(datosEliminar.get(vecinos.get(i).getColumna()).minimo> vecinos.get(i).getFila()){
					datosEliminar.get(vecinos.get(i).getColumna()).minimo = vecinos.get(i).getFila();
				}
			}
			this.modificarCasilla(vecinos.get(i).getFila(), vecinos.get(i).getColumna(), -1);
		}
		eliminarCasilla (datosEliminar);
		
		int puntaje = 0;
		puntaje = (vecinos.size()-2)*(vecinos.size()-2);
		
		return puntaje;
	}
	protected void eliminarColumna () {
		for(int i=0; i< columnas; i++) {
			if(this.tableroSG.get(i).get(filas-1)!=null && this.tableroSG.get(i).get(filas-1).getColor()==-1) {
				eliminarColumna (i);
				i--;
			}
		}
	}
	protected void eliminarColumna (int y) {
		for (int i =y; i<columnas-1; i++) {
			for(int j=0; j<filas; j++) {
				this.tableroSG.get(i+1).get(j).setColumna(i);
			}
			this.tableroSG.put(i, this.tableroSG.get(i+1));
		}
		this.tableroSG.remove(columnas-1);
		columnas--;
	}
	protected void eliminarCasilla (HashMap<Integer, Pareja> eliminar) {
		for(int col: eliminar.keySet()) {
			int cantEliminar = eliminar.get(col).maximo - eliminar.get(col).minimo +1;
			for(int i =eliminar.get(col).maximo; i> 0 && i-cantEliminar>=0; i--) {
				this.tableroSG.get(col).get(i).setColor(this.tableroSG.get(col).get(i-cantEliminar).getColor());
			}
			for(int i =0; i< cantEliminar; i++) {
				this.tableroSG.get(col).get(i).setColor(-1);
			}
		}
		eliminarColumna ();
	}
	protected List<Casilla> buscarVecinos (int x, int y) {
		List<Casilla> vecinos = new ArrayList<Casilla>();
		vecinos = buscarVecinosAux (x, y, this.tableroSG.get(y).get(x).getColor());
		for(int i=0; i<vecinos.size(); i++) {
			tableroSG.get(vecinos.get(i).getColumna()).get(vecinos.get(i).getFila()).setVisitado(false);
		}
		return vecinos;
	}
	protected List<Casilla> buscarVecinosAux (int x, int y, int color){
		List<Casilla> vecinos = new ArrayList<Casilla>();
		if (x<0 || y<0 || x>= this.filas || y>= this.columnas) {
			return vecinos;
		}
		if(this.tableroSG.get(y).get(x).getColor()!=color || this.tableroSG.get(y).get(x).getColor()== 0 
				||this.tableroSG.get(y).get(x).isVisitado()){
			return vecinos;
		}
		
		this.tableroSG.get(y).get(x).setVisitado(true);
		vecinos.add(this.tableroSG.get(y).get(x));
		vecinos.addAll(buscarVecinosAux(x,y-1,color));
		vecinos.addAll(buscarVecinosAux(x+1,y,color));
		vecinos.addAll(buscarVecinosAux(x,y+1,color));
		vecinos.addAll(buscarVecinosAux(x-1,y, color));

		return vecinos;
	}
	@Override
	public int getNumeroColores() {
		return numeroColores;
	}

	@Override
	public int getFilas() {
		return filas;
	}

	@Override
	public int getColumnas() {
		return columnas;
	}
	
	@Override
	public int colorCasilla(int x, int y) {
		return tableroSG.get(y).get(x).getColor();
	}
	
	@Override
	public int[][] coloresTablero (){
		int[][] nuevaMatriz = new int [filas][columnas];
		for (int i=0; i<filas; i++) {
			for(int j=0; j<columnas; j++) {
				nuevaMatriz[i][j]=tableroSG.get(j).get(i).getColor();
			}
		}
		return nuevaMatriz;
	}
	
 
	public int jugarColor(int color){
            this.puntaje=0; //Puntaje total de jugar un color
            List<Casilla> jugadasColor = new ArrayList<Casilla>(); //Jugadas que se hicieron jugando un solo color

            for(int i=0; i<this.filas; i++){
                for(int j=0; j<this.columnas; j++){
                    if(tableroSG.get(j).get(i) != null && tableroSG.get(j).get(i).getColor() != -1){
                        if(tableroSG.get(j).get(i).getColor() == color){
                            try{
                                this.puntaje += efectuarJugada(tableroSG.get(j).get(i));
                                
                            }catch(IllegalArgumentException e){
                            }
                        }
                    }
                }
            }
            return this.puntaje;
        }
	
	public int recorrerColores( ){
	    for(int i=0; i<this.filas; i++){
	    	for(int j=0; j<this.columnas; j++){
	    		if(tableroSG.get(j).get(i) != null && tableroSG.get(j).get(i).getColor() != -1){
	    			jugarColor( tableroSG.get(j).get(i).getColor());
	    		}
	    	}
	    }
	    return this.puntaje;
	}	

    public int getPuntaje() {
        return puntaje;
    }

    public List<Casilla> getJugadas() {
        return jugadas;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setJugadas(List<Casilla> jugadas) {
        this.jugadas = jugadas;
    }
        
}
