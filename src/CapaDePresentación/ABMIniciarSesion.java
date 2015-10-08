package CapaDePresentación;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;

public class ABMIniciarSesion {

	private JFrame frmIniciarSesion;
	private JTextField txtDNIJugador1;
	private JTextField txtDniJugador2;

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
		frmIniciarSesion.setBounds(100, 100, 424, 208);
		frmIniciarSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIniciarSesion.getContentPane().setLayout(null);
		
		JLabel lblDniJugador1 = new JLabel("DNI Jugador 1");
		lblDniJugador1.setBounds(42, 51, 76, 14);
		frmIniciarSesion.getContentPane().add(lblDniJugador1);
		
		txtDNIJugador1 = new JTextField();
		txtDNIJugador1.setBounds(149, 48, 132, 20);
		frmIniciarSesion.getContentPane().add(txtDNIJugador1);
		txtDNIJugador1.setColumns(10);
		
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
		
		JLabel lblDniJugador2 = new JLabel("DNI Jugador 2");
		lblDniJugador2.setBounds(42, 92, 76, 14);
		frmIniciarSesion.getContentPane().add(lblDniJugador2);
		
		txtDniJugador2 = new JTextField();
		txtDniJugador2.setBounds(149, 89, 132, 20);
		frmIniciarSesion.getContentPane().add(txtDniJugador2);
		txtDniJugador2.setColumns(10);
	}
	
	protected void BotonIngresar(){
		ABMPartida.invocador();
		//Acá escribir todas las funciones del boton
		this.frmIniciarSesion.setVisible(false);
	}
	

	private void BotonRegistrar() {
		ABMRegistro.invocador();
		this.frmIniciarSesion.setVisible(false);
	}
}
