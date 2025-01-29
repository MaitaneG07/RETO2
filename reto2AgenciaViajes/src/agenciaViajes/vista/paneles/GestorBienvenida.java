package agenciaViajes.vista.paneles;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GestorBienvenida {

	
	private JPanel panelBienvenida = null;


	/**
	 * Create the frame.
	 */
	public GestorBienvenida(ArrayList<JPanel> paneles) {
		
		panelBienvenida = new JPanel();
		panelBienvenida.setBounds(0, 0, 1039, 666);
		panelBienvenida.setBackground(Color.LIGHT_GRAY);
		panelBienvenida.setLayout(null);
		
		JButton btnBienvenida = new JButton("BIENVENIDA");
		btnBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
			}
		});
		btnBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBienvenida.setBounds(277, 253, 471, 108);
		panelBienvenida.add(btnBienvenida);
		
	}

	
	/**
	 * Devuelve el panel.
	 * @return panel.
	 */
	public JPanel getPanel() {
		
		return panelBienvenida;
	}
}