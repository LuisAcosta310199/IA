package cibertec;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerarReportes extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> cboReporte;
	private JButton btnProcesar;
	private TextArea txtReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarReportes frame = new GenerarReportes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenerarReportes() {
		setClosable(true);
		setTitle("Generar Reportes");
		setBounds(100, 100, 569, 300);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeReporte = new JLabel("TIPO DE REPORTE");
		lblTipoDeReporte.setBounds(10, 11, 105, 14);
		getContentPane().add(lblTipoDeReporte);
		
		cboReporte = new JComboBox<Object>();
		cboReporte.setModel(new DefaultComboBoxModel<Object>(new String[] {"Ventas por modelo", "Comparacion de precios con el precio promedio", "Comparacion de cajas vendidas con la cantidad optima", "Estadisticas sobre el precio"}));
		cboReporte.setBounds(115, 8, 329, 20);
		getContentPane().add(cboReporte);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionCambiarReporte();
			}
		});
		btnProcesar.setBounds(454, 7, 89, 23);
		getContentPane().add(btnProcesar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 533, 222);
		getContentPane().add(scrollPane);
		
		txtReporte = new TextArea();
		scrollPane.setViewportView(txtReporte);

	}
	
	private void actionCambiarReporte(){
		double montoMaximo = 0.0, montoMinimo = 0.0, promedio = 0.0;
		String prom0 = "", prom1 = "", prom2 = "", prom3 = "", prom4 = "";
		switch (cboReporte.getSelectedIndex()) {
		case 0:
			txtReporte.setText("");
			txtReporte.append("ESTADÍSTICA SOBRE EL PRECIO" + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo0 + "\n");
			txtReporte.append("Cantidad de ventas : " + Tienda.nroventaC0+ "\n");
			txtReporte.append("Cantidad de cajas vendidas : " + Tienda.nrocajaC0 + "\n");
			txtReporte.append("Importe Total vendido : " + Tienda.impventaC0+ "\n\n");
			txtReporte.append("aporte a la cuota diaria : " + Math.round((Tienda.impventaC0/Tienda.cuotaDiaria*100)*100)/100 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo1 + "\n");
			txtReporte.append("Cantidad de ventas : " + Tienda.nroventaC1 + "\n");
			txtReporte.append("Cantidad de cajas vendidas : " + Tienda.nrocajaC1 + "\n");
			txtReporte.append("Importe Total vendido : " + Tienda.impventaC1+ "\n\n");
			txtReporte.append("aporte a la cuota diaria : " + Math.round((Tienda.impventaC1/Tienda.cuotaDiaria*100)*100)/100 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo2 + "\n");
			txtReporte.append("Cantidad de ventas : " + Tienda.nroventaC2+ "\n");
			txtReporte.append("Cantidad de cajas vendidas : " + Tienda.nrocajaC2 + "\n");
			txtReporte.append("Importe Total vendido : " + Tienda.impventaC2+ "\n\n");
			txtReporte.append("aporte a la cuota diaria : " + Math.round((Tienda.impventaC2/Tienda.cuotaDiaria*100)*100)/100 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo3 + "\n");
			txtReporte.append("Cantidad de ventas : " + Tienda.nroventaC3+ "\n");
			txtReporte.append("Cantidad de cajas vendidas : " + Tienda.nrocajaC3 + "\n");
			txtReporte.append("Importe Total vendido : " + Tienda.impventaC3+ "\n\n");
			txtReporte.append("aporte a la cuota diaria : " + Math.round((Tienda.impventaC3/Tienda.cuotaDiaria*100)*100)/100 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo4 + "\n");
			txtReporte.append("Cantidad de ventas : " + Tienda.nroventaC4+ "\n");
			txtReporte.append("Cantidad de cajas vendidas : " + Tienda.nrocajaC4 + "\n");
			txtReporte.append("Importe Total vendido : " + Tienda.impventaC4+ "\n\n");
			txtReporte.append("aporte a la cuota diaria : " + Math.round((Tienda.impventaC4/Tienda.cuotaDiaria*100)*100)/100 + "\n\n");
			break;
		case 1:
			
			promedio = Math.round(((Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4)/5)*100)/100;
			
			if(Tienda.precio0 - promedio > 0){
				prom0 = Math.abs(Math.round((Tienda.precio0 - promedio)*100)/100) + " más que el promedio";
			} else if(Tienda.precio0 - promedio == 0){
				prom0 = "igual que el precio promedio";
			} else{
				prom0 = Math.abs(Math.round((Tienda.precio0 - promedio)*100)/100) + " menos que el promedio";
			}
			
			if(Tienda.precio1 - promedio > 0){
				prom1 = Math.abs(Math.round((Tienda.precio1 - promedio)*100)/100) + " más que el promedio";
			} else if(Tienda.precio1 - promedio == 0){
				prom1 = "igual que el precio promedio";
			} else{
				prom1 = Math.abs(Math.round((Tienda.precio1 - promedio)*100)/100) + " menos que el promedio";
			}
			
			if(Tienda.precio2 - promedio > 0){
				prom2 = Math.abs(Math.round((Tienda.precio2 - promedio)*100)/100) + " más que el promedio";
			} else if(Tienda.precio2 - promedio == 0){
				prom2 = "igual que el precio promedio";
			} else{
				prom2 = Math.abs(Math.round((Tienda.precio2 - promedio)*100)/100) + " menos que el promedio";
			}

			if(Tienda.precio3 - promedio > 0){
				prom3 = Math.abs(Math.round((Tienda.precio3 - promedio)*100)/100) + " más que el promedio";
			} else if(Tienda.precio3 - promedio == 0){
				prom3 = "igual que el precio promedio";
			} else{
				prom3 = Math.abs(Math.round((Tienda.precio3 - promedio)*100)/100) + " menos que el promedio";
			}

			if(Tienda.precio4 - promedio > 0){
				prom4 = Math.abs(Math.round((Tienda.precio4 - promedio)*100)/100) + " más que el promedio";
			} else if(Tienda.precio4 - promedio == 0){
				prom4 = "igual que el precio promedio";
			} else{
				prom4 = Math.abs(Math.round((Tienda.precio4 - promedio)*100)/100) + " menos que el promedio";
			}
			
			txtReporte.setText("");
			txtReporte.append("ESTADÍSTICA SOBRE EL PRECIO" + "\n\n");

			txtReporte.append("Modelo : " + Tienda.modelo0 + "\n");
			txtReporte.append("Precio : " + Tienda.precio0 + "\n");
			txtReporte.append("Precio promedio : " + promedio + "\n");
			txtReporte.append("Comparacion : " + prom0 + "\n\n");

			txtReporte.append("Modelo : " + Tienda.modelo1 + "\n");
			txtReporte.append("Precio : " + Tienda.precio1 + "\n");
			txtReporte.append("Precio promedio : " + promedio + "\n");
			txtReporte.append("Comparacion : " + prom1 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo2 + "\n");
			txtReporte.append("Precio : " + Tienda.precio2 + "\n");
			txtReporte.append("Precio promedio : " + promedio + "\n");
			txtReporte.append("Comparacion : " + prom2 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo3 + "\n");
			txtReporte.append("Precio : " + Tienda.precio3 + "\n");
			txtReporte.append("Precio promedio : " + promedio + "\n");
			txtReporte.append("Comparacion : " + prom3 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo4 + "\n");
			txtReporte.append("Precio : " + Tienda.precio4 + "\n");
			txtReporte.append("Precio promedio : " + promedio + "\n");
			txtReporte.append("Comparacion : " + prom4 + "\n\n");
			break;	
		case 2:
			
			if(Tienda.nrocajaC0 - Tienda.cantidadOptima > 0){
				prom0 = Math.abs(Tienda.nrocajaC0 - Tienda.cantidadOptima) + " más que la cantidad óptima";
			} else if(Tienda.nrocajaC0 - Tienda.cantidadOptima == 0){
				prom0 = "igual que la cantidad óptima";
			} else{
				prom0 = Math.abs(Tienda.nrocajaC0 - Tienda.cantidadOptima) + " menos que cantidad óptima";
			}
			
			if(Tienda.nrocajaC1 - Tienda.cantidadOptima > 0){
				prom1 = Math.abs(Tienda.nrocajaC1 - Tienda.cantidadOptima) + " más que la cantidad óptima";
			} else if(Tienda.nrocajaC1 - Tienda.cantidadOptima == 0){
				prom1 = "igual que la cantidad óptima";
			} else{
				prom1 = Math.abs(Tienda.nrocajaC1 - Tienda.cantidadOptima) + " menos que cantidad óptima";
			}
			
			if(Tienda.nrocajaC2 - Tienda.cantidadOptima > 0){
				prom2 = Math.abs(Tienda.nrocajaC2 - Tienda.cantidadOptima) + " más que la cantidad óptima";
			} else if(Tienda.nrocajaC2 - Tienda.cantidadOptima == 0){
				prom2 = "igual que la cantidad óptima";
			} else{
				prom2 = Math.abs(Tienda.nrocajaC2 - Tienda.cantidadOptima) + " menos que cantidad óptima";
			}

			if(Tienda.nrocajaC3 - Tienda.cantidadOptima > 0){
				prom3 = Math.abs(Tienda.nrocajaC3 - Tienda.cantidadOptima) + " más que la cantidad óptima";
			} else if(Tienda.nrocajaC3 - Tienda.cantidadOptima == 0){
				prom3 = "igual que la cantidad óptima";
			} else{
				prom3 = Math.abs(Tienda.nrocajaC3 - Tienda.cantidadOptima) + " menos que cantidad óptima";
			}

			if(Tienda.nrocajaC4 - Tienda.cantidadOptima > 0){
				prom4 = Math.abs(Tienda.nrocajaC4 - Tienda.cantidadOptima) + " más que la cantidad óptima";
			} else if(Tienda.nrocajaC4 - Tienda.cantidadOptima == 0){
				prom4 = "igual que la cantidad óptima";
			} else{
				prom4 = Math.abs(Tienda.nrocajaC4 - Tienda.cantidadOptima) + " menos que cantidad óptima";
			}
			
			txtReporte.setText("");
			txtReporte.append("COMPARACIÓN DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA" + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo0 + "\n");
			txtReporte.append("Cantidad de Cajas Vendidas : " + Tienda.nrocajaC0 + "\n");
			txtReporte.append("Cantidad optima : " + Tienda.cantidadOptima + "\n");
			txtReporte.append("Comparacion : " + prom0 + "\n\n");

			txtReporte.append("Modelo : " + Tienda.modelo1 + "\n");
			txtReporte.append("Cantidad de Cajas Vendidas : " + Tienda.nrocajaC1 + "\n");
			txtReporte.append("Cantidad optima : " + Tienda.cantidadOptima + "\n");
			txtReporte.append("Comparacion : " + prom1 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo2 + "\n");
			txtReporte.append("Cantidad de Cajas Vendidas : " + Tienda.nrocajaC2 + "\n");
			txtReporte.append("Cantidad optima : " + Tienda.cantidadOptima + "\n");
			txtReporte.append("Comparacion : " + prom2 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo3 + "\n");
			txtReporte.append("Cantidad de Cajas Vendidas : " + Tienda.nrocajaC3 + "\n");
			txtReporte.append("Cantidad optima : " + Tienda.cantidadOptima + "\n");
			txtReporte.append("Comparacion : " + prom3 + "\n\n");
			
			txtReporte.append("Modelo : " + Tienda.modelo4 + "\n");
			txtReporte.append("Cantidad de Cajas Vendidas : " + Tienda.nrocajaC4 + "\n");
			txtReporte.append("Cantidad optima : " + Tienda.cantidadOptima + "\n");
			txtReporte.append("Comparacion : " + prom4 + "\n\n");
			break;
		default:
			
			montoMaximo = Math.max(Tienda.precio0, Math.max(Tienda.precio1,Math.max(Tienda.precio2,Math.max(Tienda.precio3,Tienda.precio4))));
			montoMinimo = Math.min(Tienda.precio0, Math.min(Tienda.precio1,Math.min(Tienda.precio2,Math.min(Tienda.precio3,Tienda.precio4))));
			promedio = Math.round(((Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4)/5)*100)/100;
			
			txtReporte.setText("");
			txtReporte.append("ESTADÍSTICA SOBRE EL PRECIO" + "\n\n");
			
			txtReporte.append("Precio promedio : S/. " + promedio + "\n");
			txtReporte.append("Precio mayor : S/. " + montoMaximo + "\n");
			txtReporte.append("Precio menor : S/. " + montoMinimo + "\n");
			break;
		}
	}

}
