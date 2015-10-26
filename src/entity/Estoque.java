package entity;


	import java.io.Serializable;
	
	import javax.persistence.*;

	/**
	 * The persistent class for the Estoque database table.
	 * 
	 */
	@Entity
	@NamedQuery(name="Estoque.findAll", query="SELECT c FROM Estoque c")
	public class Estoque implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private String descricao;
		

		@Id 
		@GeneratedValue(strategy=GenerationType.AUTO) 
		private long id;

		
		private float codigo;
		
		private String marca;

		private String categoria;
		
		private float quantidade;
		
		private float data;
		
		private float valor;



		public Estoque() {
		}

		public String getDescricao() {
			return this.descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public long getId() {
			return this.id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public float getCodigo() {
			return this.codigo;
		}

		public void setCodigo(float codigo) {
			this.codigo = codigo;
		}
		
		public String getMarca() {
			return this.marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getCategoria() {
			return this.categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		
		public float getQuantidade() {
			return this.quantidade;
		}

		public void setQuantidade(float quantidade) {
			this.quantidade = quantidade;
		}

		public float getData() {
			return this.data;
		}

		public void setData(float data) {
			this.data = data;
		}
		public float getValor() {
			return this.valor;
		}

		public void setValor(float valor) {
			this.valor = valor;
		}
		

		public Estoque(String descricao, float codigo, String marca, String categoria, float quantidade, float data, float valor) {
			super();
			this.descricao = descricao;
			this.codigo = codigo;
			this.marca = marca;
			this.categoria = categoria;
			this.quantidade = quantidade;
			this.data = data;
		}

		

		
}
