package CapaDeNegocio;

import CapaDeEntidades.*;
import CapaDeDatos.*;

public class CtrlPartida {
	
	private DataPartida datosPartida;
	
	public CtrlPartida(){
		datosPartida = new DataPartida();
	}
	
	Partida partida = new Partida(); 

	public Partida recuperarPartida(String dni1, String dni2) {
		if(datosPartida.buscarPartida(dni1,dni2) == null){ 
			partida = datosPartida.crearPartida(dni1, dni2);			
		}
		else partida = datosPartida.buscarPartida(dni1,dni2);
		
		return partida;
	}

	public boolean validarJugada(Posicion posOrigen, Posicion posDestino, Partida part) {
		
		return datosPartida.validarJugada(posOrigen, posDestino, part);
		
	}
}
