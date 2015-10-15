package CapaDeEntidades;

public class Rey extends Ficha {

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {

		if (((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;
		else if (((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() - 1 == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;
		else if (((char)ini.getLetra() + 1 == (char)fin.getLetra()) && (ini.getNumero() == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;
		else if (((char)ini.getLetra() - 1 == (char)fin.getLetra()) && (ini.getNumero() == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;
		else if (((char)ini.getLetra() + 1 == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;
		else if (((char)ini.getLetra() + 1 == (char)fin.getLetra()) && (ini.getNumero() - 1 == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;
		else if (((char)ini.getLetra() - 1 == (char)fin.getLetra()) && (ini.getNumero() -1  == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;
		else if (((char)ini.getLetra() - 1 == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;
		else return false;
		
	}

	public static void SetReyes() {
		// TODO Auto-generated method stub
		
	}

}
