package cibertec;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfPorDescuento extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtConfiguracion1;
	private JTextField txtConfiguracion2;
	private JTextField txtConfiguracion3;
	private JTextField txtConfiguracion4;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfPorDescuento frame = new ConfPorDescuento();
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
	public ConfPorDescuento() {
		setClosable(true);
		setTitle("Configuracion Porcentajes de Descuento");
		setBounds(100, 100, 450, 155);
		getContentPane().setLayout(null);
		
		JLabel lblA = new JLabel("1 a 5 Unidades");
		lblA.setBounds(10, 11, 83, 14);
		getContentPane().add(lblA);
		
		txtConfiguracion1 = new JTextField();
		txtConfiguracion1.setBounds(122, 11, 86, 20);
		getContentPane().add(txtConfiguracion1);
		txtConfiguracion1.setColumns(10);
		
		JLabel label = new JLabel("%");
		label.setBounds(218, 14, 83, 14);
		getContentPane().add(label);
		
		JLabel lblA_1 = new JLabel("6 a 10 Unidades");
		lblA_1.setBounds(10, 39, 83, 14);
		getContentPane().add(lblA_1);
		
		txtConfiguracion2 = new JTextField();
		txtConfiguracion2.setColumns(10);
		txtConfiguracion2.setBounds(122, 39, 86, 20);
		getContentPane().add(txtConfiguracion2);
		
		JLabel label_2 = new JLabel("%");
		label_2.setBounds(218, 42, 83, 14);
		getContentPane().add(label_2);
		
		JLabel lblA_2 = new JLabel("11 a 15 Unidades");
		lblA_2.setBounds(10, 67, 83, 14);
		getContentPane().add(lblA_2);
		
		txtConfiguracion3 = new JTextField();
		txtConfiguracion3.setColumns(10);
		txtConfiguracion3.setBounds(122, 67, 86, 20);
		getContentPane().add(txtConfiguracion3);
		
		JLabel label_4 = new JLabel("%");
		label_4.setBounds(218, 70, 83, 14);
		getContentPane().add(label_4);
		
		JLabel lblMasDeUnidades = new JLabel("Mas de15 Unidades");
		lblMasDeUnidades.setBounds(10, 95, 102, 14);
		getContentPane().add(lblMasDeUnidades);
		
		txtConfiguracion4 = new JTextField();
		txtConfiguracion4.setColumns(10);
		txtConfiguracion4.setBounds(122, 95, 86, 20);
		getContentPane().add(txtConfiguracion4);
		
		JLabel label_6 = new JLabel("%");
		label_6.setBounds(218, 98, 83, 14);
		getContentPane().add(label_6);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionConfiguracionDescuentos();
			}
		});
		btnAceptar.setBounds(335, 11, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 39, 89, 23);
		getContentPane().add(btnCancelar);
		
		txtConfiguracion1.setText(String.valueOf(Tienda.porcentaje1));
		txtConfiguracion2.setText(String.valueOf(Tienda.porcentaje2));
		txtConfiguracion3.setText(String.valueOf(Tienda.porcentaje3));
		txtConfiguracion4.setText(String.valueOf(Tienda.porcentaje4));
	}
	
	private void actionConfiguracionDescuentos(){
		Tienda.porcentaje1 = Double.parseDouble(txtConfiguracion1.getText());
		Tienda.porcentaje2 = Double.parseDouble(txtConfiguracion2.getText());
		Tienda.porcentaje3 = Double.parseDouble(txtConfiguracion3.getText());
		Tienda.porcentaje4 = Double.parseDouble(txtConfiguracion4.getText());
	}

}
