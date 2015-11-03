package CapaDeNegocio;

import CapaDeEntidades.*;

import java.util.ArrayList;

import CapaDeDatos.*;

public class CtrlPartida {
	
	private DataPartida datosPartida;
	
	public CtrlPartida(){
		datosPartida = new DataPartida();
	}
	
	Partida partida = new Partida(); 

	public Partida recuperarPartida(String dni1, String dni2) {
		if(datosPartida.buscarPartida(dni1,dni2) == null){ 
			ArrayList<Ficha> fichas = new ArrayList<Ficha>();			
			partida = datosPartida.crearPartida(dni1, dni2);
			Ficha.setearFichas(fichas);
			partida.setFichas(fichas);
		}
		else partida = datosPartida.buscarPartida(dni1,dni2);
		
		return partida;
	}

	public boolean validarJugada(Posicion posOrigen, Posicion posDestino, Partida part) {
		
		return datosPartida.getFicha(posOrigen, posDestino, part);
		//metodo datosPartida.cambiarPosicion si validarMovimiento de la ficha indicada da true
		
	}

	public ArrayList<Ficha> setearFichas(int idPartida) {
		
		ArrayList<Ficha> fichas = new ArrayList<Ficha>();
		fichas =datosPartida.obtenerFichas();
		
		return null;
	}
}
