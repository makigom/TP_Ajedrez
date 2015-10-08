package CapaDeNegocio;

import appExceptions.ApplicationException;

import CapaDeEntidades.Jugador;

import CapaDeDatos.DataJugador;

public class CtrlJugador {
	
	private DataJugador catalogo;
	
	public CtrlJugador(){
		catalogo = new DataJugador();
	}

	public void save(Jugador j) throws ApplicationException {
		if (catalogo.getByDni(j.getDni())== null){
			catalogo.add(j);
		} else {
			catalogo.update(j);
		}
	}
	
	public Jugador getByDni(String dni){
		return catalogo.getByDni(dni);
	}

}
