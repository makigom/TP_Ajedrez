package CapaDeEntidades;

public abstract class Ficha{
	
	private int idFicha;
	private boolean estado;
	private char color;
	

	public boolean validarMovimiento() {
		return false;
	}
	public boolean validarPosicion() {
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
	
	public boolean validarTablero(Posicion ini, Posicion fin){
		
		return true;
	}

}
