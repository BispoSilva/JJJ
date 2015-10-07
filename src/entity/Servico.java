package entity;


	import java.io.Serializable;
	import javax.persistence.*;

	/**
	 * The persistent class for the Servico database table.
	 * 
	 */
	@Entity
	@NamedQuery(name="Servico.findAll", query="SELECT k FROM Servico k")
	public class Servico implements Serializable {
		private static final long serialVersionUID = 1L;

		private Float codigo;

		@Id 
		@GeneratedValue(strategy=GenerationType.AUTO) 
		private long id;

		private String descricao;

		private Float data;
		
		private Float quantidade;
		
		private Float hora;



		public Servico() {
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

		public void setCodigo(Float codigo) {
			this.codigo = codigo;
		}

		public Float getData() {
			return this.data;
		}

		public void setData(Float data) {
			this.data = data;
		}

		public Float getQuantidade() {
			return this.quantidade;
		}

		public void setQuantidade(Float quantidade) {
			this.quantidade = quantidade;
		}

		public Float getHora() {
			return this.hora;
		}

		public void setHora(Float hora) {
			this.hora = hora;
		}

		public Servico(Float codigo,String descricao, Float data, Float quantidade, Float hora) {
			super();
			this.codigo = codigo;
			this.descricao = descricao;
			this.data = data;
			this.quantidade = quantidade;
			this.hora = hora;
		}


}
