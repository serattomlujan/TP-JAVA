package UI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import controlers.CtrlABMElemento;
import entity.Elemento;


public class ListadoElementos extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Elemento> ele;
	CtrlABMElemento ctrl= new CtrlABMElemento();
		
	private JTable table;

	public ListadoElementos() {
		setTitle("Listado de Elementos");
		setClosable(true);
		setBounds(100, 100, 507, 300);
		JScrollPane scrollPane = new JScrollPane();
	 	JButton btnEditar = new JButton("Editar");
	 	btnEditar.addMouseListener(new MouseAdapter() {
	 	@Override
	 	public void mouseClicked(MouseEvent arg0) {
	 			btnEditarClick();
	 			}
	 		});
	 	GroupLayout groupLayout = new GroupLayout(getContentPane());
	 	groupLayout.setHorizontalGroup(
	 	groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
	 	.addGroup(groupLayout.createSequentialGroup().addContainerGap(368, Short.MAX_VALUE)
	 	.addComponent(btnEditar).addContainerGap())
	 	);
	 	groupLayout.setVerticalGroup(
	 	groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
	 .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
	 .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEditar)
	 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	 	);
	 		
	 table = new JTable();
	 scrollPane.setViewportView(table);
	 table.setBackground(Color.LIGHT_GRAY);
	 getContentPane().setLayout(groupLayout);
	 try{
	 this.ele=ctrl.getAll();
	 		} catch (Exception e){
	 JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	 
	 }
	 initDataBindings();
	 }
	
	 protected void btnEditarClick() {
	 int indexElemento=table.convertRowIndexToModel(table.getSelectedRow());
	 
	 ABMCElementos le= new ABMCElementos();
	 le.showElemento(this.ele.get(indexElemento));
	 
	 this.getDesktopPane().add(le);
	 le.setVisible(true);
	 		
	 }
	 protected void initDataBindings() {
	 JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, ele, table);
	 BeanProperty<Elemento, String> elementoBeanProperty = BeanProperty.create("nombre");
	jTableBinding.addColumnBinding(elementoBeanProperty).setColumnName("Nombre").setEditable(false);
	BeanProperty<Elemento, String> elementoBeanProperty_1 = BeanProperty.create("tipo_elemento.nombre_tipo");
	jTableBinding.addColumnBinding(elementoBeanProperty_1).setColumnName("Tipo Elemento").setEditable(false);

	jTableBinding.setEditable(false);
	jTableBinding.bind();
	}
	}
	


