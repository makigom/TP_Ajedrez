package CapaDeEntidades;

public abstract class Ficha{
	
	private int idFicha;
	private boolean estado;
	private char tipoFicha;
	private char color;
	
	public abstract boolean validarMovimiento();
	public abstract boolean validarPosicion();
	
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
	public char getTipoFicha() {
		return tipoFicha;
	}
	public void setTipoFicha(char tipoFicha) {
		this.tipoFicha = tipoFicha;
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}

}
