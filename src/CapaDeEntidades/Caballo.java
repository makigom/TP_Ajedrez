package CapaDeEntidades;

public class Caballo extends Ficha {

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		
		if(((char)ini.getLetra() + 1 == (char)fin.getLetra()) && (ini.getNumero() + 2 == fin.getNumero()) && validarTablero(ini, fin)) return true;
		else if (((char)ini.getLetra() + 2 == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && validarTablero(ini, fin)) return true;
		else if (((char)ini.getLetra() + 2 == (char)fin.getLetra()) && (ini.getNumero() - 1 == fin.getNumero()) && validarTablero(ini, fin)) return true;
		else if (((char)ini.getLetra() + 1 == (char)fin.getLetra()) && (ini.getNumero() - 2 == fin.getNumero()) && validarTablero(ini, fin)) return true;
		else if (((char)ini.getLetra() - 1 == (char)fin.getLetra()) && (ini.getNumero() - 2 == fin.getNumero()) && validarTablero(ini, fin)) return true;
		else if (((char)ini.getLetra() - 2 == (char)fin.getLetra()) && (ini.getNumero() - 1 == fin.getNumero()) && validarTablero(ini, fin)) return true;
		else if (((char)ini.getLetra() - 2 == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && validarTablero(ini, fin)) return true;
		else if (((char)ini.getLetra() - 1 == (char)fin.getLetra()) && (ini.getNumero() + 2 == fin.getNumero()) && validarTablero(ini, fin)) return true;

		else return false;
		
	}

	public static void SetCaballos() {
		// TODO Auto-generated method stub
		
	}

}
