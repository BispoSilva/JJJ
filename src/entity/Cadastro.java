package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Cadastro database table.
 * 
 */
@Entity
@NamedQuery(name="Cadastro.findAll", query="SELECT b FROM Cadastro b")
public class Cadastro implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;

	@Id
	private String id;

	private float telefone;

	private String email;

	private String endereco;

	public Cadastro() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereço(String endereco) {
		this.endereco = endereco;
	}

	public Cadastro(String nome, String id, float telefone, String email, String endereco) {
		super();
		this.nome = nome;
		this.id = id;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	
}