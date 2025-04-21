package sooper.demo.tkrun;

import java.util.ArrayList;
import java.util.List;

import sooper.demo.util.Database;

public class SupermercadoModel {
	
	Database db = new Database();

	public List<Object[]> AniadirArticulosPedido(int i) {
		// TODO Auto-generated method stub
		List<Object[]> lista = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sql = "SELECT * FROM ARTICULOPEDIDO WHERE IDPEDIDO = ?"; //crear el string que voy a ejecutar en la base de datos
		
		lista = db.executeQueryArray(sql, i);
		
		return lista;
		
	}

	public void embolsaArticulo(int idArticulo) {
			
		String sql = "UPDATE ARTICULOPEDIDO SET EMBOLSADO = ? WHERE IDARTICULO= ?";
		
		db.executeUpdate(sql, 1, idArticulo);
	}

	public List<Object[]> totalArticulos(int i) {
		// TODO Auto-generated method stub
		List<Object[]> lista =null;
		String sql ="SELECT FROM ARTICULOPEDIDO WHERE IDPEDIDO = (SELECT IDPEDIDO FROM ARTICULOPEDIDO WHERE IDARTICULO= ?)";
		lista = db.executeQueryArray(sql, i);
		return lista;
	}
	
}
