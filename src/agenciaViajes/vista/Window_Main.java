package agenciaViajes.vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import agenciaViajes.vista.paneles.GestorActividad;
import agenciaViajes.vista.paneles.GestorBienvenida;
import agenciaViajes.vista.paneles.GestorEleccionEvento;
import agenciaViajes.vista.paneles.GestorEleccionIda;
import agenciaViajes.vista.paneles.GestorEleccionTrayecto;
import agenciaViajes.vista.paneles.GestorEventoTipo;
import agenciaViajes.vista.paneles.GestorIdaVuelta;
import agenciaViajes.vista.paneles.GestorLogin;
import agenciaViajes.vista.paneles.GestorNuevoPerfil;
import agenciaViajes.vista.paneles.GestorNuevoViaje;
import agenciaViajes.vista.paneles.GestorViajesEventos;

public class Window_Main {

	/**
	 * Launch the application.
	 */
	private JFrame frame;
	private ArrayList<JPanel> paneles = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Window_Main().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
		 * Create the frame.
		 */
		public Window_Main() {
			
			initialize();
		}
		
		/**
		 * Create the frame.
		 */
		private void initialize() {
			
			frame = new JFrame();
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 1039, 666);
			frame.getContentPane().setLayout(null);
			
			paneles = new ArrayList<JPanel>();
			
			//Creamos los gestores y los paneles. Y pasamos la lista por el constructor.
			GestorBienvenida gestorBienvenida = new GestorBienvenida(paneles);
			JPanel panel1 = gestorBienvenida.getPanel();
			paneles.add(panel1); 
			
			GestorLogin gestorLogin = new GestorLogin(paneles);
			JPanel panel2 = gestorLogin.getPanel();
			paneles.add(panel2); 
			
			GestorViajesEventos gestorViajesYEventos = new GestorViajesEventos(paneles);
			JPanel panel3 = gestorViajesYEventos.getPanel();
			paneles.add(panel3); 
			
			GestorIdaVuelta gestorVuelta = new GestorIdaVuelta(paneles);
			JPanel panel4 = gestorVuelta.getPanel();
			paneles.add(panel4); 
			
			GestorEventoTipo gestorEventoTipo = new GestorEventoTipo(paneles);
			JPanel panel5 = gestorEventoTipo.getPanel();
			paneles.add(panel5); 
			
			GestorEleccionIda gestorElecionIda = new GestorEleccionIda(paneles);
			JPanel panel6 = gestorElecionIda.getPanel();
			paneles.add(panel6); 
			
			GestorEleccionTrayecto gestorEleccionTrayecto = new GestorEleccionTrayecto(paneles);
			JPanel panel7 = gestorEleccionTrayecto.getPanel();
			paneles.add(panel7);
			
			GestorEleccionEvento gestorEleccionEvento = new GestorEleccionEvento(paneles);
			JPanel panel8 = gestorEleccionEvento.getPanel();
			paneles.add(panel8);
			
			GestorActividad gestorActividad = new GestorActividad(paneles);
			JPanel panel9 = gestorActividad.getPanel();
			paneles.add(panel9);
			
			GestorNuevoPerfil gestorNuevoPerfil = new GestorNuevoPerfil(paneles);
			JPanel panel10 = gestorNuevoPerfil.getPanel();
			paneles.add(panel10);
			
			GestorNuevoViaje gestorNuevoViaje = new GestorNuevoViaje(paneles);
			JPanel panel11 = gestorNuevoViaje.getPanel();
			paneles.add(panel11);
			
			
			frame.add(paneles.get(0)).setVisible(true);
			frame.add(paneles.get(1)).setVisible(false);
			frame.add(paneles.get(2)).setVisible(false);
			frame.add(paneles.get(3)).setVisible(false);
			frame.add(paneles.get(4)).setVisible(false);
			frame.add(paneles.get(5)).setVisible(false);
			frame.add(paneles.get(6)).setVisible(false);
			frame.add(paneles.get(7)).setVisible(false);
			frame.add(paneles.get(8)).setVisible(false);
			frame.add(paneles.get(9)).setVisible(false);
			frame.add(paneles.get(10)).setVisible(false);
			
		}
}
