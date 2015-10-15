package CapaDePresentación;

import java.awt.EventQueue;

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
				BotonIngresar();
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
				botonGuardar();
			}

		});
		btnGuardar.setBounds(104, 292, 89, 23);
		frmIniciarSesion.getContentPane().add(btnGuardar);
	}
	
	protected void BotonIngresar(){
		
		//optimizar con mapearDeDatos
		Jugador j1 = ctrlJug.getByDni(txtBlancas.getText());
		Jugador j2 = ctrlJug.getByDni(txtNegras.getText());

		if (j1==null || j2==null){
			JOptionPane.showMessageDialog(null, "Debe completar los dos jugadores", "Error",JOptionPane.INFORMATION_MESSAGE);
		} else {
			
			String dni1 = j1.getDni();
			String dni2 = j2.getDni();
			part = ctrlPart.recuperarPartida(dni1, dni2);
			part.
			//Pasar partida al boton mover - HECHO CON VARIABLE DE CLASE
		} 
		
	}

	private void BotonRegistrar() {
		ABMRegistro.invocador();
		this.frmIniciarSesion.setVisible(false);
	}
	
//VALIDAR QUE NO INGRESE MAS DE DOS CARACTERES. Y VALIDAR TANTO LETRAS COMO NUMEROS.
	private void botonMover() {
		//cambio pos por posOrigen y posDestino, con pos solo se sobreescribia el origen con el destino
		String origen;
		String destino;	
		
		origen = txtOrigen.getText();
		posOrigen.setLetra(origen.charAt(1)); 
		posOrigen.setNumero(origen.charAt(2));
		
		destino = txtDestino.getText();
		posDestino.setLetra(destino.charAt(1)); 
		posDestino.setNumero(Integer.parseInt(String.valueOf(destino.charAt(2)))); 

		if(ctrlPart.validarJugada(posOrigen, posDestino, part)) JOptionPane.showMessageDialog(null,"Movimiento realizado con éxito","Ajedrez", JOptionPane.INFORMATION_MESSAGE);
		else JOptionPane.showMessageDialog(null,"Movimiento no valido","Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	//boton guardar todo de una en evento click
	private void botonGuardar() {
		// TODO Auto-generated method stub
		//Acà habria que llamar a un metodo que valide si las posiciones de inicio y fin ingresadas
		// se encuenran dentro del tablero, y desp de ahi, ocuparse de validar los movs dependiendo de la ficha
		
	}
}
