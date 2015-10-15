package CapaDeEntidades;

import java.util.ArrayList;

public abstract class Ficha{
	
	private int idFicha;
	private boolean estado;
	private char color;
	protected Posicion posicion; 

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public static void SetearFichas(ArrayList<Ficha> fichas){
		
		
		int id = 0;
		/*for (int i = 0; i<32; i++){
			fichas[i].setEstado(true);
	        fichas[i].setIdFicha(id);           
	        id++;
		}
		*/
		//SETEAR FICHAS BLANCAS -
		for (char i='a'; i<'h';i++){
			
			for(int j = 1; j <= 8; j++){
				if((i=='a' && j == 1) || (i=='h' && j==1)){					
					Torre t = new Torre(i, j, 'B', true, id);
					fichas.add(t);
					}
				else if((i=='b' && j == 1) || (i=='g' && j==1)){
					Caballo c = new Caballo(i, j, 'B', true, id);
					fichas.add(c);
					}
				else if((i=='c' && j == 1) || (i=='f' && j==1)){
					Alfil a = new Alfil(i, j, 'B', true, id);
					fichas.add(a);
					}
				//FALTA LA DAMA
				else if((i=='e') && (j == 1)){
					Rey r = new Rey(i, j, 'B', true, id);
					fichas.add(r);
					}
				
					
				}
			}
		}
		
		Dama.SetDamas(fichas);
		Peon.setPeones();
		Torre.SetTorres(fichas);
		Alfil.SetAlfiles(fichas);
		Rey.SetReyes(fichas);
		
		Caballo.SetCaballos(fichas);
		
		
	}
	
	
	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		return false;
	}
	
	public boolean validarMovimiento(Posicion ini, Posicion fin, char color) {
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
