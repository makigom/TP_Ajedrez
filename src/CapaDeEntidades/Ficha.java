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
		
		//SETEAR FICHAS BLANCAS -
		for (char i='a'; i<'h';i++){
			
			for(int j = 1; j <= 8; j++){
				if((i=='a' && j == 1) || (i=='h' && j==1)){					
					Torre t = new Torre(i, j, 'B', true, id);
					fichas.add(t);
					id++;
					}
				else if((i=='b' && j == 1) || (i=='g' && j==1)){
					Caballo c = new Caballo(i, j, 'B', true, id);
					fichas.add(c);
					id++;
					}
				else if((i=='c' && j == 1) || (i=='f' && j==1)){
					Alfil a = new Alfil(i, j, 'B', true, id);
					fichas.add(a);
					id++;
					}
				else if((i=='d') && (j == 1)){
					Dama d = new Dama(i, j, 'B', true, id);
					fichas.add(d);
					id++;
					}
				else if((i=='e') && (j == 1)){
					Rey r = new Rey(i, j, 'B', true, id);
					fichas.add(r);
					id++;
					}
				else if((i>='a') && (i<='h') && (j == 2)){
					Peon p = new Peon(i, j, 'B', true, id);
					fichas.add(p);
					id++;
					}
					
					}
					
				}
		
		//SETEAR FICHAS NEGRAS
			for (char i='a'; i<'h';i++){
				
				for(int j = 1; j <= 8; j++){
					if((i=='a' && j == 8) || (i=='h' && j==8)){					
						Torre t = new Torre(i, j, 'N', true, id);
						fichas.add(t);
						id++;
						}
					else if((i=='b' && j == 8) || (i=='g' && j==8)){
						Caballo c = new Caballo(i, j, 'N', true, id);
						fichas.add(c);
						id++;
						}
					else if((i=='c' && j == 8) || (i=='f' && j==8)){
						Alfil a = new Alfil(i, j, 'N', true, id);
						fichas.add(a);
						id++;
						}
					else if((i=='d') && (j == 8)){
						Dama d = new Dama(i, j, 'N', true, id);
						fichas.add(d);
						id++;
						}
					else if((i=='e') && (j == 8)){
						Rey r = new Rey(i, j, 'N', true, id);
						fichas.add(r);
						id++;
						}
					else if((i>='a') && (i<='h') && (j == 7)){
						Peon p = new Peon(i, j, 'N', true, id);
						fichas.add(p);
						id++;
						}
					
						
					}
			}
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
