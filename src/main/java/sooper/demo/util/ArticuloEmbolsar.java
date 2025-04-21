package sooper.demo.util;

public class ArticuloEmbolsar {

		private int idArticulo;
		private int idPedido;
		private int volumen;
		private int embolsado;
		private int idContenedor;
		
		public ArticuloEmbolsar () {
			
		};
		
		
		public ArticuloEmbolsar (int idArticulo, int idPedido, int volumen, int embolsado, int idContenedor) {
		
			this.idArticulo=idArticulo;
			this.idPedido=idPedido;
			this.volumen=volumen;
			this.embolsado=embolsado;
			this.idContenedor=idContenedor;
		}
		public int getIdArticulo(){
			return idArticulo;
		}
		public int getIdPedido() {
			return idPedido;
		}
		public int getVolumen() {
			return volumen;
		}
		public int getEmbolsado() {
			return embolsado;
		}
		public int getIdContenedor() {
			return idContenedor;
		}
		
		public void setIdArticulo(int a) {
			idArticulo = a;
		}
		public void setIdPedido(int p) {
			idPedido=p;
		}
		public void setVolumen(int v) {
			volumen=v;
		}
		public void setEmbolsado(int e) {
			embolsado=e;
		}
		public void setIdContenedor(int c) {
			idContenedor=c;
		}
		
}
		
