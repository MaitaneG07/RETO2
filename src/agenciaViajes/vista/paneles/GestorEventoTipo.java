package agenciaViajes.vista.paneles;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestorEventoTipo  {
	
	private JPanel gestorEventoTipo;
	private JTextField tfNombreEvento;
	private JLabel lbTipo;
	private JLabel lbTipoHabitacion;
	private JComboBox comboBoxTipo;
	private JTextField tfCiudadAloj;
	private JTextField tfPrecioAloj;

	

	/**
	 * Create the panel.
	 */
	public GestorEventoTipo(ArrayList<JPanel> paneles) {
		
		gestorEventoTipo = new JPanel();
		gestorEventoTipo.setBounds(100, 100, 1039, 666);
		gestorEventoTipo.setBackground(new Color(192, 192, 192));
		gestorEventoTipo.setBorder(new EmptyBorder(5, 5, 5, 5));
		gestorEventoTipo.setLayout(null);
		
		JLabel lbNombreEvento = new JLabel("NOMBRE EVENTO");
		lbNombreEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lbNombreEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNombreEvento.setBounds(148, 78, 110, 17);
		gestorEventoTipo.add(lbNombreEvento);
		
		tfNombreEvento = new JTextField();
		tfNombreEvento.setBounds(309, 74, 130, 26);
		gestorEventoTipo.add(tfNombreEvento);
		tfNombreEvento.setColumns(10);
		
		lbTipo = new JLabel("TIPO EVENTO");
		lbTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lbTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTipo.setBounds(148, 129, 110, 20);
		gestorEventoTipo.add(lbTipo);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = (String) comboBoxTipo.getSelectedItem();
				if(seleccion.equals("VUELO")) {
					paneles.get(4).setVisible(false);
					paneles.get(6).setVisible(true);
				} 
				if(seleccion.equals("ALOJAMIENTO")) {
					paneles.get(4).setVisible(false);
					paneles.get(4).setVisible(true);
				} 
				if(seleccion.equals("ACTIVIDAD")) {
					paneles.get(4).setVisible(false);
					paneles.get(8).setVisible(true);
				}
			}
		});
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar...", "VUELO", "ALOJAMIENTO", "ACTIVIDAD"}));
		comboBoxTipo.setBounds(309, 128, 130, 27);
		gestorEventoTipo.add(comboBoxTipo);
		
		lbTipoHabitacion = new JLabel("TIPO HABITACION");
		lbTipoHabitacion.setHorizontalAlignment(SwingConstants.LEFT);
		lbTipoHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTipoHabitacion.setBounds(148, 172, 135, 20);
		gestorEventoTipo.add(lbTipoHabitacion);
		
		JComboBox comboBoxHabitacion = new JComboBox();
		comboBoxHabitacion.setModel(new DefaultComboBoxModel(new String[] { "DOBLE", "INDIVIDUAL", "TRIPLE"}));
		comboBoxHabitacion.setBounds(309, 171, 130, 27);
		gestorEventoTipo.add(comboBoxHabitacion);
		
		JLabel lbCiudad = new JLabel("CIUDAD");
		lbCiudad.setHorizontalAlignment(SwingConstants.LEFT);
		lbCiudad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbCiudad.setBounds(148, 222, 135, 20);
		gestorEventoTipo.add(lbCiudad);
		
		JLabel lbPrecio = new JLabel("PRECIO");
		lbPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lbPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPrecio.setBounds(148, 267, 135, 20);
		gestorEventoTipo.add(lbPrecio);
		
		JLabel lbFecEntrada = new JLabel("FECHA ENTRADA");
		lbFecEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		lbFecEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbFecEntrada.setBounds(148, 314, 135, 20);
		gestorEventoTipo.add(lbFecEntrada);
		
		JDatePickerImpl datePickerFecEntrada = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerFecEntrada.setBounds(309, 304, 150, 30);
		gestorEventoTipo.add(datePickerFecEntrada);
		
		JLabel lbFecSalida = new JLabel("FECHA SALIDA");
		lbFecSalida.setHorizontalAlignment(SwingConstants.LEFT);
		lbFecSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbFecSalida.setBounds(501, 314, 135, 20);
		gestorEventoTipo.add(lbFecSalida);
		
		JDatePickerImpl datePickerFecSalida = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerFecSalida.setBounds(602, 304, 150, 30);
		gestorEventoTipo.add(datePickerFecSalida);
	
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(4).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnGuardar.setBounds(275, 568, 117, 29);
		gestorEventoTipo.add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(4).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnCancelar.setBounds(538, 568, 117, 29);
		gestorEventoTipo.add(btnCancelar);
		
		JButton btnBuscarAloj = new JButton("BUSCAR");
		btnBuscarAloj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarAloj.setBounds(455, 241, 117, 29);
		gestorEventoTipo.add(btnBuscarAloj);
		
		tfCiudadAloj = new JTextField();
		tfCiudadAloj.setColumns(10);
		tfCiudadAloj.setBounds(309, 220, 130, 26);
		gestorEventoTipo.add(tfCiudadAloj);
		
		tfPrecioAloj = new JTextField();
		tfPrecioAloj.setColumns(10);
		tfPrecioAloj.setBounds(309, 265, 130, 26);
		gestorEventoTipo.add(tfPrecioAloj);
		

	}
	public JPanel getPanel() {
		
		return gestorEventoTipo;
	}
}