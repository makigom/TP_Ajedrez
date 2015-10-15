package CapaDeEntidades;

public class Torre extends Ficha {

	
	public boolean validarMovimiento(Posicion ini, Posicion fin){

		// correcciones que no deje mover al mismo lugar y validacion de letra en el elseif
		//falta validar que si en su camino se encuentra otra pieza, no puede moverse mas alla de esta
				 
		 if ((ini.getLetra() == fin.getLetra()) && (fin.getNumero()<= 8) && (fin.getNumero()>=1) && (ini.getNumero() != fin.getNumero())){
			 
			
			return true;
		 }
		 else if ((ini.getNumero() == fin.getNumero()) && (fin.getLetra() >= 'a') && (fin.getLetra() <= 'h') && (ini.getLetra() != fin.getLetra())){
			 
			 //ini.setLetra(fin.getLetra());
			 //ini.setNumero(fin.getNumero());
			 return true;
			 
		 }
		 else return false;
	}

	public static void SetTorres() {
		// TODO Auto-generated method stub
		
	}
}
