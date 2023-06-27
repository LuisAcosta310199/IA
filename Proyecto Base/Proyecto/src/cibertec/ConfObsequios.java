package cibertec;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfObsequios extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt11amas;
	private JTextField txt6a10;
	private JTextField txt1a5;
	private JTextField txtTipoObsequio;
	private JButton btnAceptar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfObsequios frame = new ConfObsequios();
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
	public ConfObsequios() {
		setClosable(true);
		setTitle("Configuracion de Obsequio");
		setBounds(100, 100, 450, 158);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeObsequio = new JLabel("Tipo de Obsequio");
		lblTipoDeObsequio.setBounds(10, 14, 83, 14);
		getContentPane().add(lblTipoDeObsequio);
		
		JLabel label_1 = new JLabel("1 a 5 Unidades");
		label_1.setBounds(10, 42, 83, 14);
		getContentPane().add(label_1);
		
		JLabel lblA = new JLabel("6 a 10 Unidades");
		lblA.setBounds(10, 70, 83, 14);
		getContentPane().add(lblA);
		
		JLabel lblAMas = new JLabel("11 a mas Unidades");
		lblAMas.setBounds(10, 98, 112, 14);
		getContentPane().add(lblAMas);
		
		txt11amas = new JTextField();
		txt11amas.setColumns(10);
		txt11amas.setBounds(132, 95, 86, 20);
		getContentPane().add(txt11amas);
		
		txt6a10 = new JTextField();
		txt6a10.setColumns(10);
		txt6a10.setBounds(132, 67, 86, 20);
		getContentPane().add(txt6a10);
		
		txt1a5 = new JTextField();
		txt1a5.setColumns(10);
		txt1a5.setBounds(132, 39, 86, 20);
		getContentPane().add(txt1a5);
		
		txtTipoObsequio = new JTextField();
		txtTipoObsequio.setColumns(10);
		txtTipoObsequio.setBounds(132, 11, 86, 20);
		getContentPane().add(txtTipoObsequio);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionConfiguracionObsequios();
			}
		});
		btnAceptar.setBounds(335, 14, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 42, 89, 23);
		getContentPane().add(btnCancelar);

		txtTipoObsequio.setText(String.valueOf(Tienda.tipoObsequio));
		txt1a5.setText(String.valueOf(Tienda.obsequioCantidad1));
		txt6a10.setText(String.valueOf(Tienda.obsequioCantidad2));
		txt11amas.setText(String.valueOf(Tienda.obsequioCantidad3));
	}
	
	private void actionConfiguracionObsequios(){
		Tienda.tipoObsequio = txtTipoObsequio.getText();
		Tienda.obsequioCantidad1 = Integer.parseInt(txt1a5.getText());
		Tienda.obsequioCantidad2 = Integer.parseInt(txt6a10.getText());
		Tienda.obsequioCantidad3 = Integer.parseInt(txt11amas.getText());
	}
}
