package CapaDeEntidades;

public class Posicion {
	
	private char letra;
	private int numero;
	private Ficha_Partida FicPart;
	
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Ficha_Partida getFicPart() {
		return FicPart;
	}
	public void setFicPart(Ficha_Partida ficPart) {
		FicPart = ficPart;
	}

}
