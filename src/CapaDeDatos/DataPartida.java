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
		
		//Se le asignan los jugadores a la partida, falta asignarle el array de fichas
		DataJugador datJug = new DataJugador();
		DataFicha datFic = new DataFicha(); 
		part.setJugadorBlanco(datJug.getByDni(dni1));
		part.setJugadorNegro(datJug.getByDni(dni2));
		//se asigna en arreglo de fichas
		part.setFichas(datFic.buscarFichas(part.getIdPartida()));
		return part;
		
	}

	public Partida crearPartida(String dni1, String dni2) {//QUEDAMOS ACA 4/11 VER TURNO SI PONERLO EN BOOL O DEJARLO INT
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Partida part = new Partida();
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into partidas(turno, dniJugadorBlanco, dniJugadorNegro) values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, part.set); // ver
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
		
		//fichas = Ficha.setearFichas();
		//partida.setFichas(fichas);
		return part;
	}

}


