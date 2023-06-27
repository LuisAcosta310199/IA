package cibertec;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarCeramico extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextArea txtListar;
	private JButton btnCerrar;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCeramico frame = new ListarCeramico();
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
	public ListarCeramico() {
		setClosable(true);
		setTitle("Listar Ceramico");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 220);
		getContentPane().add(scrollPane);
		
		txtListar = new TextArea();
		txtListar.setEditable(false);
		scrollPane.setViewportView(txtListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame i = new ListarCeramico();
	            i.dispose();	            
			}
		});
		btnCerrar.setBounds(113, 242, 89, 23);
		getContentPane().add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				actionPerformedListar();
			}
		});
		btnListar.setBounds(212, 242, 89, 23);
		getContentPane().add(btnListar);

	}	
	
	private void actionPerformedListar(){
		txtListar.setText("LISTADO DE CERAMICOS" + "\n\n");
		txtListar.append("Modelo		:" + Tienda.modelo0 + "\n");
		txtListar.append("Precio		:" + Tienda.precio0 + "\n");
		txtListar.append("Ancho (cm)	:" + Tienda.ancho0 + "\n");
		txtListar.append("Largo (cm)	:" + Tienda.largo0 + "\n");
		txtListar.append("Espesor (mm)	:" + Tienda.espesor0 + "\n");
		txtListar.append("Contenido	:" + Tienda.contenido0 + "\n\n");
		
		txtListar.append("Modelo		:" + Tienda.modelo1 + "\n");
		txtListar.append("Precio		:" + Tienda.precio1 + "\n");
		txtListar.append("Ancho (cm)	:" + Tienda.ancho1 + "\n");
		txtListar.append("Largo (cm)	:" + Tienda.largo1 + "\n");
		txtListar.append("Espesor (mm)	:" + Tienda.espesor1 + "\n");
		txtListar.append("Contenido	:" + Tienda.contenido1 + "\n\n");
		
		txtListar.append("Modelo		:" + Tienda.modelo2 + "\n");
		txtListar.append("Precio		:" + Tienda.precio2 + "\n");
		txtListar.append("Ancho (cm)	:" + Tienda.ancho2 + "\n");
		txtListar.append("Largo (cm)	:" + Tienda.largo2 + "\n");
		txtListar.append("Espesor (mm)	:" + Tienda.espesor2 + "\n");
		txtListar.append("Contenido	:" + Tienda.contenido2 + "\n\n");
		
		txtListar.append("Modelo		:" + Tienda.modelo3 + "\n");
		txtListar.append("Precio		:" + Tienda.precio3 + "\n");
		txtListar.append("Ancho (cm)	:" + Tienda.ancho3 + "\n");
		txtListar.append("Largo (cm)	:" + Tienda.largo3 + "\n");
		txtListar.append("Espesor (mm)	:" + Tienda.espesor3 + "\n");
		txtListar.append("Contenido	:" + Tienda.contenido3 + "\n\n");
		
		txtListar.append("Modelo		:" + Tienda.modelo4 + "\n");
		txtListar.append("Precio		:" + Tienda.precio4 + "\n");
		txtListar.append("Ancho (cm)	:" + Tienda.ancho4 + "\n");
		txtListar.append("Largo (cm)	:" + Tienda.largo4 + "\n");
		txtListar.append("Espesor (mm)	:" + Tienda.espesor4 + "\n");
		txtListar.append("Contenido	:" + Tienda.contenido4 + "\n");
	}
}
