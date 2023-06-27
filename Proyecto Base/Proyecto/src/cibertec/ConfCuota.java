package cibertec;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfCuota extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCuotaDiaria;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfCuota frame = new ConfCuota();
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
	public ConfCuota() {
		setClosable(true);
		setTitle("Configurar Cuota Diaria");
		setBounds(100, 100, 450, 112);
		getContentPane().setLayout(null);
		
		JLabel lblCuotaDiariaEsperada = new JLabel("Cuota Diaria Esperada (S/.)");
		lblCuotaDiariaEsperada.setBounds(10, 14, 208, 14);
		getContentPane().add(lblCuotaDiariaEsperada);
		
		txtCuotaDiaria = new JTextField();
		txtCuotaDiaria.setColumns(10);
		txtCuotaDiaria.setBounds(228, 11, 86, 20);
		getContentPane().add(txtCuotaDiaria);
		
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

		txtCuotaDiaria.setText(String.valueOf(Tienda.cuotaDiaria));
	}
	
	private void actionConfiguracionCuota(){
		Tienda.cuotaDiaria = Double.parseDouble(txtCuotaDiaria.getText());
	}
	
}
