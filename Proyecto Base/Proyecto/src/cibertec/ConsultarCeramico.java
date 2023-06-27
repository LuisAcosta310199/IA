package cibertec;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarCeramico extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JTextField txtContenido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCeramico frame = new ConsultarCeramico();
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
	public ConsultarCeramico() {
		setClosable(true);
		setTitle("Consultar Ceramico");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(10, 11, 80, 14);
		getContentPane().add(lblModelo);
		
		cboModelo = new JComboBox<Object>();
		cboModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionChangeCeramico();
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
		
		JLabel lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAncho.setBounds(10, 72, 80, 14);
		getContentPane().add(lblAncho);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(100, 74, 195, 20);
		getContentPane().add(txtAncho);
		
		JLabel lblLargo = new JLabel("Largo (cm)");
		lblLargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLargo.setBounds(10, 103, 80, 14);
		getContentPane().add(lblLargo);
		
		txtLargo = new JTextField();
		txtLargo.setEditable(false);
		txtLargo.setColumns(10);
		txtLargo.setBounds(100, 105, 195, 20);
		getContentPane().add(txtLargo);
		
		JLabel lblEspesor = new JLabel("Espesor (mm)");
		lblEspesor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspesor.setBounds(10, 134, 80, 14);
		getContentPane().add(lblEspesor);
		
		txtEspesor = new JTextField();
		txtEspesor.setEditable(false);
		txtEspesor.setColumns(10);
		txtEspesor.setBounds(100, 136, 195, 20);
		getContentPane().add(txtEspesor);
		
		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContenido.setBounds(10, 165, 80, 14);
		getContentPane().add(lblContenido);
		
		txtContenido = new JTextField();
		txtContenido.setEditable(false);
		txtContenido.setColumns(10);
		txtContenido.setBounds(100, 167, 195, 20);
		getContentPane().add(txtContenido);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(305, 8, 119, 23);
		getContentPane().add(btnCerrar);
		
		txtPrecio.setText(String.valueOf(Tienda.precio0));
		txtAncho.setText(String.valueOf(Tienda.ancho0));
		txtLargo.setText(String.valueOf(Tienda.largo0));
		txtEspesor.setText(String.valueOf(Tienda.espesor0));
		txtContenido.setText(String.valueOf(Tienda.contenido0));

	}
	
	private void actionChangeCeramico(){
		switch (cboModelo.getSelectedIndex()) {
		case 0:
			txtPrecio.setText(String.valueOf(Tienda.precio0));
			txtAncho.setText(String.valueOf(Tienda.ancho0));
			txtLargo.setText(String.valueOf(Tienda.largo0));
			txtEspesor.setText(String.valueOf(Tienda.espesor0));
			txtContenido.setText(String.valueOf(Tienda.contenido0));
			break;
		case 1:
			txtPrecio.setText(String.valueOf(Tienda.precio1));
			txtAncho.setText(String.valueOf(Tienda.ancho1));
			txtLargo.setText(String.valueOf(Tienda.largo1));
			txtEspesor.setText(String.valueOf(Tienda.espesor1));
			txtContenido.setText(String.valueOf(Tienda.contenido1));
			break;	
		case 2:
			txtPrecio.setText(String.valueOf(Tienda.precio2));
			txtAncho.setText(String.valueOf(Tienda.ancho2));
			txtLargo.setText(String.valueOf(Tienda.largo2));
			txtEspesor.setText(String.valueOf(Tienda.espesor2));
			txtContenido.setText(String.valueOf(Tienda.contenido2));
			break;	
		case 3:
			txtPrecio.setText(String.valueOf(Tienda.precio3));
			txtAncho.setText(String.valueOf(Tienda.ancho3));
			txtLargo.setText(String.valueOf(Tienda.largo3));
			txtEspesor.setText(String.valueOf(Tienda.espesor3));
			txtContenido.setText(String.valueOf(Tienda.contenido3));
			break;
		default:
			txtPrecio.setText(String.valueOf(Tienda.precio4));
			txtAncho.setText(String.valueOf(Tienda.ancho4));
			txtLargo.setText(String.valueOf(Tienda.largo4));
			txtEspesor.setText(String.valueOf(Tienda.espesor4));
			txtContenido.setText(String.valueOf(Tienda.contenido4));
		}
	}
}
