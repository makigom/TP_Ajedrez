package CapaDeEntidades;

public class Torre extends Ficha {

	public Torre(char i, int j, char c, boolean b, int id){
		this.posicion.setNumero(j);
		this.posicion.setLetra(i);
		this.setColor(c);
		this.setEstado(b);
		this.setIdFicha(id);
		
	}
	
	public boolean validarMovimiento(Posicion ini, Posicion fin){

		// correcciones que no deje mover al mismo lugar y validacion de letra en el elseif
		//falta validar que si en su camino se encuentra otra pieza, no puede moverse mas alla de esta
				 
		 if ((ini.getLetra() == fin.getLetra()) && validarTablero(fin) && (ini.getNumero() != fin.getNumero())){
			 
			
			return true;
		 }
		 else if ((ini.getNumero() == fin.getNumero()) && validarTablero(fin) && (ini.getLetra() != fin.getLetra())){
			 
			 //ini.setLetra(fin.getLetra());
			 //ini.setNumero(fin.getNumero());
			 return true;
			 
		 }
		 else return false;
	}

}
