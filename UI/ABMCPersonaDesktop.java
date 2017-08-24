package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlers.CtrlABMPersona;
import Entity.Categoria;
import Entity.Persona;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class ABMCPersonaDesktop extends JInternalFrame {
	private AutoBinding<Persona, Categoria, JComboBox, Object> cbo;

private CtrlABMPersona ctrl=new CtrlABMPersona();
private Persona currentPer=new Persona();
	
private JPanel contentPane;
private JTextField txtDni;
private JTextField txtNombre;
private JTextField txtApellido;
private JCheckBox chkHabilitado;
private JButton btnAgregar;
private JButton btnBorrar;
private JButton btnModificar;
private JTextField txtId;
private JComboBox<Object> cboCategoria;

public static void main(String[] args) {
 		EventQueue.invokeLater(new Runnable() {
 			public void run() {
 				try {
 					ABMCPersonaDesktop frame = new ABMCPersonaDesktop();
 					frame.setVisible(true);
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 			}
 		});
 	}
 	public ABMCPersonaDesktop() {
 		setTitle("ABMC Persona");
 		setClosable(true);
 		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
 		setBounds(100, 100, 328, 297);
 		contentPane = new JPanel();
 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 		setContentPane(contentPane);
 		
 		JLabel lblDni = new JLabel("DNI");
 		
 		txtDni = new JTextField();
 		txtDni.setColumns(10);
 		
 		JLabel lblNombre = new JLabel("Nombre");
 		
 		JLabel lblApellido = new JLabel("Apellido");
 		
 		txtNombre = new JTextField();
 		txtNombre.setColumns(10);
 		
 		txtApellido = new JTextField();
 		txtApellido.setColumns(10);
 		
 		chkHabilitado = new JCheckBox("Habilitado");
 		chkHabilitado.setSelected(true);
 		
 		JButton btnBuscar = new JButton("Buscar");
 		btnBuscar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				buscarClick();
 			}
 		});
 		
 		btnAgregar = new JButton("Agregar");
 		btnAgregar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				agregarClick();
 			}
 		});
 		
 		btnBorrar = new JButton("Borrar");
 		btnBorrar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				borrarClick();
 			}
 		});
 		
 		btnModificar = new JButton("Modificar");
 		btnModificar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				modificarClick();
 			}
 		});
 		
 		JLabel lblId = new JLabel("ID");
 		
 		txtId = new JTextField();
 		txtId.setEditable(false);
 		txtId.setColumns(10);
 		
 		JLabel lblCategoria = new JLabel("Categoria");
 		
 		cboCategoria = new JComboBox<Object>();
 		GroupLayout gl_contentPane = new GroupLayout(contentPane);
 		gl_contentPane.setHorizontalGroup(
 			gl_contentPane.createParallelGroup(Alignment.LEADING)
 				.addGroup(gl_contentPane.createSequentialGroup()
 					.addContainerGap()
 					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
 						.addGroup(gl_contentPane.createSequentialGroup()
 							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
 								.addComponent(chkHabilitado)
 								.addGroup(gl_contentPane.createSequentialGroup()
 									.addComponent(lblCategoria)
 									.addPreferredGap(ComponentPlacement.RELATED)
 									.addComponent(cboCategoria, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
 								.addGroup(gl_contentPane.createSequentialGroup()
 									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
 										.addComponent(lblApellido)
 										.addComponent(lblId)
 										.addComponent(lblDni)
 										.addComponent(lblNombre))
 									.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
 									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
 										.addGroup(gl_contentPane.createSequentialGroup()
 											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
 												.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 												.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 												.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
 											.addGap(20)
 											.addComponent(btnBuscar))
 										.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
 							.addContainerGap())
 						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
 							.addComponent(btnAgregar)
 							.addGap(18)
 							.addComponent(btnBorrar)
 							.addGap(18)
 							.addComponent(btnModificar)
 							.addGap(24))))
 		);
 		gl_contentPane.setVerticalGroup(
 			gl_contentPane.createParallelGroup(Alignment.LEADING)
 				.addGroup(gl_contentPane.createSequentialGroup()
 					.addContainerGap()
 					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
 						.addGroup(gl_contentPane.createSequentialGroup()
 							.addComponent(btnBuscar)
 							.addGap(50)
 							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
 								.addComponent(lblApellido)
 								.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
 						.addGroup(gl_contentPane.createSequentialGroup()
 							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
 								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 								.addComponent(lblId))
 							.addGap(11)
 							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
 								.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 								.addComponent(lblDni))
 							.addGap(18)
 							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
 								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 								.addComponent(lblNombre))
 							.addGap(38)))
 					.addGap(18)
 					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
 						.addComponent(lblCategoria)
 						.addComponent(cboCategoria, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
 					.addPreferredGap(ComponentPlacement.UNRELATED)
 					.addComponent(chkHabilitado)
 					.addPreferredGap(ComponentPlacement.UNRELATED)
 					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
 						.addComponent(btnAgregar)
 						.addComponent(btnBorrar)
 						.addComponent(btnModificar))
 					.addContainerGap())
 		);
 		 contentPane.setLayout(gl_contentPane);
 		 loadLists();
 		 }
 		 
 		 private void loadLists() {
 		 	try {
 		 	this.cboCategoria.setModel(new DefaultComboBoxModel<>(this.ctrl.getCategorias().toArray()));
 		 	this.cboCategoria.setSelectedIndex(-1);
 		 	} catch (Exception e) {
 		 JOptionPane.showMessageDialog(this, "Error recuperando Categorias");
 		 }
 		 }

 	protected void buscarClick() {
 		try {
 			this.mapearAForm(ctrl.getByDni(this.mapearDeForm()));
 			} catch (Exception e) {
 			JOptionPane.showMessageDialog(this, e.getMessage());
 			}
 			 	}
 	protected void agregarClick() {
 		Persona p = this.mapearDeForm();
 		try{
 			ctrl.add(p);
 			} catch (Exception e) {
 			JOptionPane.showMessageDialog(this, e.getMessage());
 			}
 			this.txtId.setText(String.valueOf(p.getIdpersona()));
 			 		
 			 	}
 	protected void borrarClick(){
 		try{
 			ctrl.delete(this.mapearDeForm());
 			} catch (Exception e) {
 			JOptionPane.showMessageDialog(this, e.getMessage());
 			}
 			 	}
 	protected void modificarClick(){
 		try{
 			ctrl.update(this.mapearDeForm());
 			} catch (Exception e) {
 			JOptionPane.showMessageDialog(this, e.getMessage());
 			}
 			 	}
 	private void mapearAForm(Persona p){
 		this.txtDni.setText(p.getDni());
 		this.txtNombre.setText(p.getNombre());
 		this.txtApellido.setText(p.getApellido());
 		this.chkHabilitado.setSelected(p.getHabilitado());
 		this.txtId.setText(String.valueOf(p.getIdpersona()));
 		if (p.getCategoria() !=null){
 			 	this.cboCategoria.setSelectedItem(p.getCategoria());
 			 };
 	}
 	
 	private Persona mapearDeForm(){
 		Persona p=new Persona();
 		if(!this.txtId.getText().isEmpty()){
 			p.setIdpersona(Integer.parseInt(this.txtId.getText()));
 		}
 		p.setDni(this.txtDni.getText());
 		p.setNombre(this.txtNombre.getText());
 		p.setApellido(this.txtApellido.getText());
 		p.setHabilitado(this.chkHabilitado.isSelected());
 		if (cboCategoria.getSelectedIndex() != -1){
 			 p.setCategoria((Categoria)cboCategoria.getSelectedItem());
 			 }
 		return p;
 	}
 	public void showPersona(Persona p){
 		 this.mapearAForm(p);
 		 	
 		 }
 }
