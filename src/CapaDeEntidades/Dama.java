package CapaDeEntidades;

import java.util.ArrayList;


public class Dama extends Ficha {

	@Override
	public boolean validarMovimiento(Posicion ini, Posicion fin) {
		
		if ((ini.getLetra() == fin.getLetra()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (ini.getNumero() != fin.getNumero())) return true;

		else if ((ini.getNumero() == fin.getNumero()) && (fin.getLetra() >= 'a') && (fin.getLetra() <= 'h') && (ini.getLetra() != fin.getLetra())) return true;
			 
		else if ((ini.getLetra() != fin.getLetra()) && (ini.getNumero() != fin.getNumero()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (fin.getLetra() <= 'a') && (fin.getLetra() >= 'h')) return true;	
	
		else return false;
	}

	public static void SetDamas(Ficha[] fichas) {
		 for (int i=0; i<2; i++) {
			 	int a= 8;
		        fichas[i] = new Dama();		        
		        fichas[i].posicion.setLetra('d');
		        fichas[i].posicion.setNumero(a);
		        if(i%2 == 0) fichas[i].setColor('B');
		        else fichas[i].setColor('N');
		        a -= 7;
		    }
		
		
	}

}
