package CapaDeEntidades;

public class Dama extends Ficha {

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		
		if ((ini.getLetra() == fin.getLetra()) && validarTablero(ini, fin) && (ini.getNumero() != fin.getNumero())) return true;

		 else if ((ini.getNumero() == fin.getNumero()) && validarTablero(ini, fin) && (ini.getLetra() != fin.getLetra())) return true;
			 
		 else if ((ini.getLetra() != fin.getLetra()) && (ini.getNumero() != fin.getNumero()) && validarTablero(ini, fin)) return true;	
	
		else return false;
	}

	public static void SetDamas() {
		// TODO Auto-generated method stub
		
	}

}
