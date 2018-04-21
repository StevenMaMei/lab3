package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelTitulo extends JPanel {

	
	private JLabel espacio;
	
	public PanelTitulo() {
	
		TitledBorder titulo = BorderFactory.createTitledBorder("");
		titulo.setTitleColor(Color.BLACK);
		setBorder(titulo);
		
		espacio = new JLabel("                                              BASE DE DATOS");
		espacio.setFont(new java.awt.Font("Tahoma", 0, 40));
		
		setLayout(new BorderLayout());
		
		add(espacio, BorderLayout.CENTER);
	
	}
	
	
	
	
	
}
