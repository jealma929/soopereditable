package sooper.demo.tkrun;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class SupermercadoController {

	private SupermercadoModel model;
	private SupermercadoView view;
	private Jtable
	
		
	public void setVistaModel( SupermercadoView v , SupermercadoModel m) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.view.getFrame().setVisible(true);
	}
	
	//a partir de aqui, implementamos los metodos de las funcionalidades correspondientes
	
	public void AniadirArticulosPedido(int i) {
		//metodo para rellenar la tabla de articulos y pedidos
		int j;
		List<Object[]> lista=model.AniadirArticulosPedido(i);
		//una vez que me devuelva el modelo el resultado de la consulta, analizo la lista devuelta:
		
		for (j=0; j<lista.size();j++) {
			view.rellenaListaArticulos(lista.get(j));
		}
		
	};
	

	public SupermercadoView getView() {
		return view;
	}

	public void setView(SupermercadoView view) {
		this.view = view;
	}

	public SupermercadoModel getModel() {
		return model;
	}

	public void setModel(SupermercadoModel model) {
		this.model = model;
	}

	public void embolsarArticulos() {
		// TODO Auto-generated method stub
		
		// modificamos la base de datos rellenando el campo a 1
		String idArticulo;
		
		idArticulo = this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(),0).toString();
			
		this.model.embolsaArticulo(Integer.parseInt(idArticulo));
		
		// realizamos el intercambio de datos entre tablas y borramos la fila seleccionada
		
		//borramos la fila en la primera tabla		
		this.view.getModeloArticulo ().removeRow(this.view.getTable().getSelectedRow());
		
		//añadimos una nueva fila en la tabla de abajo
		//el array de objetos fila, se inicializa a null y se añade una fila
		Object[] fila = null;
				
		this.view.getModeloListaEmbolsados().addRow(fila);
		
		//para sacar el numeo de fila
		int numeroFila = this.view.getModeloListaEmbolsados().getRowCount();
		//para asignar los valores a la primera fila de la tabla
		this.view.getModeloListaEmbolsados().setValueAt(idArticulo, numeroFila-1, 0);
		this.view.getModeloListaEmbolsados().setValueAt("999", numeroFila-1, 1 );
		
		//calculamos el volumen total aproximado del pedido
		int contenedor;
		int i;
		int j;
		
		
		//usamos una tabla para pasar los datos de la consulta
		/*DefaultTableModel modelovolumen = new DefaultTableModel(new Object[][] {
		},
		new String[] {
				"idPedido", "Volumen";
			}
		);
		
		List<Object[]>lista=null;
		lista=this.model.volumenTotal(Integer.parseInt(idArticulo));
		
		for (i=0; i<lista.size();i++) {
		}
			contenedor=lista.get(i);
			
		lista.
			total=total + Integer.parseInt(lista.get(j).toString());
		}*/
		
		for (j=0; j<lista.size();j++) {
			view.rellenaListaArticulos(lista.get(j));	
		
			this.modeloArticulo.addRow(rowArticulo);//para añadir una fila a la tabla lo primero que tengo que añadir es la 
													//fila al modelo correspondiente a esa tabla
			this.table.setModel(modeloArticulo); 	//una vez la tenga añadida al modelo, muestro el modelo en la tabla

		
				
		/*public void rellenaTablaEmbolsados() {
				}*/
	}

}

