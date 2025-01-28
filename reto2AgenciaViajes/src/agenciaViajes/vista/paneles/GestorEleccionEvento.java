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

public class GestorEleccionEvento {


	private JPanel gestorEleccionEvento;
	private JTextField tfNombreEvento;



	/**
	 * Create the frame.
	 */
	public GestorEleccionEvento(ArrayList<JPanel> paneles) {
		
		gestorEleccionEvento = new JPanel();
		gestorEleccionEvento.setBounds(0, 0, 1039, 666);
		gestorEleccionEvento.setBackground(new Color(192, 192, 192));
		gestorEleccionEvento.setBorder(new EmptyBorder(5, 5, 5, 5));
		gestorEleccionEvento.setLayout(null);
		
		
		JLabel lbNombreEvento = new JLabel("NOMBRE EVENTO");
		lbNombreEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lbNombreEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNombreEvento.setBounds(148, 78, 110, 17);
		gestorEleccionEvento.add(lbNombreEvento);
		
		tfNombreEvento = new JTextField();
		tfNombreEvento.setBounds(309, 74, 130, 26);
		gestorEleccionEvento.add(tfNombreEvento);
		tfNombreEvento.setColumns(10);
		
		JLabel lblTipoEvento = new JLabel("TIPO EVENTO");
		lblTipoEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoEvento.setBounds(148, 119, 86, 17);
		gestorEleccionEvento.add(lblTipoEvento);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = (String) comboBox.getSelectedItem();
				if(seleccion.equals("VUELO")) {
					paneles.get(7).setVisible(false);
					paneles.get(6).setVisible(true);
				} 
				if(seleccion.equals("ALOJAMIENTO")) {
					paneles.get(7).setVisible(false);
					paneles.get(4).setVisible(true);
				} 
				if(seleccion.equals("ACTIVIDAD")) {
					paneles.get(7).setVisible(false);
					paneles.get(8).setVisible(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar...", "VUELO", "ALOJAMIENTO", "ACTIVIDAD"}));
		comboBox.setBounds(309, 116, 151, 27);
		gestorEleccionEvento.add(comboBox);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(7).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnGuardar.setBounds(275, 568, 117, 29);
		gestorEleccionEvento.add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(7).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnCancelar.setBounds(538, 568, 117, 29);
		gestorEleccionEvento.add(btnCancelar);
		
	}
	public JPanel getPanel() {
		
		return gestorEleccionEvento;
	}
}