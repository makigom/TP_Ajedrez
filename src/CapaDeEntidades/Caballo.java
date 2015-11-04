package CapaDeEntidades;

public class Caballo extends Ficha {
	
	
	public Caballo(char i, int j, String c, boolean b, int id) {
		this.posicion.setNumero(j);
		this.posicion.setLetra(i);
		this.setColor(c);
		this.setEstado(b);
		this.setIdFicha(id);
	}

	

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		
		if(((char)ini.getLetra() + 1 == (char)fin.getLetra()) && (ini.getNumero() + 2 == fin.getNumero()) && validarTablero(fin)) return true;
		else if (((char)ini.getLetra() + 2 == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && validarTablero(fin)) return true;
		else if (((char)ini.getLetra() + 2 == (char)fin.getLetra()) && (ini.getNumero() - 1 == fin.getNumero()) && validarTablero(fin)) return true;
		else if (((char)ini.getLetra() + 1 == (char)fin.getLetra()) && (ini.getNumero() - 2 == fin.getNumero()) && validarTablero(fin)) return true;
		else if (((char)ini.getLetra() - 1 == (char)fin.getLetra()) && (ini.getNumero() - 2 == fin.getNumero()) && validarTablero(fin)) return true;
		else if (((char)ini.getLetra() - 2 == (char)fin.getLetra()) && (ini.getNumero() - 1 == fin.getNumero()) && validarTablero(fin)) return true;
		else if (((char)ini.getLetra() - 2 == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && validarTablero(fin)) return true;
		else if (((char)ini.getLetra() - 1 == (char)fin.getLetra()) && (ini.getNumero() + 2 == fin.getNumero()) && validarTablero(fin)) return true;

		else return false;
		
	}



}
