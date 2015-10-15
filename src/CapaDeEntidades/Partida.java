package CapaDeEntidades;

public class Partida 
{
	private int idPartida;
	private Jugador jugadorBlanco;
	private Jugador jugadorNegro;
	private String turno;

	public Partida() {
		// TODO Auto-generated constructor stub
	}

	public Jugador getJugadorBlanco() {
		return jugadorBlanco;
	}

	public void setJugadorBlanco(Jugador jugadorBlanco) {
		this.jugadorBlanco = jugadorBlanco;
	}

	public Jugador getJugadorNegro() {
		return jugadorNegro;
	}

	public void setJugadorNegro(Jugador jugadorNegro) {
		this.jugadorNegro = jugadorNegro;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
		
}
