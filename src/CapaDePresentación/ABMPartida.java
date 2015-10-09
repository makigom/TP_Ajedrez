package CapaDePresentación;

import CapaDeEntidades.*;
import appExceptions.ApplicationException;
import CapaDeNegocio.CtrlPartida;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMPartida {

	private JFrame frame;
	private JTextField txtPosicionInicial;
	private JTextField txtPosicionFinal;
	
	private CtrlPartida ctrlPart = new CtrlPartida();
	private JTextField txtIdPartida;

	/**
	 * Launch the application.
	 */
	public static void invocador(/*String[] args*/) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMPartida window = new ABMPartida();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public ABMPartida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 276, 284);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPosicinInicial = new JLabel("Posici\u00F3n Inicial");
		lblPosicinInicial.setBounds(29, 127, 95, 14);
		frame.getContentPane().add(lblPosicinInicial);
		
		txtPosicionInicial = new JTextField();
		txtPosicionInicial.setBounds(147, 124, 86, 20);
		frame.getContentPane().add(txtPosicionInicial);
		txtPosicionInicial.setColumns(10);
		
		JLabel lblTipoDeFicha = new JLabel("Tipo de Ficha ");
		lblTipoDeFicha.setBounds(29, 90, 86, 14);
		frame.getContentPane().add(lblTipoDeFicha);
		
		JComboBox cboxTipoFicha = new JComboBox();
		cboxTipoFicha.setModel(new DefaultComboBoxModel(new String[] {"Alfil", "Caballo", "Dama", "Peon", "Rey", "Torre"}));
		cboxTipoFicha.setBounds(147, 87, 86, 20);
		frame.getContentPane().add(cboxTipoFicha);
		
		JLabel lblPosicinFinal = new JLabel("Posici\u00F3n Final");
		lblPosicinFinal.setBounds(29, 165, 86, 14);
		frame.getContentPane().add(lblPosicinFinal);
		
		txtPosicionFinal = new JTextField();
		txtPosicionFinal.setBounds(147, 162, 86, 20);
		frame.getContentPane().add(txtPosicionFinal);
		txtPosicionFinal.setColumns(10);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jugar();
			}
			
		});
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnJugar.setBounds(29, 200, 89, 23);
		frame.getContentPane().add(btnJugar);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setBounds(29, 58, 46, 14);
		frame.getContentPane().add(lblJugador);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(147, 200, 89, 23);
		frame.getContentPane().add(btnGuardar);
		
		txtIdPartida = new JTextField();
		txtIdPartida.setEditable(false);
		txtIdPartida.setBounds(147, 27, 86, 20);
		frame.getContentPane().add(txtIdPartida);
		txtIdPartida.setColumns(10);
		
		JLabel lblIdPartida = new JLabel("IDPartida");
		lblIdPartida.setBounds(29, 30, 46, 14);
		frame.getContentPane().add(lblIdPartida);
	}
		
	private void jugar() {
		
		ctrlPart.play();
		
	}
}
