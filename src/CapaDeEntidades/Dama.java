package CapaDeEntidades;

import java.util.ArrayList;


public class Dama extends Ficha {

	public Dama(char i, int j, char c, boolean b, int id) {
		this.posicion.setNumero(j);
		this.posicion.setLetra(i);
		this.setColor(c);
		this.setEstado(b);
		this.setIdFicha(id);
	}

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		
		if ((ini.getLetra() == fin.getLetra()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (ini.getNumero() != fin.getNumero())) return true;

		else if ((ini.getNumero() == fin.getNumero()) && (fin.getLetra() >= 'a') && (fin.getLetra() <= 'h') && (ini.getLetra() != fin.getLetra())) return true;
			 
		else if ((ini.getLetra() != fin.getLetra()) && (ini.getNumero() != fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;	
	
		else return false;
	}

		
		
	}

}
