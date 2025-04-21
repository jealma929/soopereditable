package sooper.demo.tkrun;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class SupermercadoController {

	private SupermercadoModel model;
	private SupermercadoView view;
	
	
		
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
	
		// modificamos la base de datos rellenando el campo a 1
		String idArticulo;
		int intArticulo;
		
		
		idArticulo = this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(),0).toString();
			
		this.model.embolsaArticulo(Integer.parseInt(idArticulo));
		
		// realizamos el intercambio de datos entre tablas y borramos la fila seleccionada
		
		//borramos la fila en la primera tabla		
		this.view.getModeloArticulo ().removeRow(this.view.getTable().getSelectedRow());
		
		//añadimos una nueva fila en la tabla de abajo
		//el array de objetos fila, se inicializa a null y se añade una fila
		Object[] fila = null;
				
		this.view.getModeloListaEmbolsados().addRow(fila);
		
		//eliminamos la linea seleccionada de la tabla superior 
		int numeroFila = this.view.getModeloListaEmbolsados().getRowCount();
		
		
		
		//para asignar los valores a la primera fila de la tabla
		this.view.getModeloListaEmbolsados().setValueAt(idArticulo, numeroFila-1, 0);
		this.view.getModeloListaEmbolsados().setValueAt("999", numeroFila-1, 1 );

		intArticulo= Integer.parseInt(idArticulo);
		contenedor(intArticulo);
	}
	
	public void contenedor(int articulo) {
		String suma ="";
		List<Object[]> lista = new ArrayList<>();
		lista=this.model.totalArticulos(articulo);
		int m = lista.size();
		String mm = Integer.toString(lista.size()); 
		/*String[][] ArrayPedido = new String[m][3];
		for (int i=1;i<m;i++) {
			String fila = lista.get(i).toString();
			suma = suma+fila;
			//ArrayPedido[i] = lista.get(i).toString();
			
		}*/
		this.view.escribirPrueba("3");
	}

}