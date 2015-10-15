package CapaDeEntidades;

public class Rey extends Ficha {

	public Rey(char i, int j, char c, boolean b, int id) {
		this.posicion.setNumero(j);
		this.posicion.setLetra(i);
		this.setColor(c);
		this.setEstado(b);
		this.setIdFicha(id);
	}

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void SetReyes() {
		// TODO Auto-generated method stub
		
	}

}
