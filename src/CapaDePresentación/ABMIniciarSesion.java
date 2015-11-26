package CapaDePresentación;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import CapaDeEntidades.Jugador;
import CapaDeEntidades.Partida;
import CapaDeEntidades.Posicion;
import CapaDeNegocio.CtrlJugador;
import CapaDeNegocio.CtrlPartida;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;

import javax.swing.JSplitPane;

import appExceptions.ApplicationException;

public class ABMIniciarSesion {

	private JFrame frmIniciarSesion;
	private JTextField txtBlancas;
	private JTextField txtNegras;

	private CtrlJugador ctrlJug = new CtrlJugador();
	private CtrlPartida ctrlPart = new CtrlPartida();
    Partida part = new Partida();
	private Posicion posOrigen = new Posicion();
	private Posicion posDestino = new Posicion();
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JTextField txtTurno;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMIniciarSesion window = new ABMIniciarSesion();
					window.frmIniciarSesion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ABMIniciarSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIniciarSesion = new JFrame();
		frmIniciarSesion.setTitle("Iniciar Sesi\u00F3n Jugadores");
		frmIniciarSesion.setBounds(100, 100, 408, 374);
		frmIniciarSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIniciarSesion.getContentPane().setLayout(null);
		
		JLabel lblBlancas = new JLabel("Blancas:");
		lblBlancas.setBounds(42, 51, 76, 14);
		frmIniciarSesion.getContentPane().add(lblBlancas);
		
		txtBlancas = new JTextField();
		txtBlancas.setBounds(149, 48, 132, 20);
		frmIniciarSesion.getContentPane().add(txtBlancas);
		txtBlancas.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					BotonIngresar();
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnIngresar.setBounds(291, 67, 89, 23);
		frmIniciarSesion.getContentPane().add(btnIngresar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BotonRegistrar();
			}

		});
		btnRegistrarse.setBounds(192, 127, 89, 23);
		frmIniciarSesion.getContentPane().add(btnRegistrarse);
		
		JLabel lblNegras = new JLabel("Negras:");
		lblNegras.setBounds(42, 92, 76, 14);
		frmIniciarSesion.getContentPane().add(lblNegras);
		
		txtNegras = new JTextField();
		txtNegras.setBounds(149, 89, 132, 20);
		frmIniciarSesion.getContentPane().add(txtNegras);
		txtNegras.setColumns(10);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setBounds(42, 169, 57, 14);
		frmIniciarSesion.getContentPane().add(lblJugador);
		
		txtOrigen = new JTextField();
		txtOrigen.setBounds(104, 202, 86, 20);
		frmIniciarSesion.getContentPane().add(txtOrigen);
		txtOrigen.setColumns(10);
		
		JLabel lblPosicionInicial = new JLabel("Origen:");
		lblPosicionInicial.setBounds(42, 205, 72, 14);
		frmIniciarSesion.getContentPane().add(lblPosicionInicial);
		
		JLabel lblNewLabel = new JLabel("Destino:");
		lblNewLabel.setBounds(42, 230, 46, 14);
		frmIniciarSesion.getContentPane().add(lblNewLabel);
		
		txtDestino = new JTextField();
		txtDestino.setBounds(104, 227, 86, 20);
		frmIniciarSesion.getContentPane().add(txtDestino);
		txtDestino.setColumns(10);
		
		JButton btnMover = new JButton("Mover");
		btnMover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				botonMover();
			}

		});
		btnMover.setBounds(104, 258, 89, 23);
		frmIniciarSesion.getContentPane().add(btnMover);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					botonGuardar();
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		btnGuardar.setBounds(104, 292, 89, 23);
		frmIniciarSesion.getContentPane().add(btnGuardar);
		
		txtTurno = new JTextField();
		txtTurno.setEditable(false);
		txtTurno.setBounds(104, 166, 86, 20);
		frmIniciarSesion.getContentPane().add(txtTurno);
		txtTurno.setColumns(10);
	}
	
	protected void BotonIngresar() throws ApplicationException{
		
		//optimizar con mapearDeDatos
		Jugador j1 = ctrlJug.getByDni(txtBlancas.getText());
		Jugador j2 = ctrlJug.getByDni(txtNegras.getText());

		if (j1==null || j2==null){
			JOptionPane.showMessageDialog(null, "Debe completar los dos jugadores o registrarse", "Error",JOptionPane.INFORMATION_MESSAGE);
		} else {
			
			String dni1 = j1.getDni();
			String dni2 = j2.getDni(); 
			part = ctrlPart.recuperarPartida(dni1, dni2);
			JOptionPane.showMessageDialog(null, "Partida Cargada con exito","Ajedrez",JOptionPane.INFORMATION_MESSAGE);
			if(part.getTurno()) txtTurno.setText(j1.getNombre());
			else txtTurno.setText(j2.getNombre());
			//Pasar partida al boton mover - HECHO CON VARIABLE DE CLASE
		} 
		
	}

	private void BotonRegistrar() {
		ABMRegistro.invocador();
		this.frmIniciarSesion.setVisible(false);
	}
	
//VALIDAR QUE NO INGRESE MAS DE DOS CARACTERES. Y VALIDAR TANTO LETRAS COMO NUMEROS. 5/11 MANEJAR EXCEPCION DE CAMPOS VACIOS
	
	private void botonMover() {
		//cambio pos por posOrigen y posDestino, con pos solo se sobreescribia el origen con el destino
		String origen;
		String destino;	
		
		origen = txtOrigen.getText();
		posOrigen.setLetra(origen.charAt(0)); 
		posOrigen.setNumero(Integer.parseInt(String.valueOf(origen.charAt(1))));
		
		destino = txtDestino.getText();
		posDestino.setLetra(destino.charAt(0)); 
		posDestino.setNumero(Integer.parseInt(String.valueOf(destino.charAt(1)))); 

		if(ctrlPart.validarJugada(posOrigen, posDestino, part)) {
			
			JOptionPane.showMessageDialog(null,"Movimiento realizado con éxito","Ajedrez", JOptionPane.INFORMATION_MESSAGE);
			if(part.getTurno() == false){
				part.setTurno(true) ;
				txtTurno.setText(part.getJugadorBlanco().getNombre());
				txtOrigen.setText(null);
				txtDestino.setText(null);
			}
			else if(part.getTurno()) {
				part.setTurno(false);
				txtTurno.setText(part.getJugadorNegro().getNombre());
				txtOrigen.setText(null);
				txtDestino.setText(null);
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Movimiento no valido","Error", JOptionPane.ERROR_MESSAGE);
			txtOrigen.setText(null);
			txtDestino.setText(null);
		}
		
	}
	
	//boton guardar todo de una en evento click
	private void botonGuardar() throws ApplicationException {
		// TODO Auto-generated method stub
		if(ctrlPart.guardarPartida(part)) JOptionPane.showMessageDialog(null,"Partida guardada con exito","Ajedrez",JOptionPane.INFORMATION_MESSAGE);
		else JOptionPane.showMessageDialog(null,"No se ha podido guardar la partida","Ajedrez",JOptionPane.ERROR_MESSAGE);
		
	}
}
