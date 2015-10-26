package entity;


	import java.io.Serializable;
	import javax.persistence.*;

	/**
	 * The persistent class for the Montagem database table.
	 * 
	 */
	@Entity
	@NamedQuery(name="Montagem.findAll", query="SELECT h FROM Montagem h")
	public class Montagem implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private float codigo;
		

		@Id 
		@GeneratedValue(strategy=GenerationType.AUTO) 
		private long id;

		
		private String descricao;

		
		private float quantidade;
		
		private float data;



		public Montagem() {
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

		public Montagem(String descricao, float codigo, float quantidade, float data) {
			super();
			this.descricao = descricao;
			this.codigo = codigo;
			this.quantidade = quantidade;
			this.data = data;
		}

		

		

}
