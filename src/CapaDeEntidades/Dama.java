package CapaDeEntidades;

public class Dama extends Ficha {

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		
		if ((ini.getLetra() == fin.getLetra()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (ini.getNumero() != fin.getNumero())) return true;

		 else if ((ini.getNumero() == fin.getNumero()) && (fin.getLetra() >= 'a') && (fin.getLetra() <= 'h') && (ini.getLetra() != fin.getLetra())) return true;
			 
		if ((ini.getLetra() != fin.getLetra()) && (ini.getNumero() != fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;	
	
		else return false;
	}

	public static void SetDamas() {
		// TODO Auto-generated method stub
		
	}

}
