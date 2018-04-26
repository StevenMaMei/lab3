package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel implements ActionListener {

	
	public static final String BUSCARSEDEIPS = "buscar_sede_ips";
	public static final String BUSCARNITIPS = "buscar_nit_ips";
	public static final String BUSCARNATURALEZA = "buscar_naturaleza";
	public static final String BUSCARNUMDIGITOVERIFICACION = "busar_digito";
	public static final String BUSCARNUMNIVELATENCION = "buscar_nivel_atencion";
	public static final String BUSCARNOMGRUPOCAPACIDAD = "buscar_grupo_capacidad";
	public static final String BUSCARNOMDESCRIPCIONCAPACIDAD = "buscar_descripcion_capacidad";
	public static final String BUSCARNUMCANTCAPACIDADINSTALADA = "buscar_num_cant_capacidad_instalada";
	
	
	
	private JButton btBuscarSI;
	private JButton btBuscarNI;
	private JButton btBuscarN;
	private JButton btBuscarD;
	private JButton btBuscarNA;
	private JButton btBuscarGC;
	private JButton btBuscarDC;
	private JButton btBuscarCI;
	
	
	
	
	private InterfazPrincipal principal;
	
	public PanelBotones(InterfazPrincipal principal) {
		
		this.principal = principal;
		
		TitledBorder opciones = BorderFactory.createTitledBorder("Opciones");
		opciones.setTitleColor(Color.BLACK);
		setBorder(opciones);
		
		btBuscarSI = new JButton("Buscar Sede IPS (A)");
		btBuscarNI = new JButton("Buscar NIT IPS (A)");
		btBuscarN = new JButton("Buscar Naturaleza");
		btBuscarD = new JButton("Buscar Num digito verificación");
		btBuscarNA = new JButton("Buscar Nivel Atención");
		btBuscarGC = new JButton("Busca Nom Grupo Capacidad");
		btBuscarDC = new JButton("Buscar Descripción Capacidad (A)");
		btBuscarCI = new JButton("Buscar Num Cant Capacidad Instalada");
		
		
		btBuscarSI.setActionCommand(BUSCARSEDEIPS);
		btBuscarNI.setActionCommand(BUSCARNITIPS);
		btBuscarN.setActionCommand(BUSCARNATURALEZA);
		btBuscarD.setActionCommand(BUSCARNUMDIGITOVERIFICACION);
		btBuscarNA.setActionCommand(BUSCARNUMNIVELATENCION);
		btBuscarGC.setActionCommand(BUSCARNOMGRUPOCAPACIDAD);
		btBuscarDC.setActionCommand(BUSCARNOMDESCRIPCIONCAPACIDAD);
		btBuscarCI.setActionCommand(BUSCARNUMCANTCAPACIDADINSTALADA);
		
		
		
		btBuscarSI.addActionListener(this);
		btBuscarNI.addActionListener(this);
		btBuscarN.addActionListener(this);
		btBuscarD.addActionListener(this);
		btBuscarNA.addActionListener(this);
		btBuscarGC.addActionListener(this);
		btBuscarDC.addActionListener(this);
		btBuscarCI.addActionListener(this);
		
		
		
		setLayout(new GridLayout(2, 4));
		
		add(btBuscarSI);
		add(btBuscarNI);
		add(btBuscarN);
		add(btBuscarD);
		add(btBuscarNA);
		add(btBuscarGC);
		add(btBuscarDC);
		add(btBuscarCI);
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String comant = arg0.getActionCommand();
		
		if(comant.equals(BUSCARSEDEIPS)) {
			principal.buscarSI();
		}
		if(comant.equals(BUSCARNITIPS)) {
			principal.buscarNI();
		}
		if(comant.equals(BUSCARNATURALEZA)) {
			principal.buscarN();
		}
		if(comant.equals(BUSCARNUMDIGITOVERIFICACION)) {
			principal.buscarD();
		}
		if(comant.equals(BUSCARNUMNIVELATENCION)) {
			principal.buscarNA();
		}
		if(comant.equals(BUSCARNOMGRUPOCAPACIDAD)) {
			principal.buscarGC();
		}
		if(comant.equals(BUSCARNOMDESCRIPCIONCAPACIDAD)) {
			principal.buscarDC();
		}
		if(comant.equals(BUSCARNUMCANTCAPACIDADINSTALADA)) {
			principal.buscarCI();
		}
		
		
	}
	
	
	
}
