package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Articulo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class FrmArticulo extends JFrame {
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtPrecioCosto;
	private JTextField txtPrecioVenta;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private JPanel panel;
	private JButton btnCalcular;
	private JPanel panel_1;

	
	public FrmArticulo() {
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	
	
	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 298);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(33, 46, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(33, 87, 46, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblPrecioCosto = new JLabel("Precio de costo");
		lblPrecioCosto.setBounds(33, 126, 73, 14);
		getContentPane().add(lblPrecioCosto);
		
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(102, 43, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(102, 84, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtPrecioCosto = new JTextField();
		txtPrecioCosto.setBounds(128, 120, 86, 20);
		getContentPane().add(txtPrecioCosto);
		txtPrecioCosto.setColumns(10);
		
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del articulo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(10, 18, 233, 196);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(400, 225, 66, 23);
		getContentPane().add(btnSalir);
		
		btnLimpiar = new JButton("Limpiar");	
		btnLimpiar.setBounds(253, 225, 89, 23);
		getContentPane().add(btnLimpiar);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Precio de venta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(253, 18, 213, 80);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(10, 25, 86, 23);
		panel_1.add(btnCalcular);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setBounds(117, 26, 86, 20);
		panel_1.add(txtPrecioVenta);
		txtPrecioVenta.setColumns(10);
		
	}
	
		
		private void iniciarManejadoresEventos() {
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtNombre.setText(null);
					txtCodigo.setText(null);
					txtPrecioCosto.setText(null);
					txtPrecioVenta.setText(null);
				
				}
			});
			
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nombre=txtNombre.getText();
					int codigo=Integer.valueOf(txtCodigo.getText());
					double precioCosto=Double.valueOf(txtPrecioCosto.getText());
					Articulo a=new Articulo(codigo,nombre,precioCosto);
					txtPrecioVenta.setText(String.valueOf(a.precioVenta()));
					
				}
			});
		}
		
		
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FrmArticulo frame = new FrmArticulo();
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}
			});
		}
}
