package agenciaViajes.vista.paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Panel para la creación de un nuevo perfil de agencia. Permite ingresar
 * nombre, color de marca (hexadecimal), número de empleados, URL del logo y
 * tipo de agencia. Incluye botones para guardar y cancelar.
 */
public class GestorNuevoPerfil {

	private JPanel panelNuevoPerfil;
	private JTextField textFieldNombreAgencia;
	private JTextField textFieldColorHexadecimal;
	private JTextField textFieldURLLogoAgencia;
	private JPanel panelColor;
	private JComboBox<String> comboBoxNumEmpleados;// Si no pongo lo de string me sale subrayado en amarillo
	private JComboBox<String> comboBoxTipoAgencia;

	/**
	 * Constructor del panel.
	 */
	public GestorNuevoPerfil(ArrayList<JPanel> paneles) {
		
		panelNuevoPerfil = new JPanel();
		panelNuevoPerfil.setBounds(0, 0, 1039, 666);
		panelNuevoPerfil.setLayout(null);

		JLabel lblNuevoPerfil = new JLabel("Nuevo Perfil");
		lblNuevoPerfil.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNuevoPerfil.setBounds(50, 77, 234, 32);
		panelNuevoPerfil.add(lblNuevoPerfil);

		JLabel lblNombreAgencia = new JLabel("Nombre Agencia");
		lblNombreAgencia.setBounds(50, 137, 122, 20);
		panelNuevoPerfil.add(lblNombreAgencia);

		JLabel lblColorMarca = new JLabel("Color de marca");
		lblColorMarca.setBounds(50, 178, 95, 20);
		panelNuevoPerfil.add(lblColorMarca);

		JLabel lblNmeroDeEmpleados = new JLabel("Número de empleados");
		lblNmeroDeEmpleados.setBounds(50, 238, 122, 20);
		panelNuevoPerfil.add(lblNmeroDeEmpleados);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(53, 354, 122, 20);
		panelNuevoPerfil.add(lblLogo);

		JLabel lblTipoDeAgencia = new JLabel("Tipo de Agencia");
		lblTipoDeAgencia.setBounds(50, 301, 122, 20);
		panelNuevoPerfil.add(lblTipoDeAgencia);

		// Nombre Agencia
		textFieldNombreAgencia = new JTextField();
		textFieldNombreAgencia.setBounds(189, 137, 203, 20);
		panelNuevoPerfil.add(textFieldNombreAgencia);
		textFieldNombreAgencia.setColumns(10);

		// TextField color hexadecimal
		textFieldColorHexadecimal = new JTextField();
		textFieldColorHexadecimal.setColumns(10);
		textFieldColorHexadecimal.setBounds(189, 178, 59, 20);
		panelNuevoPerfil.add(textFieldColorHexadecimal);

		// Panel de color que se actualiza al meter un intro en el textfield
		panelColor = new JPanel();
		panelColor.setBounds(291, 178, 38, 20);
		panelNuevoPerfil.add(panelColor);

		textFieldColorHexadecimal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					actualizarColorPanel();
				}
			}
		});

		// Número de empleados
		comboBoxNumEmpleados = new JComboBox<>();
		comboBoxNumEmpleados.setModel(new DefaultComboBoxModel<>(
				new String[] { "Entre 2 y 10 empleados", "Entre 10 y 100 empleados", "Entre 100 y 1000 empleados" }));
		comboBoxNumEmpleados.setBounds(189, 237, 203, 22);
		panelNuevoPerfil.add(comboBoxNumEmpleados);

		// Tipo de agencia
		comboBoxTipoAgencia = new JComboBox<>();
		comboBoxTipoAgencia
				.setModel(new DefaultComboBoxModel<>(new String[] { "Mayorista", "Minorista", "Mayorista-Minorista" }));
		comboBoxTipoAgencia.setBounds(189, 300, 203, 22);
		panelNuevoPerfil.add(comboBoxTipoAgencia);

		// URL del logo
		textFieldURLLogoAgencia = new JTextField();
		textFieldURLLogoAgencia.setColumns(10);
		textFieldURLLogoAgencia.setBounds(189, 354, 461, 20);
		panelNuevoPerfil.add(textFieldURLLogoAgencia);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(189, 424, 89, 23);
		panelNuevoPerfil.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarDatos();
				paneles.get(9).setVisible(false);
				paneles.get(1).setVisible(true);
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(320, 424, 89, 23);
		panelNuevoPerfil.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetearCampos();
				//volverAInicio();
				paneles.get(9).setVisible(false);
				paneles.get(1).setVisible(true);
				
			}
		});
	}

	private void actualizarColorPanel() {
		String hexColor = textFieldColorHexadecimal.getText();

		if (!validarColorHexadecimal(hexColor)) {
			JOptionPane.showMessageDialog(panelNuevoPerfil, "Código hexadecimal inválido. Debe ser #RRGGBB o #RGB",
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			Color color = Color.decode(hexColor);
			panelColor.setBackground(color);
			panelColor.repaint();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(panelNuevoPerfil, "Código hexadecimal inválido.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void guardarDatos() {
		String nombreAgencia = textFieldNombreAgencia.getText();
		String colorMarca = textFieldColorHexadecimal.getText();
		String numEmpleados = (String) comboBoxNumEmpleados.getSelectedItem();
		String logo = textFieldURLLogoAgencia.getText();
		String tipoAgencia = (String) comboBoxTipoAgencia.getSelectedItem();

		// Si no son TRUE avisa de que los campos no son validos
		if (!validarCampos(nombreAgencia, colorMarca, logo)) {
			return;
		}

		// Mostrar los datos en la consola (solo si los campos son válidos)
		System.out.println("Nombre de la Agencia: " + nombreAgencia);
		System.out.println("Color de la Marca: " + colorMarca);
		System.out.println("Número de Empleados: " + numEmpleados);
		System.out.println("Logo: " + logo);
		System.out.println("Tipo de Agencia: " + tipoAgencia);

		JOptionPane.showMessageDialog(panelNuevoPerfil, "Datos guardados correctamente.", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		resetearCampos();
	}

	private boolean validarCampos(String nombre, String color, String url) {
		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(panelNuevoPerfil, "El nombre de la agencia es obligatorio.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!validarColorHexadecimal(color)) {
			JOptionPane.showMessageDialog(panelNuevoPerfil, "El color hexadecimal es inválido.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!validarURL(url)) {
			JOptionPane.showMessageDialog(panelNuevoPerfil, "La URL del logo es inválida.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	/**
	 * Valida si el código de color ingresado es hexadecimal válido.
	 * 
	 * @param color El código de color a validar.
	 * @return {@code true} si el código de color es válido, {@code false} en caso
	 *         contrario.
	 */
	private boolean validarColorHexadecimal(String color) {
		return color.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
	}

	/**
	 * Valida si la URL ingresada es válida.
	 * 
	 * @param url La URL a validar.
	 * @return {@code true} si la URL es válida, {@code false} en caso contrario.
	 */
	private boolean validarURL(String url) {
		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);
		return matcher.matches();
	}

	/**
	 * Restablece los valores de los campos de entrada a sus valores
	 * predeterminados.
	 */
	private void resetearCampos() {
		textFieldNombreAgencia.setText("");
		textFieldColorHexadecimal.setText("");
		textFieldURLLogoAgencia.setText("");
		comboBoxNumEmpleados.setSelectedIndex(0);
		comboBoxTipoAgencia.setSelectedIndex(0);
		panelColor.setBackground(null);
	}

//	private void volverAInicio() {
//		panelNuevoPerfil.setVisible(false);
//		// Ir al panel de login
//	}

	public JPanel getPanel() {
		return panelNuevoPerfil;
	}
}
