package agenciaViajes.vista.paneles;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import javax.swing.JTextArea;

public class GestorActividad {

	private JPanel gestorActividad;
	private JTextField tfNombreEvento;
	private JLabel lbTipo;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public GestorActividad(ArrayList<JPanel> paneles) {

		gestorActividad = new JPanel();
		gestorActividad.setBounds(0, 0, 1039, 666);
		gestorActividad.setBackground(new Color(192, 192, 192));
		gestorActividad.setBorder(new EmptyBorder(5, 5, 5, 5));
		gestorActividad.setLayout(null);

		JLabel lbNombreEvento = new JLabel("NOMBRE EVENTO");
		lbNombreEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lbNombreEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNombreEvento.setBounds(148, 78, 110, 17);
		gestorActividad.add(lbNombreEvento);

		tfNombreEvento = new JTextField();
		tfNombreEvento.setBounds(309, 74, 130, 26);
		gestorActividad.add(tfNombreEvento);
		tfNombreEvento.setColumns(10);

		lbTipo = new JLabel("TIPO EVENTO");
		lbTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lbTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTipo.setBounds(148, 129, 110, 20);
		gestorActividad.add(lbTipo);

		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "ACTIVIDAD", "VUELO", "ALOJAMIENTO" }));
		comboBoxTipo.setBounds(309, 128, 130, 27);
		gestorActividad.add(comboBoxTipo);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(309, 187, 241, 132);
		gestorActividad.add(textArea);

		JLabel lbDesc = new JLabel("DESCRIPCION");
		lbDesc.setHorizontalAlignment(SwingConstants.LEFT);
		lbDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDesc.setBounds(148, 299, 110, 20);
		gestorActividad.add(lbDesc);

		JLabel lbPrecioAct = new JLabel("PRECIO");
		lbPrecioAct.setHorizontalAlignment(SwingConstants.LEFT);
		lbPrecioAct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPrecioAct.setBounds(148, 373, 110, 20);
		gestorActividad.add(lbPrecioAct);

		
		JDatePickerImpl datePickerActividad = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerActividad.setBounds(309, 447, 153, 30);
		gestorActividad.add(datePickerActividad);

		

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(8).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnGuardar.setBounds(275, 568, 117, 29);
		gestorActividad.add(btnGuardar);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(8).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnCancelar.setBounds(538, 568, 117, 29);
		gestorActividad.add(btnCancelar);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(309, 371, 130, 26);
		gestorActividad.add(textField);
		
		JLabel lbFecActividad = new JLabel("FECHA ACTIVIDAD");
		lbFecActividad.setBounds(148, 447, 130, 16);
		gestorActividad.add(lbFecActividad);

	}
	
	public JPanel getPanel() {
		
		return gestorActividad;
	}
}
