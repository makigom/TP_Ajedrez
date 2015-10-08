package CapaDePresentación;

import java.lang.String;

import CapaDeEntidades.Jugador;
import appExceptions.ApplicationException;
import CapaDeNegocio.CtrlJugador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMRegistro {

	private static final Exception ApplicationException = null;
	private JFrame frmRegistrarJugador;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellido;
	
	private CtrlJugador ctrlAj = new CtrlJugador();

	/**
	 * Launch the application.
	 */
	public static void invocador(/*String[] args*/) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMRegistro window = new ABMRegistro();
					window.frmRegistrarJugador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ABMRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarJugador = new JFrame();
		frmRegistrarJugador.setTitle("Registrar Jugador");
		frmRegistrarJugador.setBounds(100, 100, 384, 242);
		frmRegistrarJugador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrarJugador.getContentPane().setLayout(null);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(34, 33, 46, 14);
		frmRegistrarJugador.getContentPane().add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(34, 72, 46, 14);
		frmRegistrarJugador.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(34, 110, 46, 14);
		frmRegistrarJugador.getContentPane().add(lblApellido);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(114, 30, 128, 20);
		frmRegistrarJugador.getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(114, 69, 128, 20);
		frmRegistrarJugador.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(114, 107, 128, 20);
		frmRegistrarJugador.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					guardar();
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(67, 155, 89, 23);
		frmRegistrarJugador.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				confirmar();
			}

		});
		btnCancelar.setBounds(199, 155, 89, 23);
		frmRegistrarJugador.getContentPane().add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar();
			}

		});
		btnBuscar.setBounds(252, 29, 89, 23);
		frmRegistrarJugador.getContentPane().add(btnBuscar);
	}
	
	protected Jugador mapearDeDatos(){
		Jugador j = new Jugador();
		j.setDni(txtDNI.getText());
		j.setApellido(txtApellido.getText());
		j.setNombre(txtNombre.getText());
		return j;
	}
	
	protected void mapearADatos(Jugador j){
		txtDNI.setText(String.valueOf(j.getDni()));
		txtNombre.setText(String.valueOf(j.getNombre()));
		txtApellido.setText(String.valueOf(j.getApellido()));
	}
	
	protected void guardar() throws ApplicationException{
		Jugador j = this.mapearDeDatos();
		try { 
			
			if() ctrlAj.save(j);
			else throw ApplicationException;
			
		} catch (ApplicationException ae){
			JOptionPane.showMessageDialog(null,"El usuario ya se encuentra registrado","Error", JOptionPane.ERROR_MESSAGE);
		}
		int reply = JOptionPane.showConfirmDialog(null,"¿Desea agregar un jugador mas?", "Si",JOptionPane.YES_NO_OPTION);
		if(reply == JOptionPane.NO_OPTION){
			ABMIniciarSesion.main(null);
			this.frmRegistrarJugador.setVisible(false);
		}
	}
	
	private void confirmar() {
		int reply = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION){
			ABMIniciarSesion.main(null);
			this.frmRegistrarJugador.setVisible(false);
		}
		
	}
	
	private void buscar() {
		Jugador j = ctrlAj.getByDni(txtDNI.getText());
		if (j==null){
			JOptionPane.showMessageDialog(null, "No se ha encontrado el DNI", "Error al buscar",JOptionPane.INFORMATION_MESSAGE);
		} else {
			this.mapearADatos(j);
		}
	}
}
