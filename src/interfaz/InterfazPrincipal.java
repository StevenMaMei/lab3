package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfazPrincipal extends JFrame {

	
	private PanelBaseDeDatos panelBaseDeDatos;
	private PanelBotones panelBotones;
	private PanelTitulo panelTitulo;
	private PanelDatoBuscar panelDato;
	
	
	
	public InterfazPrincipal() {
	
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
		String dato = panelDato.getDato();  ; 
		
		
	}
	
	public void buscarNI() {
		String dato = panelDato.getDato();  ; 
		
		
	}

	public void buscarN() {
		String dato = panelDato.getDato();  ; 
		
	}

	public void buscarD() {
		String dato = panelDato.getDato();  ; 
		
		
	}

	public void buscarNA() {
		String dato = panelDato.getDato();  ; 
		
	}

	public void buscarGC() {
		String dato = panelDato.getDato();  ; 
		
	}
	
	public void buscarDC() {
		String dato = panelDato.getDato();  ; 
		
	}

	public void buscarCI() {
		String dato = panelDato.getDato();  ; 
		
	}
	
	public static void main (String [] arga) {
		InterfazPrincipal vent = new InterfazPrincipal();
		vent.setVisible(true);
	}
	
	
	
	

}
