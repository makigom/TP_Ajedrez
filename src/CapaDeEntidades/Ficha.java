package CapaDeEntidades;

public abstract class Ficha{
	
	private int idFicha;
	private boolean estado;
	private char color;
	private static char tipo;
	
	public static char getTipo() {
		return tipo;
	}

	public static void setTipo(char tipo) {
		Ficha.tipo = tipo;
	}

	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		return false;
	}
	
	public int getIdFicha() {
		return idFicha;
	}
	public void setIdFicha(int idFicha) {
		this.idFicha = idFicha;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	
}
