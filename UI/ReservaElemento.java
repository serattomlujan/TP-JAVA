package UI;

import entity.Elemento;
import entity.Tipo_Elemento;
import entity.Reserva;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controlers.CtrlABMElemento;
import controlers.CtrlReserva;

import javax.swing.JEditorPane;

public class ReservaElemento extends JInternalFrame {
	
	private CtrlReserva ctrl=new CtrlReserva();

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtDetalle;
	public JComboBox<Object> cboTipos;
	public JComboBox<Object> cboElementos;
	private JTextField txtId;
	private JTextField txtFecha;
	private JTextField txtHora;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaElemento frame = new ReservaElemento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ReservaElemento() {
		setClosable(true);
		setTitle("Reserva de Elemento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 402, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblTipoDeElemento = new JLabel("Tipo de Elemento");
		
		JComboBox<?> cboTipos = new JComboBox<Object>();
		
		JLabel lblFecha = new JLabel("Fecha");
		
		JLabel lblHora = new JLabel("Hora");
		
		JLabel lblElementos = new JLabel("Elemento");
		
		JLabel lblDetalle = new JLabel("Detalle");
		
		JComboBox<?> cboElementos = new JComboBox<Object>();
		
		JTextArea txtDetalle = new JTextArea();
		txtDetalle.setRows(3);
		txtDetalle.setLineWrap(true);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				//buscarClick();
 			}
 		});
		
		JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				//aceptarClick();
 			}
 		});
		
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JLabel lblIdReserva = new JLabel("Id Reserva");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDetalle)
								.addComponent(lblElementos)
								.addComponent(lblFecha)
								.addComponent(lblTipoDeElemento)
								.addComponent(lblIdReserva))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(cboTipos, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
										.addComponent(btnBuscar))
									.addComponent(cboElementos, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(19)
										.addComponent(lblHora)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(194, Short.MAX_VALUE)
							.addComponent(btnAceptar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar)))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdReserva)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeElemento)
						.addComponent(cboTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFecha)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblHora)
							.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblElementos)
						.addComponent(cboElementos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDetalle)
						.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		loadLists();
	}
	
	 public void loadLists() {
		 	try {
		 		//this.cboTipos.setModel(new DefaultComboBoxModel<Object>(this.ctrl.getTipos().toArray()));
		 		this.cboTipos.setSelectedIndex(-1);
		 	} catch (Exception e) {
		 JOptionPane.showMessageDialog(this, "Error recuperando Tipos de Elementos");
		 }
}
}