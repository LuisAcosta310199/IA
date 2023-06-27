package cibertec;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfCantOptima extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCantidadOptima;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfCantOptima frame = new ConfCantOptima();
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
	public ConfCantOptima() {
		setClosable(true);
		setTitle("Configurar Cantidad Optima");
		setBounds(100, 100, 450, 108);
		getContentPane().setLayout(null);
		
		JLabel lblCantidadOptima = new JLabel("Cantidad optima de unidades vendidas");
		lblCantidadOptima.setBounds(10, 14, 208, 14);
		getContentPane().add(lblCantidadOptima);
		
		txtCantidadOptima = new JTextField();
		txtCantidadOptima.setColumns(10);
		txtCantidadOptima.setBounds(228, 11, 86, 20);
		getContentPane().add(txtCantidadOptima);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionConfiguracionCuota();
			}
		});
		btnAceptar.setBounds(335, 14, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 42, 89, 23);
		getContentPane().add(btnCancelar);

		txtCantidadOptima.setText(String.valueOf(Tienda.cantidadOptima));
	}
	
	private void actionConfiguracionCuota(){
		Tienda.cantidadOptima = Integer.parseInt(txtCantidadOptima.getText());
	}
	
}
