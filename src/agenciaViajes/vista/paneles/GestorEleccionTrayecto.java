package agenciaViajes.vista.paneles;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GestorEleccionTrayecto {

	private JPanel gestorEleccionTrayecto;
	private JTextField tfNombreEvento;


	/**
	 * Create the frame.
	 * @param paneles 
	 */
	public GestorEleccionTrayecto(ArrayList<JPanel> paneles) {
		
		gestorEleccionTrayecto = new JPanel();
		gestorEleccionTrayecto.setBounds(0, 0, 1039, 666);
		gestorEleccionTrayecto.setBackground(new Color(192, 192, 192));
		gestorEleccionTrayecto.setBorder(new EmptyBorder(5, 5, 5, 5));
		gestorEleccionTrayecto.setLayout(null);
		
		
		JLabel lbNombreEvento = new JLabel("NOMBRE EVENTO");
		lbNombreEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lbNombreEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNombreEvento.setBounds(148, 78, 110, 17);
		gestorEleccionTrayecto.add(lbNombreEvento);
		
		tfNombreEvento = new JTextField();
		tfNombreEvento.setBounds(309, 74, 130, 26);
		gestorEleccionTrayecto.add(tfNombreEvento);
		tfNombreEvento.setColumns(10);
		
		JLabel lblTipoEvento = new JLabel("TIPO EVENTO");
		lblTipoEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoEvento.setBounds(148, 119, 86, 17);
		gestorEleccionTrayecto.add(lblTipoEvento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"VUELO", "ALOJAMIENTO", "ACTIVIDAD"}));
		comboBox.setBounds(309, 116, 151, 27);
		gestorEleccionTrayecto.add(comboBox);
		
		JLabel lbTrayecto = new JLabel("TRAYECTO");
		lbTrayecto.setHorizontalAlignment(SwingConstants.CENTER);
		lbTrayecto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTrayecto.setBounds(148, 161, 67, 17);
		gestorEleccionTrayecto.add(lbTrayecto);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(6).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnGuardar.setBounds(275, 568, 117, 29);
		gestorEleccionTrayecto.add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(6).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnCancelar.setBounds(538, 568, 117, 29);
		gestorEleccionTrayecto.add(btnCancelar);
		
		JComboBox comboBoxTrayecto = new JComboBox();
		comboBoxTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = (String) comboBoxTrayecto.getSelectedItem();
				if(seleccion.equals("IDA")) {
					paneles.get(6).setVisible(false);
					paneles.get(5).setVisible(true);
				} 
				if(seleccion.equals("IDA Y VUELTA")) {
					paneles.get(6).setVisible(false);
					paneles.get(3).setVisible(true);
				}
			}
		});
		comboBoxTrayecto.setModel(new DefaultComboBoxModel(new String[] {"IDA", "IDA Y VUELTA"}));
		comboBoxTrayecto.setBounds(309, 155, 151, 39);
		gestorEleccionTrayecto.add(comboBoxTrayecto);
		
		
	}
	public JPanel getPanel() {
		
		return gestorEleccionTrayecto;
	}

}