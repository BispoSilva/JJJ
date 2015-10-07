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
		
		private float codigo;
		

		@Id 
		@GeneratedValue(strategy=GenerationType.AUTO) 
		private long id;

		
		private String descricao;

		
		private float quantidade;
		
		private float data;



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

		public Estoque(String descricao, float codigo, String string, String string2, float quantidade, float data) {
			super();
			this.descricao = descricao;
			this.codigo = codigo;
			this.quantidade = quantidade;
			this.data = data;
		}

		public Estoque(Float codigo2, String descricao2, Float quantidade2, Float data2) {
			// TODO Auto-generated constructor stub
		}

		
}
