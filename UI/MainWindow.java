package UI;
 
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class MainWindow {

private JFrame frmSistemaDeReservas;
private JDesktopPane desktopPane;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
	try {
		MainWindow window = new MainWindow();
		window.frmSistemaDeReservas.setVisible(true);
	} catch (Exception e) {
	e.printStackTrace();
	}
}
});
}

public MainWindow() {
initialize();
}

private void initialize() {
frmSistemaDeReservas = new JFrame();
frmSistemaDeReservas.setTitle("Sistema de Reservas");
frmSistemaDeReservas.setBounds(100, 100, 678, 450);
frmSistemaDeReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JMenuBar menuBar = new JMenuBar();
frmSistemaDeReservas.setJMenuBar(menuBar);
JMenu mnuPersona = new JMenu("Personas");
menuBar.add(mnuPersona);
JMenuItem mnuABMCPersona = new JMenuItem("ABMCPersonas");
mnuABMCPersona.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuABMCPersonaClick();
}
});
mnuPersona.add(mnuABMCPersona);

JMenuItem mntmListado = new JMenuItem("Listado");
mntmListado.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuListadoPersonaClick();
}
});
mnuPersona.add(mntmListado);
JMenu mnuTipos = new JMenu("Tipos de Elementos");
JMenuItem mnuABMCTipos = new JMenuItem("ABMC Tipos");
mnuTipos.add(mnuABMCTipos);
mnuABMCTipos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuABMCTiposClick();
}
});
menuBar.add(mnuTipos);

JMenuItem mnuListadoTipos = new JMenuItem("Listado");
mnuListadoTipos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuListadoTiposClick();
}
});
mnuTipos.add(mnuListadoTipos);

JMenu mnuElementos = new JMenu("Elementos");
menuBar.add(mnuElementos);
JMenuItem mnuABMCElementos = new JMenuItem("ABMC Elementos");
mnuElementos.add(mnuABMCElementos);
JMenuItem mnuListadoElementos = new JMenuItem("Listado ");
mnuElementos.add(mnuListadoElementos);
mnuABMCElementos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuABMCElementosClick();
}});
JMenu mnuReservas = new JMenu("Reservas");
menuBar.add(mnuReservas);
frmSistemaDeReservas.getContentPane().setLayout(new BorderLayout(0, 0));
desktopPane = new JDesktopPane();
frmSistemaDeReservas.getContentPane().add(desktopPane, BorderLayout.CENTER);
}
protected void mnuABMCPersonaClick() {
ABMCPersonaDesktop pd= new ABMCPersonaDesktop();
desktopPane.add(pd);
pd.setVisible(true);
}

protected void mnuListadoPersonaClick() {
ListadoPersonas lp= new ListadoPersonas();
desktopPane.add(lp);
lp.setVisible(true);
}

protected void mnuABMCTiposClick() {
ABMCTipoElemento td= new ABMCTipoElemento();
desktopPane.add(td);
td.setVisible(true);
}
protected void mnuListadoTiposClick() {
ListadoTipos lt= new ListadoTipos();
desktopPane.add(lt);
lt.setVisible(true);}

protected void mnuABMCElementosClick() {
ABMCElementos ed= new ABMCElementos();
desktopPane.add(ed);
ed.setVisible(true);
}
}