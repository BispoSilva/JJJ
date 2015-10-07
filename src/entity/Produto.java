package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Produto database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT j FROM Produto j")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descricao;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;

	private int codigo;

	private String marca;

	private String categoria;
	
	private int quantidade;
	
	private float valor;



	public Produto() {
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

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
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

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Produto(String descricao, int codigo, String marca, String categoria, int quantidade, float valor) {
		super();
		this.descricao = descricao;
		this.codigo = codigo;
		this.marca = marca;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.valor = valor;
	}

}
