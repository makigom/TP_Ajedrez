package CapaDeEntidades;

public class Peon extends Ficha 
{
	// como valido para comer? se debe mover para el costado
	@Override
<<<<<<< HEAD
	public boolean validarMovimiento(Posicion ini, Posicion fin, char color) {

		if(color == 'B' || color == 'b'){
			
			if (((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;		
			else if(((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() + 2 == fin.getNumero())&& (ini.getNumero() == '2') && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;	
			else return false;
			
		} 
		else if (color == 'N' || color == 'n'){
			
			if (((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() - 1 == fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;		
			else if(((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() - 2 == fin.getNumero())&& (ini.getNumero() == '7') && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;	
			else return false;
			
		}
		else return false;
		
=======
	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		// TODO Auto-generated method stub 
		return false;
>>>>>>> origin/master
	}

	public static void setPeones() {
		// TODO Auto-generated method stub
		
	}

}
