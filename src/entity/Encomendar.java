package entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="Encomendar.findAll", query="SELECT p FROM Encomendar p")

public class Encomendar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cadastro_fk")
    Cadastro cadastro;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Produto> produtos = new LinkedList<Produto>();
    
    
    public void addProduto(Produto b) {
    	this.produtos.add(b);
    }
    
	public List<Produto> getProdutos() {
		return produtos;
	}



	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Encomendar(){
		
	}
	
	
	
	public Cadastro getCadastro() {
		return cadastro;
	}
	
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	
}
