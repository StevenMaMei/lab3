package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mundo.Buscador;

public class InterfazPrincipal extends JFrame {

	
	private PanelBaseDeDatos panelBaseDeDatos;
	private PanelBotones panelBotones;
	private PanelTitulo panelTitulo;
	private PanelDatoBuscar panelDato;
	
	private Buscador conexionMundo;
	
	
	public InterfazPrincipal() throws FileNotFoundException, ClassNotFoundException, IOException {
	
		conexionMundo = new Buscador();
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
		String dato = panelDato.getDato();  
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarNombreIps(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
	
		
	}
	
	public void buscarNI() {
		String dato = panelDato.getDato(); 
		String [][] matriz = null;
		try {
			matriz =  conexionMundo.buscarNitIps(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		
		}
		
	}

	public void buscarN() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarNaturaleza(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
	}

	public void buscarD() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarDigitoVerificacion(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
		
	}

	public void buscarNA() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarNivelAtencion(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
	}

	public void buscarGC() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarGrupoCapacidad(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
	}
	
	public void buscarDC() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarDescripcionCapacidad(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
	}

	public void buscarCI() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarCantidadCapacidad(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
		
		
	}
	
	public static void main (String [] arga) throws FileNotFoundException, ClassNotFoundException, IOException {
		InterfazPrincipal vent = new InterfazPrincipal();
		vent.setVisible(true);
	}
	
	
	
	

}
