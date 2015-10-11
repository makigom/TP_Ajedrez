package CapaDeEntidades;

public class Torre extends Ficha {


	public boolean validarMovimiento(Posicion ini, Posicion fin, Ficha f){
		
		 //char origenL = ini.getLetra();
		 //int origenN = ini.getNumero();
		 
		 //char destinoL = fin.getLetra();
		 //int destinoN = fin.getNumero();
		 
		 if (ini.getLetra() == fin.getLetra() && (fin.getNumero()<8) && (fin.getNumero()>1))
		 {
			ini.setLetra(fin.getLetra());
			ini.setNumero(fin.getNumero());
			
			return true;
		 }
		 else if ((ini.getNumero() == fin.getNumero()))
		 {
			 ini.setLetra(fin.getLetra());
			 ini.setNumero(fin.getNumero());
			 return true;
		 }
		 else return false;
	}
}
