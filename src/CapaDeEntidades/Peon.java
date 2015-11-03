package CapaDeEntidades;

public class Peon extends Ficha 
{
	// como valido para comer? se debe mover para el costado
	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin, char color) {

		if(color == 'B' || color == 'b'){
			
			if (((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && validarTablero(ini, fin)) return true;		
			else if(((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() + 2 == fin.getNumero())&& (ini.getNumero() == '2') && validarTablero(ini, fin)) return true;	
			else return false;
			
		} 
		else if (color == 'N' || color == 'n'){
			
			if (((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() - 1 == fin.getNumero()) && validarTablero(ini, fin)) return true;		
			else if(((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() - 2 == fin.getNumero())&& (ini.getNumero() == '7') && validarTablero(ini, fin)) return true;	
			else return false;
			
		}
		else return false;
}

	public static void setPeones() {
		// TODO Auto-generated method stub
		
	}

}
