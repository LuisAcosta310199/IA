package cibertec;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vender extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JComboBox<Object> cboModelo;
	private TextArea txtBoleta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender();
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
	public Vender() {
		setClosable(true);
		setTitle("Vender");
		setBounds(100, 100, 450, 318);
		getContentPane().setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(10, 11, 80, 14);
		getContentPane().add(lblModelo);
		
		cboModelo = new JComboBox<Object>();
		cboModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionChangeCereamico();
			}
		});
		cboModelo.setModel(new DefaultComboBoxModel<Object>(new String[] {Tienda.modelo0, Tienda.modelo1, Tienda.modelo2, Tienda.modelo3, Tienda.modelo4}));
		cboModelo.setBounds(100, 11, 195, 20);
		getContentPane().add(cboModelo);
		
		JLabel lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(10, 41, 80, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(100, 43, 195, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidad.setBounds(10, 72, 80, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(100, 74, 195, 20);
		getContentPane().add(txtCantidad);
		
		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtCantidad.getText().length() == 0 || Integer.parseInt(txtCantidad.getText()) == 0){
					JOptionPane.showConfirmDialog(null, "El campo cantidad debe ser mayor a 0",
			                "Alerta", JOptionPane.CLOSED_OPTION,
			                JOptionPane.INFORMATION_MESSAGE);
				} else {
					actionVenderCeramico();					
				}
			}
		});
		btnVender.setBounds(305, 8, 119, 23);
		getContentPane().add(btnVender);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(305, 38, 119, 23);
		getContentPane().add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 414, 170);
		getContentPane().add(scrollPane);
		
		txtBoleta = new TextArea();
		scrollPane.setViewportView(txtBoleta);
		
		txtPrecio.setText(String.valueOf(Tienda.precio0));
	}
	
	private void actionChangeCereamico(){
		switch (cboModelo.getSelectedIndex()) {
		case 0:
			txtPrecio.setText(String.valueOf(Tienda.precio0));
			break;
		case 1:
			txtPrecio.setText(String.valueOf(Tienda.precio1));
			break;	
		case 2:
			txtPrecio.setText(String.valueOf(Tienda.precio2));
			break;	
		case 3:
			txtPrecio.setText(String.valueOf(Tienda.precio3));
			break;
		default:
			txtPrecio.setText(String.valueOf(Tienda.precio4));
		}
	}		
	
	private void actionVenderCeramico(){
		
		int UnidadesObsequidas = 0;				
		Double ImporteCompra = 0.0, ImporteDescuento = 0.0, ImportePagar = 0.0, PorcentajeCuotaDiaria = 0.0;
		
		if(Integer.parseInt(txtCantidad.getText()) >= 1 && Integer.parseInt(txtCantidad.getText()) <= 5) {		
			UnidadesObsequidas = Tienda.obsequioCantidad1;
		} else if(Integer.parseInt(txtCantidad.getText()) >= 6 && Integer.parseInt(txtCantidad.getText()) <= 10) {		
			UnidadesObsequidas = Tienda.obsequioCantidad2;
		} else {
			UnidadesObsequidas = Tienda.obsequioCantidad3;
		}
		switch (cboModelo.getSelectedIndex()) {
		case 0: 
			ImporteCompra = Integer.parseInt(txtCantidad.getText()) * Tienda.precio0;
			
			if(Integer.parseInt(txtCantidad.getText()) >= 1 && Integer.parseInt(txtCantidad.getText()) <= 5) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje1/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 6 && Integer.parseInt(txtCantidad.getText()) <= 10) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje2/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 11 && Integer.parseInt(txtCantidad.getText()) <= 15) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje3/100);
			} else {
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje4/100);
			}
			
			ImportePagar = ImporteCompra - ImporteDescuento;
			
			ImporteCompra = (double) Math.round(ImporteCompra*100)/100;
			ImporteDescuento = (double) Math.round(ImporteDescuento*100)/100;
			ImportePagar = (double) Math.round(ImportePagar*100)/100;
			
			txtBoleta.setText("BOLETA DE VENTA" + "\n\n");
			txtBoleta.append("Modelo:" + Tienda.modelo0 + "\n");
			txtBoleta.append("Precio:" + Tienda.precio0 + "\n");
			txtBoleta.append("Cantidad adquirida:" + txtCantidad.getText() + "\n");
			txtBoleta.append("Importe compra:" + ImporteCompra+ "\n");
			txtBoleta.append("Importe descuento:" + ImporteDescuento + "\n");
			txtBoleta.append("Importe pagar:" + ImportePagar + "\n");
			txtBoleta.append("Tipo de obsequio:" + Tienda.tipoObsequio + "\n");
			txtBoleta.append("Unidades obsequiadas:" + UnidadesObsequidas + "\n\n");
			
			Tienda.ventaAcumulada = Tienda.ventaAcumulada + ImportePagar;
			Tienda.numeroVenta = Tienda.numeroVenta + 1;
			
			Tienda.nroventaC0 = Tienda.nroventaC0 + 1;
			Tienda.nrocajaC0 = Tienda.nrocajaC0 + Integer.parseInt(txtCantidad.getText());
			Tienda.impventaC0 = Tienda.impventaC0 + ImportePagar; 
			break;
		case 1:
			ImporteCompra = Integer.parseInt(txtCantidad.getText()) * Tienda.precio1;
			
			if(Integer.parseInt(txtCantidad.getText()) >= 1 && Integer.parseInt(txtCantidad.getText()) <= 5) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje1/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 6 && Integer.parseInt(txtCantidad.getText()) <= 10) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje2/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 11 && Integer.parseInt(txtCantidad.getText()) <= 15) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje3/100);
			} else {
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje4/100);
			}
			
			ImportePagar = ImporteCompra - ImporteDescuento;
			
			ImporteCompra = (double) Math.round(ImporteCompra*100)/100;
			ImporteDescuento = (double) Math.round(ImporteDescuento*100)/100;
			ImportePagar = (double) Math.round(ImportePagar*100)/100;
			
			txtBoleta.setText("BOLETA DE VENTA" + "\n\n");
			txtBoleta.append("Modelo:" + Tienda.modelo1 + "\n");
			txtBoleta.append("Precio:" + Tienda.precio1 + "\n");
			txtBoleta.append("Cantidad adquirida:" + txtCantidad.getText() + "\n");
			txtBoleta.append("Importe compra:" + ImporteCompra+ "\n");
			txtBoleta.append("Importe descuento:" + ImporteDescuento + "\n");
			txtBoleta.append("Importe pagar:" + ImportePagar + "\n");
			txtBoleta.append("Tipo de obsequio:" + Tienda.tipoObsequio + "\n");
			txtBoleta.append("Unidades obsequiadas:" + UnidadesObsequidas + "\n\n");
			
			Tienda.ventaAcumulada = Tienda.ventaAcumulada + ImportePagar;
			Tienda.numeroVenta = Tienda.numeroVenta + 1;
			
			Tienda.nroventaC1 = Tienda.nroventaC1 + 1;
			Tienda.nrocajaC1 = Tienda.nrocajaC1 + Integer.parseInt(txtCantidad.getText());
			Tienda.impventaC1 = Tienda.impventaC1 + ImportePagar;
			break;	
		case 2:
			ImporteCompra = Integer.parseInt(txtCantidad.getText()) * Tienda.precio2;
			
			if(Integer.parseInt(txtCantidad.getText()) >= 1 && Integer.parseInt(txtCantidad.getText()) <= 5) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje1/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 6 && Integer.parseInt(txtCantidad.getText()) <= 10) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje2/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 11 && Integer.parseInt(txtCantidad.getText()) <= 15) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje3/100);
			} else {
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje4/100);
			}
			
			ImportePagar = ImporteCompra - ImporteDescuento;
			
			ImporteCompra = (double) Math.round(ImporteCompra*100)/100;
			ImporteDescuento = (double) Math.round(ImporteDescuento*100)/100;
			ImportePagar = (double) Math.round(ImportePagar*100)/100;
			
			txtBoleta.setText("BOLETA DE VENTA" + "\n\n");
			txtBoleta.append("Modelo:" + Tienda.modelo2 + "\n");
			txtBoleta.append("Precio:" + Tienda.precio2 + "\n");
			txtBoleta.append("Cantidad adquirida:" + txtCantidad.getText() + "\n");
			txtBoleta.append("Importe compra:" + ImporteCompra+ "\n");
			txtBoleta.append("Importe descuento:" + ImporteDescuento + "\n");
			txtBoleta.append("Importe pagar:" + ImportePagar + "\n");
			txtBoleta.append("Tipo de obsequio:" + Tienda.tipoObsequio + "\n");
			txtBoleta.append("Unidades obsequiadas:" + UnidadesObsequidas + "\n\n");
			
			Tienda.ventaAcumulada = Tienda.ventaAcumulada + ImportePagar;
			Tienda.numeroVenta = Tienda.numeroVenta + 1;
			
			Tienda.nroventaC2 = Tienda.nroventaC2 + 1;
			Tienda.nrocajaC2 = Tienda.nrocajaC2 + Integer.parseInt(txtCantidad.getText());
			Tienda.impventaC2 = Tienda.impventaC2 + ImportePagar;
			break;	
		case 3:
			ImporteCompra = Integer.parseInt(txtCantidad.getText()) * Tienda.precio3;
			
			if(Integer.parseInt(txtCantidad.getText()) >= 1 && Integer.parseInt(txtCantidad.getText()) <= 5) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje1/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 6 && Integer.parseInt(txtCantidad.getText()) <= 10) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje2/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 11 && Integer.parseInt(txtCantidad.getText()) <= 15) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje3/100);
			} else {
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje4/100);
			}
			
			ImportePagar = ImporteCompra - ImporteDescuento;
			
			ImporteCompra = (double) Math.round(ImporteCompra*100)/100;
			ImporteDescuento = (double) Math.round(ImporteDescuento*100)/100;
			ImportePagar = (double) Math.round(ImportePagar*100)/100;
			
			txtBoleta.setText("BOLETA DE VENTA" + "\n\n");
			txtBoleta.append("Modelo:" + Tienda.modelo3 + "\n");
			txtBoleta.append("Precio:" + Tienda.precio3 + "\n");
			txtBoleta.append("Cantidad adquirida:" + txtCantidad.getText() + "\n");
			txtBoleta.append("Importe compra:" + ImporteCompra+ "\n");
			txtBoleta.append("Importe descuento:" + ImporteDescuento + "\n");
			txtBoleta.append("Importe pagar:" + ImportePagar + "\n");
			txtBoleta.append("Tipo de obsequio:" + Tienda.tipoObsequio + "\n");
			txtBoleta.append("Unidades obsequiadas:" + UnidadesObsequidas + "\n\n");
			
			Tienda.ventaAcumulada = Tienda.ventaAcumulada + ImportePagar;
			Tienda.numeroVenta = Tienda.numeroVenta + 1;
			
			Tienda.nroventaC3 = Tienda.nroventaC3 + 1;
			Tienda.nrocajaC3 = Tienda.nrocajaC3 + Integer.parseInt(txtCantidad.getText());
			Tienda.impventaC3 = Tienda.impventaC3 + ImportePagar;
			break;
		default:
			ImporteCompra = Integer.parseInt(txtCantidad.getText()) * Tienda.precio4;
			
			if(Integer.parseInt(txtCantidad.getText()) >= 1 && Integer.parseInt(txtCantidad.getText()) <= 5) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje1/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 6 && Integer.parseInt(txtCantidad.getText()) <= 10) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje2/100);
			} else if(Integer.parseInt(txtCantidad.getText()) >= 11 && Integer.parseInt(txtCantidad.getText()) <= 15) {		
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje3/100);
			} else {
				ImporteDescuento = ImporteCompra * (Tienda.porcentaje4/100);
			}
			
			ImportePagar = ImporteCompra - ImporteDescuento;
			
			ImporteCompra = (double) Math.round(ImporteCompra*100)/100;
			ImporteDescuento = (double) Math.round(ImporteDescuento*100)/100;
			ImportePagar = (double) Math.round(ImportePagar*100)/100;
			
			txtBoleta.setText("BOLETA DE VENTA" + "\n\n");
			txtBoleta.append("Modelo:" + Tienda.modelo4 + "\n");
			txtBoleta.append("Precio:" + Tienda.precio4 + "\n");
			txtBoleta.append("Cantidad adquirida:" + txtCantidad.getText() + "\n");
			txtBoleta.append("Importe compra:" + ImporteCompra+ "\n");
			txtBoleta.append("Importe descuento:" + ImporteDescuento + "\n");
			txtBoleta.append("Importe pagar:" + ImportePagar + "\n");
			txtBoleta.append("Tipo de obsequio:" + Tienda.tipoObsequio + "\n");
			txtBoleta.append("Unidades obsequiadas:" + UnidadesObsequidas + "\n\n");
			
			Tienda.ventaAcumulada = Tienda.ventaAcumulada + ImportePagar;
			Tienda.numeroVenta = Tienda.numeroVenta + 1;
			
			Tienda.nroventaC4 = Tienda.nroventaC4 + 1;
			Tienda.nrocajaC4 = Tienda.nrocajaC4 + Integer.parseInt(txtCantidad.getText());
			Tienda.impventaC4 = Tienda.impventaC4 + ImportePagar;
		}
		
		PorcentajeCuotaDiaria = Tienda.ventaAcumulada/Tienda.cuotaDiaria*100;
		
		PorcentajeCuotaDiaria = (double) Math.round(PorcentajeCuotaDiaria*100)/100;
		
		//agregar notificacion de venta
		if(Tienda.numeroVenta%5 == 0){
			JOptionPane.showConfirmDialog(null, "Venta Nro. " + Tienda.numeroVenta + "\n"
					+ "Importe total general acumulado : S/. " + Tienda.ventaAcumulada  + "\n"
					+ "Porcentaje de la cuota diaria : " + PorcentajeCuotaDiaria + "%",
	                "Avance de venta", JOptionPane.CLOSED_OPTION,
	                JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
