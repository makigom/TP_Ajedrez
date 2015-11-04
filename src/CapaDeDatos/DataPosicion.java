package CapaDeDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CapaDeEntidades.*; 

public class DataPosicion {
	
	public DataPosicion(){
		
	}
	//preguntar del workbench, no nos toma la foreignKey de posiciones
	public Posicion buscarPosiciones(int idFicha){
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Posicion pos = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select letra, numero from posiciones where posiciones.idFicha = ? " );
			
			stmt.setString(1, String.valueOf(idFicha));
			rs = stmt.executeQuery();
			
			if(rs !=null && rs.next()){
				
				pos = new Posicion();
				pos.setLetra(rs.getString("letra").charAt(0));
				pos.setNumero(rs.getInt("numero"));
				
			}
			
		}
				
		catch(SQLException e){
			
			e.printStackTrace();	
		}
		finally{
			
			try {
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				
			} catch(SQLException e){
				
				e.printStackTrace();
				
			}
			finally{
				
				FactoryConexion.getInstancia().releaseConn();
				
			}
			
		}
		
		return pos;
		
	}

}
