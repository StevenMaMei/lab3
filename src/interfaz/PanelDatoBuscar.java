package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelDatoBuscar extends JPanel implements ActionListener {

	public static final String LIMPIAR = "limpiar";
	
	private JTextField campo;
	private JButton limpiar;
	private InterfazPrincipal principal;
	
	public PanelDatoBuscar(InterfazPrincipal p) {
		
		TitledBorder opciones = BorderFactory.createTitledBorder("Buscar");
		opciones.setTitleColor(Color.BLACK);
		setBorder(opciones);
		
		principal = p;
		
		campo = new JTextField();
		campo.setFont(new java.awt.Font("Tahoma", 0, 30));
		
		limpiar = new JButton("Limpiar");
		
		limpiar.addActionListener(this);
		limpiar.setActionCommand(LIMPIAR);
		
		
		setLayout(new BorderLayout());
		
		add(campo, BorderLayout.CENTER);
		add(limpiar, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comant = e.getActionCommand();
		if(comant.equals(LIMPIAR)) {
			campo.setText("");
			principal.limpiarTabla();
			//principal.limpiarTabla();
		}
	}
	
	public String getDato() {
		String dato = campo.getText();
		return dato;
	}
}
