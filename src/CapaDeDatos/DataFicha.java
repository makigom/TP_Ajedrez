package CapaDeDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CapaDeEntidades.*; 

public class DataFicha
{
	public DataFicha() {
		
	}
	
	public ArrayList<Ficha> buscarFichas(int idPartida){
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<Ficha> fichas = new ArrayList<Ficha>();
		Ficha fic = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select idFicha, estadoFicha, color from fichas inner join posiciones on fichas.idFicha = posiciones.idFicha inner join partidas on partidas.idPartida = posiciones.idPartida where partida.idPartida = ? " );
			
			stmt.setString(1, String.valueOf(idPartida));
			rs = stmt.executeQuery();
			
			if(rs !=null && rs.next()){
				
				fic.setColor(rs.getString("color")); 
				fic.setIdFicha(rs.getInt("idFicha"));
				fic.setEstado(rs.getBoolean("estadoFicha"));
				fichas.add(fic);
				
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
		
		for (Ficha f : fichas) {
			DataPosicion datPos = new DataPosicion();
			f.setPosicion(datPos.buscarPosiciones(f.getIdFicha()));			
		}
		
		
		return fichas;
		
	}
}
