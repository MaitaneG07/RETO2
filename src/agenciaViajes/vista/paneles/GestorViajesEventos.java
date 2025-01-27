package agenciaViajes.vista.paneles;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GestorViajesEventos {

	
	private JPanel panelViajesEventos = null;
	private JTable tablaViajes;
	private JTable tablaEventos;
	private JButton btnNuevoViaje;
	private JButton btnNuevoEvento;
	private JButton btnGenerarAlerta;
	private JButton btnDesconectar;

	/**
	 * Create the frame.
	 */
	public GestorViajesEventos(ArrayList<JPanel> paneles) {
		
		panelViajesEventos = new JPanel();
		panelViajesEventos.setBounds(0, 0, 1039, 666);
		panelViajesEventos.setLayout(null);
		
		
		//Crear la tabla de Viajes
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 66, 596, 189);
		panelViajesEventos.add(scrollPane);
		
		DefaultTableModel modeloViajes = new DefaultTableModel();
		modeloViajes.addColumn("Viaje");
		modeloViajes.addColumn("Tipo");
		modeloViajes.addColumn("Fecha Inicio");
		modeloViajes.addColumn("Fecha Fin");
		modeloViajes.addColumn("Nº Días");
		modeloViajes.addColumn("País");
		
		tablaViajes = new JTable(modeloViajes);
		scrollPane.add(tablaViajes);
		scrollPane.setViewportView(tablaViajes);
		
		
		// Crear la tabla de Eventos
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(74, 409, 605, 189);
		panelViajesEventos.add(scrollPane_1);
		
		DefaultTableModel modeloEventos = new DefaultTableModel();
		modeloEventos.addColumn("Nombre Evento");
		modeloEventos.addColumn("Tipo");
		modeloEventos.addColumn("Fecha");
		modeloEventos.addColumn("Precio");
		
		tablaEventos = new JTable(modeloEventos);
		scrollPane_1.add(tablaEventos);
		scrollPane_1.setViewportView(tablaEventos);
		
		
		//Botones
		
		btnNuevoViaje = new JButton("Nuevo Viaje");
		btnNuevoViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(2).setVisible(false);
				paneles.get(10).setVisible(true);
			}
		});
		btnNuevoViaje.setBounds(771, 66, 185, 23);
		panelViajesEventos.add(btnNuevoViaje);
		
		btnNuevoEvento = new JButton("Nuevo Evento");
		btnNuevoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(2).setVisible(false);
				paneles.get(7).setVisible(true);
			}
		});
		btnNuevoEvento.setBounds(771, 232, 185, 23);
		panelViajesEventos.add(btnNuevoEvento);
		
		btnGenerarAlerta = new JButton("Generar Alerta Cliente");
		btnGenerarAlerta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerarAlerta.setBounds(771, 409, 185, 23);
		panelViajesEventos.add(btnGenerarAlerta);
		
		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(2).setVisible(false);
				paneles.get(0).setVisible(true);
			}
		});
		btnDesconectar.setBounds(771, 575, 185, 23);
		panelViajesEventos.add(btnDesconectar);
		
		
	}
	public JPanel getPanel() {
		
		return panelViajesEventos;
	}
}
