package CapaDeDatos;

import java.sql.*;
import java.util.ArrayList;

import appExceptions.ApplicationException;
import CapaDeEntidades.Ficha;
import CapaDeEntidades.Jugador;
import CapaDeEntidades.Partida;
import CapaDeEntidades.Posicion;

public class DataPartida {

	public DataPartida(){
		
	}
	
	public Partida buscarPartida(String dni1, String dni2) {
		//en buscar partida deberia devolver tambien los jugadores que busca
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Partida part = null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select idPartida, turno from partidas where dniJugadorBlanco = ? and dniJugadorNegro = ?");
			stmt.setString(1, dni1);
			stmt.setString(2, dni2);
			rs = stmt.executeQuery(); 
			
			if(rs !=null && rs.next()){
				part = new Partida();
				part.setIdPartida(rs.getInt("idPartida")); 
				part.setTurno(rs.getString("turno"));
				//PREGUNTAR!!!!
				//part.setJugadorBlanco.
				//part.setJugadorNegro(rs.getString("dniJugadorNegro"));
			}
		} catch (SQLException e){			
			e.printStackTrace();
		}
		finally{
			
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		return part;
	}

	public Partida crearPartida(String dni1, String dni2) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Partida part = new Partida();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into partidas(turno, dniJugadorBlanco, dniJugadorNegro) values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, part.getTurno());
			stmt.setString(2, dni1);
			stmt.setString(3, dni2);
			stmt.execute();
			
			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				part.setIdPartida(rs.getInt(1));
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
	
		return part;
	}

	public boolean getFicha(Posicion posOrigen, Posicion posDestino,Partida part) {

		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Ficha fic;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select idFicha, estadoFicha, color from fichas inner join posiciones on fichas.idFicha = posiciones.idFicha inner join partidas on partidas.idPartida = posiciones.idPartida where posiciones.letra = ? and posiciones.numero = ?" );
			
			stmt.setString(1, String.valueOf(posOrigen.getLetra()));
			stmt.setInt(2, posOrigen.getNumero());
			stmt.execute();
			
			if(rs !=null && rs.next()){
				// hay que buscar el tipo de ficha con el idFicha y llamar a la subclase relacionada al id
				return true;
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
	
		return false;

	}

	public ArrayList<Ficha> obtenerFichas() {
		
		return null;
	}
	
	
}


