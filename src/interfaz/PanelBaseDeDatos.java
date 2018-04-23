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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelBaseDeDatos extends JPanel {

	private JTable JtableBaseDeDatos;
	private String [] titulos = {"Sede IPS","NIT IPS","Naturaleza","Digito de verificación","Nivel de atención","Grupo de capacidad","Descripción de capacidad","Cantidad de capacidad instalada"};
	private String [][] datos ;
	
	public PanelBaseDeDatos() {
		
		TitledBorder titulo = BorderFactory.createTitledBorder("Datos");
		titulo.setTitleColor(Color.BLACK);
		setBorder(titulo);
		
		datos = new String [10387][8];
		
		
		JtableBaseDeDatos = new JTable(datos, titulos);
		JScrollPane JS = new JScrollPane(JtableBaseDeDatos);
		JS.setPreferredSize(new Dimension(400, 150));
		setLayout(new BorderLayout());
		add(JS, BorderLayout.CENTER);

		
	}
	

	public void refrescarDatosEncontrados(String [][] matriz) {
			
		for (int i =0 ; i<matriz.length;i++) 
			for(int j=0; j<matriz[i].length; j++) {
				datos[i][j] = matriz[i][j];
				
				repaint();
			}
			
		}
		
	public void limpiarTabla() {
	
		DefaultTableModel modelo = (DefaultTableModel) JtableBaseDeDatos.getModel();
		while(modelo.getRowCount()>0)modelo.removeRow(0); {
		//TableColumnModel 
		}
	}
	
		
	}
	
	
	
	

