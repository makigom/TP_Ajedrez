package CapaDeDatos;

import java.sql.*;

import appExceptions.ApplicationException;
import CapaDeEntidades.Jugador;
import CapaDeEntidades.Partida;

public class DataPartida {

	public DataPartida(){
		
	}
	
	public Partida buscarPartida(String dni1, String dni2) {
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
		
	}


