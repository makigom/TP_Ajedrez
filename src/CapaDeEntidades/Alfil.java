package CapaDeEntidades;

import java.util.ArrayList;

public class Alfil extends Ficha {

	@Override
	public boolean validarMovimiento() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validarPosicion() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//pasar array de tipo ficha a un metodo estatico
	public static void setearPosiciones(ArrayList<Ficha> fichas){
		
	}

}
