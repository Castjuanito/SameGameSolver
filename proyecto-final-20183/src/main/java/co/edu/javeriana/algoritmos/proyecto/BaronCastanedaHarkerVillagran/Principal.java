package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Casilla;
import co.edu.javeriana.algoritmos.proyecto.Jugador;

public class Principal {

	public static void main(String[] args) {
		TableroSG tableroDemo = crearDemo();
		
		for (int i =0; i<tableroDemo.getFilas(); i++) {
			for(int j =0; j<tableroDemo.getColumnas(); j++) {
				if(tableroDemo.colorCasilla(i, j)==-1) {
					System.out.print("  ");
				}else {
					System.out.print(tableroDemo.colorCasilla(i, j)+" ");
				}
			}
			System.out.println();
		}
		
		Jugador jugador = new JugadorSG();
		List<Casilla> jugadas = jugador.jugar(tableroDemo);
		
		for (Casilla casilla : jugadas) {
			System.out.println(casilla);
		}
		System.out.println();
		
		tableroDemo = crearDemo();
		System.out.println("=======================================");
		for (Casilla casilla : jugadas) {
			try {
				tableroDemo.efectuarJugada(casilla);
			}catch(IllegalArgumentException e) {
				System.err.println(casilla+":"+e.getMessage());
			}
		}
		System.out.println("=======================================");
		
		
		for (int i =0; i<tableroDemo.getFilas(); i++) {
			for(int j =0; j<tableroDemo.getColumnas(); j++) {
				if(tableroDemo.colorCasilla(i, j)==-1) {
					System.out.print("  ");
				}else {
					System.out.print(tableroDemo.colorCasilla(i, j)+" ");
				}
			}
			System.out.println();
		}
		System.out.println("END");

	}
	public static TableroSG crearDemo () {
		TableroSG nuevoT = new TableroSG(8, 12);
		nuevoT.modificarCasilla(0,0,1);
		nuevoT.modificarCasilla(1,0,1);
		nuevoT.modificarCasilla(2,0,2);
		nuevoT.modificarCasilla(3,0,2);
		nuevoT.modificarCasilla(4,0,3);
		nuevoT.modificarCasilla(5,0,4);
		nuevoT.modificarCasilla(6,0,1);
		nuevoT.modificarCasilla(7,0,2);
		
		nuevoT.modificarCasilla(0,1,1);
		nuevoT.modificarCasilla(1,1,1);
		nuevoT.modificarCasilla(2,1,3);
		nuevoT.modificarCasilla(3,1,1);
		nuevoT.modificarCasilla(4,1,2);
		nuevoT.modificarCasilla(5,1,4);
		nuevoT.modificarCasilla(6,1,4);
		nuevoT.modificarCasilla(7,1,2);
		
		nuevoT.modificarCasilla(0,2,1);
		nuevoT.modificarCasilla(1,2,4);
		nuevoT.modificarCasilla(2,2,2);
		nuevoT.modificarCasilla(3,2,4);
		nuevoT.modificarCasilla(4,2,4);
		nuevoT.modificarCasilla(5,2,1);
		nuevoT.modificarCasilla(6,2,3);
		nuevoT.modificarCasilla(7,2,1);
		
		nuevoT.modificarCasilla(0,3,2);
		nuevoT.modificarCasilla(1,3,2);
		nuevoT.modificarCasilla(2,3,1);
		nuevoT.modificarCasilla(3,3,1);
		nuevoT.modificarCasilla(4,3,4);
		nuevoT.modificarCasilla(5,3,4);
		nuevoT.modificarCasilla(6,3,3);
		nuevoT.modificarCasilla(7,3,3);
		
		nuevoT.modificarCasilla(0,4,1);
		nuevoT.modificarCasilla(1,4,1);
		nuevoT.modificarCasilla(2,4,1);
		nuevoT.modificarCasilla(3,4,1);
		nuevoT.modificarCasilla(4,4,1);
		nuevoT.modificarCasilla(5,4,1);
		nuevoT.modificarCasilla(6,4,1);
		nuevoT.modificarCasilla(7,4,1);
		
		nuevoT.modificarCasilla(0,5,2);
		nuevoT.modificarCasilla(1,5,3);
		nuevoT.modificarCasilla(2,5,4);
		nuevoT.modificarCasilla(3,5,3);
		nuevoT.modificarCasilla(4,5,1);
		nuevoT.modificarCasilla(5,5,1);
		nuevoT.modificarCasilla(6,5,4);
		nuevoT.modificarCasilla(7,5,3);
		
		nuevoT.modificarCasilla(0,6,1);
		nuevoT.modificarCasilla(1,6,2);
		nuevoT.modificarCasilla(2,6,2);
		nuevoT.modificarCasilla(3,6,3);
		nuevoT.modificarCasilla(4,6,2);
		nuevoT.modificarCasilla(5,6,3);
		nuevoT.modificarCasilla(6,6,3);
		nuevoT.modificarCasilla(7,6,1);
		
		nuevoT.modificarCasilla(0,7,2);
		nuevoT.modificarCasilla(1,7,3);
		nuevoT.modificarCasilla(2,7,1);
		nuevoT.modificarCasilla(3,7,4);
		nuevoT.modificarCasilla(4,7,1);
		nuevoT.modificarCasilla(5,7,2);
		nuevoT.modificarCasilla(6,7,1);
		nuevoT.modificarCasilla(7,7,2);
		
		nuevoT.modificarCasilla(0,8,1);
		nuevoT.modificarCasilla(1,8,4);
		nuevoT.modificarCasilla(2,8,1);
		nuevoT.modificarCasilla(3,8,1);
		nuevoT.modificarCasilla(4,8,2);
		nuevoT.modificarCasilla(5,8,2);
		nuevoT.modificarCasilla(6,8,2);
		nuevoT.modificarCasilla(7,8,1);
		
		nuevoT.modificarCasilla(0,9,2);
		nuevoT.modificarCasilla(1,9,2);
		nuevoT.modificarCasilla(2,9,2);
		nuevoT.modificarCasilla(3,9,4);
		nuevoT.modificarCasilla(4,9,2);
		nuevoT.modificarCasilla(5,9,3);
		nuevoT.modificarCasilla(6,9,3);
		nuevoT.modificarCasilla(7,9,4);
		
		nuevoT.modificarCasilla(0,10,4);
		nuevoT.modificarCasilla(1,10,2);
		nuevoT.modificarCasilla(2,10,2);
		nuevoT.modificarCasilla(3,10,3);
		nuevoT.modificarCasilla(4,10,3);
		nuevoT.modificarCasilla(5,10,2);
		nuevoT.modificarCasilla(6,10,2);
		nuevoT.modificarCasilla(7,10,1);
		
		nuevoT.modificarCasilla(0,11,2);
		nuevoT.modificarCasilla(1,11,1);
		nuevoT.modificarCasilla(2,11,2);
		nuevoT.modificarCasilla(3,11,2);
		nuevoT.modificarCasilla(4,11,1);
		nuevoT.modificarCasilla(5,11,1);
		nuevoT.modificarCasilla(6,11,2);
		nuevoT.modificarCasilla(7,11,1);
		
		return nuevoT;
	}
	
