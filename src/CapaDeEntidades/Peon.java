package CapaDeEntidades;

public class Peon extends Ficha 
{
	public Peon(char i, int j, char c, boolean b, int id) {
		this.posicion.setNumero(j);
		this.posicion.setLetra(i);
		this.setColor(c);
		this.setEstado(b);
		this.setIdFicha(id);
		}

	// como valido para comer? se debe mover para el costado
	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin, char color) {

		if(color == 'B' || color == 'b'){
			
			if (((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() + 1 == fin.getNumero()) && validarTablero(fin)) return true;		
			else if(((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() + 2 == fin.getNumero())&& (ini.getNumero() == '2') && validarTablero(fin)) return true;	
			else return false;
			
		} 
		else if (color == 'N' || color == 'n'){
			
			if (((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() - 1 == fin.getNumero()) && validarTablero(fin)) return true;		
			else if(((char)ini.getLetra() == (char)fin.getLetra()) && (ini.getNumero() - 2 == fin.getNumero())&& (ini.getNumero() == '7') && validarTablero(fin)) return true;	
			else return false;
			
		}
		else return false;
}


}
