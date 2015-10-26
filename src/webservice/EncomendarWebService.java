package webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import dao.ProdutoDAO;
import dao.EncomendarDAO;
import entity.Produto;
import entity.Encomendar;
import entity.Cadastro;

@Path("/encomendar")
@Produces("application/json")
public class EncomendarWebService {

	@EJB
	private EncomendarDAO encomendarDAO;
	
	@EJB
	private ProdutoDAO produtoDAO;

	@Path("/list")
	@GET 	
	public String getAllEncomendars() throws Exception{
		List<Encomendar> encomendars = encomendarDAO.getEncomendars();
		System.out.println(encomendars.get(0).getProdutos());
		Gson gson = new Gson();
		return gson.toJson(encomendars);
	}

	@Path("/list/{id}")
	@GET
	@Produces("application/json")
	public String getEncomendar(@PathParam("id") Long id){
		Encomendar p = encomendarDAO.find(id);
		Gson gson = new Gson();
		return gson.toJson(p);
	}
	
	@Path("/populate")
	@GET
	@Consumes("application/json")
	public void setProduto() throws Exception {
		/*
		Gson gson = new Gson();
		Purchase p =  gson.fromJson(json, Purchase.class);
		*/
		Encomendar p = new Encomendar();
		p.setCadastro(new Cadastro("plucas@lala.com", "josival", "Rua 1234", "jardim brasil", "Guarulhos", "SP", "34", "12", "tudo"));
		p.addProduto(new Produto("Formica", 60, "Arauco", "ouro",25, 30));
		p.addProduto(new Produto("MDF",   15,  "Duratex", "prime", 20, 10));
		encomendarDAO.addEncomendar(p);
	}
	
	@Path("/add")
	@POST
	@Consumes("application/json")
	public void setProduto(String json) throws Exception {
		
		Gson gson = new Gson();
		Encomendar p =  gson.fromJson(json, Encomendar.class);
		//p.setProdutos(produtoDAO.cloneProdutos(p.getProdutos()));		
		//debug
		System.out.println(p.getId());
		p.getProdutos().forEach(produto -> System.out.println(produto.getDescricao() + ":" + produto.getCodigo()  ));

		encomendarDAO.addEncomendar(p);
	}
	
	/*
	@Path("/createform")
	@GET
	public void createProduto(@QueryParam("id") String id,
			@QueryParam("descricao") String descricao, 
			@QueryParam("codigo") Float codigo,
			@QueryParam("marca") String marca,
			@QueryParam("categoria") String categoria,
			@QueryParam("quantidade") String quantidade,
			@QueryParam("valor") String valor)
			throws Exception {
		    Encomendar p =  new Produto(descricao, id, codigo, marca, categoria, quantidade, valor); 
            produtoDAO.addProduto(b);
	}
	*/
	
	}
