package ec.edu.ups.appdis.g1.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCrearUsuarioAdministrativo {

	private JFrame frame;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtRol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearUsuarioAdministrativo window = new VentanaCrearUsuarioAdministrativo();
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
	public VentanaCrearUsuarioAdministrativo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(66, 8, 86, 20);
		frame.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(10, 87, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rol");
		lblNewLabel_3.setBounds(10, 130, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 39, 86, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(66, 84, 86, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtRol = new JTextField();
		txtRol.setBounds(66, 127, 86, 20);
		frame.getContentPane().add(txtRol);
		txtRol.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrear.setBounds(66, 158, 89, 23);
		frame.getContentPane().add(btnCrear);
	}
}
