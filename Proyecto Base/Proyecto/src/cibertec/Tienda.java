package cibertec;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import java.awt.Font;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	// Datos mínimos del primer producto
		public static String modelo0 = "Cinza Plus";
		public static double precio0 = 92.56;
		public static double ancho0 = 62.0;
		public static double largo0 = 62.0;
		public static double espesor0 = 8;
		public static int contenido0 = 6;
		// Datos mínimos del segundo producto
		public static String modelo1 = "Luxury";
		public static double precio1 = 42.77;
		public static double ancho1 = 60;
		public static double largo1 = 60;
		public static double espesor1 = 8.5;
		public static int contenido1 = 4;
		// Datos mínimos del tercer producto
		public static String modelo2 = "Austria";
		public static double precio2 = 52.45;
		public static double ancho2 = 45;
		public static double largo2 = 45;
		public static double espesor2 = 6.5;
		public static int contenido2 = 12;
		// Datos mínimos del cuarto producto
		public static String modelo3 = "Yungay Mix";
		public static double precio3 = 55.89;
		public static double ancho3 = 80;
		public static double largo3 = 120;
		public static double espesor3 = 6.8;
		public static int contenido3 = 9;
		// Datos mínimos del quinto producto
		public static String modelo4 = "Thalía";
		public static double precio4 = 45;
		public static double ancho4 = 45;
		public static double largo4 = 11.8;
		public static double espesor4 = 7.2;
		public static int contenido4 = 10;
		// Porcentajes de descuento
		public static double porcentaje1 = 7.5;
		public static double porcentaje2 = 10.0;
		public static double porcentaje3 = 12.5;
		public static double porcentaje4 = 15.0;
		// Obsequio
		public static String tipoObsequio = "Lapicero";
		public static int obsequioCantidad1 = 2;
		public static int obsequioCantidad2 = 3;
		public static int obsequioCantidad3 = 4;
		// Cantidad óptima de unidades vendidas por día
		public static int cantidadOptima = 10;
		// Cuota diaria
		public static double cuotaDiaria = 30000;
		//Variables Globales
		public static int numeroVenta = 0;
		public static double ventaAcumulada = 0.0;
		public static int nroventaC0 = 0;
		public static int nroventaC1 = 0;
		public static int nroventaC2 = 0;
		public static int nroventaC3 = 0;
		public static int nroventaC4 = 0;
		public static int nrocajaC0 = 0;
		public static int nrocajaC1 = 0;
		public static int nrocajaC2 = 0;
		public static int nrocajaC3 = 0;
		public static int nrocajaC4 = 0;
		public static double impventaC0 = 0.0;
		public static double impventaC1 = 0.0;
		public static double impventaC2 = 0.0;
		public static double impventaC3 = 0.0;
		public static double impventaC4 = 0.0;
	
	
	public Tienda() {
		setBackground(SystemColor.activeCaption);
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 465);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.controlDkShadow);
		menuBar.setFont(new Font("Segoe UI Historic", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(WIDTH);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		JMenuItem mntmConsultarCeramico = new JMenuItem("Consultar Ceramico");
		mntmConsultarCeramico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedConsultarCeramico(arg0);
			}
		});
		mnMantenimiento.add(mntmConsultarCeramico);
		
		JMenuItem mntmModificarCermaico = new JMenuItem("Modificar Cermaico");
		mntmModificarCermaico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedModificarCeramico(arg0);
			}
		});
		mnMantenimiento.add(mntmModificarCermaico);
		
		JMenuItem mntmListarCeramicos = new JMenuItem("Listar Ceramicos");
		mntmListarCeramicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedListarCeramico(arg0);
			}
		});
		mnMantenimiento.add(mntmListarCeramicos);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		JMenuItem mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedVender(arg0);
			}
		});
		mnVentas.add(mntmVender);
		
		JMenuItem mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedGenerarReportes(arg0);
			}
		});
		mnVentas.add(mntmGenerarReportes);
		
		JMenu mnConfiguracion = new JMenu("Configuracion");
		menuBar.add(mnConfiguracion);
		
		JMenuItem mntmConfigurarDescuentos = new JMenuItem("Configurar Descuentos");
		mntmConfigurarDescuentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedConfDescuentos(arg0);
			}
		});
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		JMenuItem mntmConfigurarObsequios = new JMenuItem("Configurar Obsequios");
		mntmConfigurarObsequios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedConfObsequios(arg0);
			}
		});
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		JMenuItem mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad optima");
		mntmConfigurarCantidadOptima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedConfCantidadOptima(arg0);
			}
		});
		mnConfiguracion.add(mntmConfigurarCantidadOptima);
		
		JMenuItem mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedConfCuotaDiaria(arg0);
			}
		});
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				actionPerformedAcercaTienda(arg0);
			}
		});
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {		
	}
	
	protected void actionPerformedAcercaTienda(ActionEvent arg0) {		
		AcercaTienda at =  new AcercaTienda();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
	
	protected void actionPerformedConsultarCeramico(ActionEvent arg0) {		
		ConsultarCeramico at =  new ConsultarCeramico();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
	
	protected void actionPerformedListarCeramico(ActionEvent arg0) {		
		ListarCeramico at =  new ListarCeramico();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
	
	protected void actionPerformedModificarCeramico(ActionEvent arg0) {		
		ModificarCermaico at =  new ModificarCermaico();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
	
	protected void actionPerformedVender(ActionEvent arg0) {		
		Vender at =  new Vender();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
	
	protected void actionPerformedGenerarReportes(ActionEvent arg0) {		
		GenerarReportes at =  new GenerarReportes();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
	
	protected void actionPerformedConfDescuentos(ActionEvent arg0) {		
		ConfPorDescuento at =  new ConfPorDescuento();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
	
	protected void actionPerformedConfObsequios(ActionEvent arg0){		
		ConfObsequios at =  new ConfObsequios();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
	
	protected void actionPerformedConfCantidadOptima(ActionEvent arg0) {		
		ConfCantOptima at =  new ConfCantOptima();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
	
	protected void actionPerformedConfCuotaDiaria(ActionEvent arg0) {		
		ConfCuota at =  new ConfCuota();		
		contentPane.add(at);

		Dimension desktopSize = contentPane.getSize();
        Dimension FrameSize = at.getSize();
        at.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        at.show();
	}
}
