package CapaDeEntidades;

public class Posicion {
	
	private char letra;
	private int numero;
	private Ficha_Partida FicPart;
	
	public char getLetra() {
		return letra;
	}
	public void setLetra(char c) {
		this.letra = c;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int i) {
		this.numero = i;
	}
	public Ficha_Partida getFicPart() {
		return FicPart;
	}
	public void setFicPart(Ficha_Partida ficPart) {
		FicPart = ficPart;
	}

}
