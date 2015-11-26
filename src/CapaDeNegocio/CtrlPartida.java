package CapaDeNegocio;

import CapaDeEntidades.*;

import java.util.ArrayList;

import appExceptions.ApplicationException;
import CapaDeDatos.*;

public class CtrlPartida {
	
	private DataPartida datosPartida;
	ArrayList<Ficha> fichasPartida = new ArrayList<Ficha>();	
	public CtrlPartida(){
		
		datosPartida = new DataPartida();
	}
	
	Partida partida = new Partida(); 

	public Partida recuperarPartida(String dni1, String dni2) throws ApplicationException {
		partida = datosPartida.buscarPartida(dni1,dni2);
		
		if(partida == null){ 
			
			partida = datosPartida.crearPartida(dni1, dni2);

		}
		fichasPartida = partida.getFichas();
		return partida;
	}

	public boolean validarJugada(Posicion posOrigen, Posicion posDestino, Partida part) {
		
		char color;
		if(part.getTurno() == true) color = 'B';
		else color = 'N';
		
		//recorre todo el arreglo fichasPartida en busca de la ficha que se encuentre en posOrigen, si la encuentra, el mov es valido, la ficha no esta  y esa ficha corresponde a ese turno, hace los cambios y retorna true
		for (Ficha f : fichasPartida) {
			if (f.getPosicion() == posOrigen && f.getEstado() && f.getColor() == String.valueOf(color)) {
				if (f.getTipoFicha() != 'P') {
					if(f.validarMovimiento(posOrigen, posDestino)){
						for (Ficha fic : fichasPartida) {
							if(f.getPosicion() == fic.getPosicion()) {
								fic.setEstado(false); //No se considera si come una ficha propia o no
								f.setPosicion(posDestino);
								return true;
							}
						}
					}
				}
				else {
					if(f.validarMovimiento(posOrigen, posDestino, color)){
						for (Ficha fic : fichasPartida) {
							if(f.getPosicion() == fic.getPosicion()) {
								fic.setEstado(false); //No se considera si come una ficha propia o no
								f.setPosicion(posDestino);
								return true;
							}
						}
					}
				}
			}
		}
	
		return false;
		
	}

	public boolean guardarPartida(Partida part) throws ApplicationException {
		// TODO Auto-generated method stub
		if(datosPartida.savePartida(part)) return true;
		else return false;
	}

}
