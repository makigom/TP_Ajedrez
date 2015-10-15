package CapaDeEntidades;

public class Alfil extends Ficha {

	public Alfil(char i, int j, char c, boolean b, int id) {
		this.posicion.setNumero(j);
		this.posicion.setLetra(i);
		this.setColor(c);
		this.setEstado(b);
		this.setIdFicha(id);
	}

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {

		//falta validar que si en su camino se encuentra otra pieza, no puede moverse mas alla de esta
		if ((ini.getLetra() != fin.getLetra()) && (ini.getNumero() != fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;	
		else return false;
	
	}

	public static void SetAlfiles() {
		// TODO Auto-generated method stub
		
	}

}
