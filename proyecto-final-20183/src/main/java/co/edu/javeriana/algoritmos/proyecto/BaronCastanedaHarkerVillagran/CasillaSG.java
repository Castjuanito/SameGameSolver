package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran;

import co.edu.javeriana.algoritmos.proyecto.Casilla;
import java.util.List;

public class CasillaSG extends Casilla {
	private int color;
	private boolean visitado;
	

	public CasillaSG(int color,int fila, int columna, boolean visitado) {
		super(fila, columna);
		// TODO Auto-generated constructor stub
		this.color=color;
		this.visitado=visitado;
	}

	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * @return the vistado
	 */
	public boolean isVisitado() {
		return visitado;
	}

	/**
	 * @param vistado the vistado to set
	 */
	public void setVisitado(boolean vistado) {
		this.visitado = vistado;
	}
	
	
}
