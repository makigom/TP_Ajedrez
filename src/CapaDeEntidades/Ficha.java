package CapaDeEntidades;

import java.util.ArrayList;

public abstract class Ficha{
	
	private int idFicha;
	private boolean estado;
	private char color;
	private Posicion posicion; 
	

	public static void SetearFichas(Ficha[] fichas){
		
		Peon.setPeones();
		Torre.SetTorres(fichas);
		Alfil.SetAlfiles(fichas);
		Rey.SetReyes(fichas);
		Dama.SetDamas(fichas);
		Caballo.SetCaballos(fichas);
		
		
	}
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
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
