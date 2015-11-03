package CapaDeEntidades;

public class Alfil extends Ficha {

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {

		//falta validar que si en su camino se encuentra otra pieza, no puede moverse mas alla de esta
		if ((ini.getLetra() != fin.getLetra()) && (ini.getNumero() != fin.getNumero()) && validarTablero(ini, fin)) return true;	
		else return false;
	
	}

	public static void SetAlfiles() {
		// TODO Auto-generated method stub
		
	}

}
