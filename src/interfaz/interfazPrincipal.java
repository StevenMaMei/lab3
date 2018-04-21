package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class interfazPrincipal extends JFrame {

	
	private PanelBaseDeDatos panelBaseDeDatos;
	private PanelBotones panelBotones;
	private PanelTitulo panelTitulo;
	private PanelDatoBuscar panelDato;
	
	
	
	public interfazPrincipal() {
	
		setSize(1500,400);
		setTitle("Base de datos");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		panelBaseDeDatos = new PanelBaseDeDatos();
		panelBotones = new PanelBotones(this);
		panelTitulo = new PanelTitulo();
		panelDato = new PanelDatoBuscar();
		
		setLayout(new BorderLayout());
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelBaseDeDatos, BorderLayout.CENTER);
		
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(2, 1));
		
		aux.add(panelDato);
		aux.add(panelBotones);
		
		add(aux, BorderLayout.SOUTH);
		
	}
	
	public void buscarSI() {
		
	}
	
	public void buscarNI() {
		
	}

	public void buscarN() {
		
	}

	public void buscarD() {
		
	}

	public void buscarNA() {
		
	}

	public void buscarGC() {
		
	}
	
	public void buscarDC() {
		
	}

	public void buscarCI() {
		
	}
	
	public static void main (String [] arga) {
		interfazPrincipal vent = new interfazPrincipal();
		vent.setVisible(true);
	}
	
	
	
	

}
