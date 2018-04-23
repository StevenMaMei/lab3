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
	
	private String [][] matrizLimpar1;
	private String [][] matrizLimpar2;
	private String [][] matrizLimpar3;
	private String [][] matrizLimpar4;
	private String [][] matrizLimpar5;
	private String [][] matrizLimpar6;
	private String [][] matrizLimpar7;
	private String [][] matrizLimpar8;
	
	
	
	
	
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
		matrizLimpar1 = new String [10387][8];
		matrizLimpar2 = new String [10387][8];
		matrizLimpar3 = new String [10387][8];
		matrizLimpar4 = new String [10387][8];
		matrizLimpar5 = new String [10387][8];
		matrizLimpar6 = new String [10387][8];
		matrizLimpar7 = new String [10387][8];
		matrizLimpar8 = new String [10387][8];
		
		setLayout(new BorderLayout());
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelBaseDeDatos, BorderLayout.CENTER);
		
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(2, 1));
		
		aux.add(panelDato);
		aux.add(panelBotones);
		
		add(aux, BorderLayout.SOUTH);
		
		
	}
	
	public String [][] buscarSI() {
		String dato = panelDato.getDato();  
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarNombreIps(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
			System.out.println(matriz.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
	
		return matriz;
	}
	
	public String [][] buscarNI() {
		String dato = panelDato.getDato(); 
		String [][] matriz = null;
		try {
			matriz =  conexionMundo.buscarNitIps(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		
		}
		return matriz ;
	}

	public String [][] buscarN() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarNaturaleza(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
		return matriz;
	}

	public String [][] buscarD() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarDigitoVerificacion(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
		return matriz;
	}

	
	public String [][] buscarNA() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarNivelAtencion(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
		return matriz;
	}

	public String [][] buscarGC() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarGrupoCapacidad(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
		return matriz;
	}
	
	public String [][] buscarDC() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarDescripcionCapacidad(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
		return matriz;
	}

	public String [][] buscarCI() {
		String dato = panelDato.getDato();  ; 
		String [][] matriz = null;
		try {
			matriz  = conexionMundo.buscarCantidadCapacidad(dato);
			panelBaseDeDatos.refrescarDatosEncontrados(matriz);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El hospital no se encuentra en la base de datos");
		}
		return matriz;
		
	}
	

	public void limpiarTabla() {
		panelBaseDeDatos.limpiarTabla();
	}
	
	public static void main (String [] arga) throws FileNotFoundException, ClassNotFoundException, IOException {
		InterfazPrincipal vent = new InterfazPrincipal();
		vent.setVisible(true);
	}
	
	
	
	

}
