package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource.TitledBorderUIResource;

public class PanelBaseDeDatos extends JPanel {

	private JTable JtableBaseDeDatos;
	private String [] titulos = {"Sede IPS","NIT IPS","Naturaleza","Digito de verificación","Nivel de atención","Grupo de capacidad","Descripción de capacidad","Cantidad de capacidad instalada"};
	private String [][] datos;
	//{"Andrés","Vargas","A00762387","79002283","Ing. Industrial","3.5"}
	
	
	public PanelBaseDeDatos() {
		
		TitledBorder titulo = BorderFactory.createTitledBorder("Datos");
		titulo.setTitleColor(Color.BLACK);
		setBorder(titulo);
		
		datos = new String [1][8];//modificar.
		
		JtableBaseDeDatos = new JTable(datos, titulos);
		JScrollPane JS = new JScrollPane(JtableBaseDeDatos);
		JS.setPreferredSize(new Dimension(400, 150));
		setLayout(new BorderLayout());
		add(JS, BorderLayout.CENTER);

		
	}
	
	
	
	
	public void refrescarDatosEncontrados() {
		
	}
	
	
	
	
}
