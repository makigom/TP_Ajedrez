package CapaDeEntidades;

public class Torre extends Ficha {


	public boolean validarMovimiento(Posicion ini, Posicion fin, Ficha f){
		
		boolean valido = true;
		
		 char origenL = ini.getLetra();
		 int origenN = ini.getNumero();
		 
		 char destinoL = fin.getLetra();
		 int destinoN = fin.getNumero();
		 
		 if (origenL == destinoL && (destinoN<8) && (destinoN>1))
		 {
			ini.setLetra(fin.getLetra());
			ini.setNumero(fin.getNumero());
			
			return valido;
		 }
		
		
		
		return false
	}
}