	public static TableroSG crearDemo2 () {
		TableroSG nuevoT = new TableroSG(12, 8);
		nuevoT.modificarCasilla(0,0,1);
		nuevoT.modificarCasilla(0,1,1);
		nuevoT.modificarCasilla(0,2,2);
		nuevoT.modificarCasilla(0,3,2);
		nuevoT.modificarCasilla(0,4,3);
		nuevoT.modificarCasilla(0,5,4);
		nuevoT.modificarCasilla(0,6,1);
		nuevoT.modificarCasilla(0,7,2);

		nuevoT.modificarCasilla(1,0,1);
		nuevoT.modificarCasilla(1,1,1);
		nuevoT.modificarCasilla(1,2,3);
		nuevoT.modificarCasilla(1,3,1);
		nuevoT.modificarCasilla(1,4,2);
		nuevoT.modificarCasilla(1,5,4);
		nuevoT.modificarCasilla(1,6,4);
		nuevoT.modificarCasilla(1,7,2);

		nuevoT.modificarCasilla(2,0,1);
		nuevoT.modificarCasilla(2,1,4);
		nuevoT.modificarCasilla(2,2,2);
		nuevoT.modificarCasilla(2,3,4);
		nuevoT.modificarCasilla(2,4,4);
		nuevoT.modificarCasilla(2,5,1);
		nuevoT.modificarCasilla(2,6,3);
		nuevoT.modificarCasilla(2,7,1);

		nuevoT.modificarCasilla(3,0,2);
		nuevoT.modificarCasilla(3,1,2);
		nuevoT.modificarCasilla(3,2,1);
		nuevoT.modificarCasilla(3,3,1);
		nuevoT.modificarCasilla(3,4,4);
		nuevoT.modificarCasilla(3,5,4);
		nuevoT.modificarCasilla(3,6,3);
		nuevoT.modificarCasilla(3,7,3);

		nuevoT.modificarCasilla(4,0,1);
		nuevoT.modificarCasilla(4,1,1);
		nuevoT.modificarCasilla(4,2,2);
		nuevoT.modificarCasilla(4,3,2);
		nuevoT.modificarCasilla(4,4,3);
		nuevoT.modificarCasilla(4,5,4);
		nuevoT.modificarCasilla(4,6,4);
		nuevoT.modificarCasilla(4,7,1);

		nuevoT.modificarCasilla(5,0,2);
		nuevoT.modificarCasilla(5,1,3);
		nuevoT.modificarCasilla(5,2,4);
		nuevoT.modificarCasilla(5,3,3);
		nuevoT.modificarCasilla(5,4,1);
		nuevoT.modificarCasilla(5,5,1);
		nuevoT.modificarCasilla(5,6,4);
		nuevoT.modificarCasilla(5,7,3);

		nuevoT.modificarCasilla(6,0,1);
		nuevoT.modificarCasilla(6,1,2);
		nuevoT.modificarCasilla(6,2,2);
		nuevoT.modificarCasilla(6,3,3);
		nuevoT.modificarCasilla(6,4,2);
		nuevoT.modificarCasilla(6,5,3);
		nuevoT.modificarCasilla(6,6,3);
		nuevoT.modificarCasilla(6,7,1);

		nuevoT.modificarCasilla(7,0,2);
		nuevoT.modificarCasilla(7,1,3);
		nuevoT.modificarCasilla(7,2,1);
		nuevoT.modificarCasilla(7,3,4);
		nuevoT.modificarCasilla(7,4,1);
		nuevoT.modificarCasilla(7,5,2);
		nuevoT.modificarCasilla(7,6,1);
		nuevoT.modificarCasilla(7,7,2);

		nuevoT.modificarCasilla(8,0,1);
		nuevoT.modificarCasilla(8,1,4);
		nuevoT.modificarCasilla(8,2,1);
		nuevoT.modificarCasilla(8,3,1);
		nuevoT.modificarCasilla(8,4,2);
		nuevoT.modificarCasilla(8,5,2);
		nuevoT.modificarCasilla(8,6,2);
		nuevoT.modificarCasilla(8,7,1);

		nuevoT.modificarCasilla(9,0,2);
		nuevoT.modificarCasilla(9,1,2);
		nuevoT.modificarCasilla(9,2,2);
		nuevoT.modificarCasilla(9,3,4);
		nuevoT.modificarCasilla(9,4,2);
		nuevoT.modificarCasilla(9,5,3);
		nuevoT.modificarCasilla(9,6,3);
		nuevoT.modificarCasilla(9,7,4);

		nuevoT.modificarCasilla(10,0,4);
		nuevoT.modificarCasilla(10,1,2);
		nuevoT.modificarCasilla(10,2,2);
		nuevoT.modificarCasilla(10,3,3);
		nuevoT.modificarCasilla(10,4,3);
		nuevoT.modificarCasilla(10,5,2);
		nuevoT.modificarCasilla(10,6,2);
		nuevoT.modificarCasilla(10,7,1);

		nuevoT.modificarCasilla(11,0,2);
		nuevoT.modificarCasilla(11,1,1);
		nuevoT.modificarCasilla(11,2,2);
		nuevoT.modificarCasilla(11,3,2);
		nuevoT.modificarCasilla(11,4,1);
		nuevoT.modificarCasilla(11,5,1);
		nuevoT.modificarCasilla(11,6,2);
		nuevoT.modificarCasilla(11,7,1);
		
		return nuevoT;
	}

}
