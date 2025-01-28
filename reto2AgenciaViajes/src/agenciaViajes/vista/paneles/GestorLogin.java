package agenciaViajes.vista.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GestorLogin {

	
	private JPanel panelLogin = null;
	private JTextField tfNomAgencia;
	private JTextField tfContraseña;


	/**
	 * Create the frame.
	 */
	public GestorLogin(ArrayList<JPanel> paneles) {
		
		panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 1039, 666);
		panelLogin.setLayout(null);
		
		JLabel lblNomAgencia = new JLabel("Nombre Agencia");
		lblNomAgencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomAgencia.setBounds(254, 215, 181, 23);
		panelLogin.add(lblNomAgencia);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setBounds(254, 277, 181, 23);
		panelLogin.add(lblContraseña);
		
		tfNomAgencia = new JTextField();
		tfNomAgencia.setBounds(445, 216, 266, 20);
		panelLogin.add(tfNomAgencia);
		tfNomAgencia.setColumns(10);
		
		tfContraseña = new JTextField();
		tfContraseña.setColumns(10);
		tfContraseña.setBounds(445, 278, 266, 20);
		panelLogin.add(tfContraseña);
		
		JButton btnIniSesion = new JButton("Iniciar Sesión");
		btnIniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnIniSesion.setBounds(351, 355, 157, 23);
		panelLogin.add(btnIniSesion);
		
		JButton btnNuevaAgencia = new JButton("Nueva Agencia");
		btnNuevaAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(1).setVisible(false);
				paneles.get(9).setVisible(true);
			}
		});
		btnNuevaAgencia.setBounds(554, 355, 157, 23);
		panelLogin.add(btnNuevaAgencia);
	}

	
	/**
	 * Devuelve el panel.
	 * @return panel.
	 */
	public JPanel getPanel() {
		
		return panelLogin;
	}
}