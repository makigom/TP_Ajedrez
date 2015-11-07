package CapaDeNegocio;

import CapaDeEntidades.*;

import java.util.ArrayList;

import CapaDeDatos.*;

public class CtrlPartida {
	
	private DataPartida datosPartida;
	ArrayList<Ficha> fichasPartida = new ArrayList<Ficha>();	
	public CtrlPartida(){
		
		datosPartida = new DataPartida();
	}
	
	Partida partida = new Partida(); 

	public Partida recuperarPartida(String dni1, String dni2) {
		
		if(datosPartida.buscarPartida(dni1,dni2) == null){ 
			
			partida = datosPartida.crearPartida(dni1, dni2);

		}
		else partida = datosPartida.buscarPartida(dni1,dni2);
		fichasPartida = partida.getFichas();
		return partida;
	}

	public boolean validarJugada(Posicion posOrigen, Posicion posDestino, Partida part) {
		
		String color;
		if(part.getTurno() == true) color = "B";
		else color = "N";
		
		//recorre todo el arreglo fichasPartida en busca de la ficha que se encuentre en posOrigen, si la encuentra, el mov es valido, la ficha no esta  y esa ficha corresponde a ese turno, hace los cambios y retorna true
		for (Ficha f : fichasPartida) {
			
			if( f.getEstado() != false && f.validarMovimiento(posOrigen, posDestino) && f.getColor() == color){
								
				for (Ficha fic : fichasPartida) {
			
					if(f.getPosicion() == fic.getPosicion()) fic.setEstado(false); //No se considera si come una ficha propia o no
					
				}
				f.setPosicion(posDestino);
				return true;				
			}
			
		}
	
		return false;
		
	}

	public boolean guardarPartida(Partida part) {
		// TODO Auto-generated method stub
		if(datosPartida.savePartida(part)) return true;
		else return false;
	}

}
