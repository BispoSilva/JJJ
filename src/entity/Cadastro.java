package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Book database table.
 * 
 */
@Entity
@NamedQuery(name="Cadastro.findAll", query="SELECT b FROM Cadastro b")
public class Cadastro implements Serializable {
	private static final long serialVersionUID = 1L;

	private String Cliente;

	@Id
	private String id;

	private float Telefone;

	private String Nome;

	private String Endereco;

	public Cadastro() {
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setAuthor(String cliente) {
		this.cliente = cliente;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getTelefone() {
		return this.telefone;
	}

	public void setTelefone(float telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return this.nome;
	}

	public void setPublisher(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cadastro(String cliente, String id, float telefone, String nome, String endereco) {
		super();
		this.cliente = cliente;
		this.id = id;
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
	}

	
}