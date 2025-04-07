package sooper.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;


public class GestionAlmacenView {
	
 protected JFrame frame ;
 private JTable table;
 private DefaultTableModel modeloTabla;

 
 
 public GestionAlmacenView() {	 
	 
	 this.initView();
 }

/**
 * @wbp.parser.entryPoint
 */
private void initView() {
	
	
	this.modeloTabla = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idArticulo", "idContenedor"
			}
		);
	this.frame = new JFrame();
	frame.setBounds(0, 0, 400, 500);
	frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow][]"));
	
	JLabel lblNewLabel = new JLabel("Articulos a Embolsar");
	frame.getContentPane().add(lblNewLabel, "cell 0 0");
	
	JScrollPane scrollPane = new JScrollPane();
	frame.getContentPane().add(scrollPane, "cell 0 1,grow");
	
	table = new JTable();
	table.setModel(modeloTabla);
	scrollPane.setViewportView(table);
	
	JButton btnNewButton = new JButton("Añadir Articulo");
	
	frame.getContentPane().add(btnNewButton, "cell 0 2");
	
	 
	
	this.frame.setVisible(true);
	
}

public JFrame getFrame() {
	return this.frame;
}


	

}
