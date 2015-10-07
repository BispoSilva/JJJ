package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Cadastro database table.
 * 
 */
@Entity
@NamedQuery(name="Cadastro.findAll", query="SELECT a FROM Cadastro a")
public class Cadastro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Encomendar encomendar;
	private String nome;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	private float registro;
	private String endereco;
	private String bairro;
	private String cidade;
	private String uf;
	private float cep;
	private float telefone;
	private String email;
	private String observacoes;

	public Cadastro() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public float getRegistro() {
		return this.registro;
	}

	public void setRegistro(float registro) {
		this.registro = registro;
	}
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public float getCep() {
		return this.cep;
	}

	public void setCep(float cep) {
		this.cep = cep;
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

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	
	public Cadastro(String nome, float registro, String endereco, String bairro, String cidade, String uf, float cep, float telefone, String email, String observacoes) {
		super();
		this.nome = nome;
		this.registro = registro;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		this.observacoes = observacoes;
	}
	
	public Encomendar getEncomendar() {
		return encomendar;
	}

	public void setEncomendar(Encomendar encomendar) {
		this.encomendar = encomendar;
	}

	

	
}