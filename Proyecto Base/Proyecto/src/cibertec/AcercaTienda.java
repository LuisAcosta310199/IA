package cibertec;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class AcercaTienda extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaTienda frame = new AcercaTienda();
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
	public AcercaTienda() {
		setClosable(true);
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblTienda = new JLabel("TIENDA 1.0");
		lblTienda.setBounds(0, 0, 434, 70);
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setFont(new Font("Tahoma", Font.PLAIN, 60));
		getContentPane().add(lblTienda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1, 75, 434, 2);
		getContentPane().add(separator);

		JLabel lblAutores = new JLabel("AUTORES");
		lblAutores.setBounds(0, 85, 434, 40);
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblAutores);
		
		JLabel lblAutor1 = new JLabel("Nombre 1");
		lblAutor1.setBounds(0, 128, 434, 20);
		lblAutor1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblAutor1);
		
		JLabel lblAutor2 = new JLabel("Nombre 2");
		lblAutor2.setBounds(0, 159, 434, 20);
		lblAutor2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblAutor2);
		
		JLabel lblAutor3 = new JLabel("Nombre 3");
		lblAutor3.setBounds(0, 190, 434, 20);
		lblAutor3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblAutor3);
	}
}
