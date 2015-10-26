package webservice;

import java.util.LinkedList;
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

import entity.Produto;

@Path("/produto")
@Produces("application/json")
public class ProdutoWebService {
	
	@EJB
	private ProdutoDAO produtoDAO;

	@Path("/list")
	@GET 	
	public String getAllProdutos() throws Exception{
		List<Produto> produtos = produtoDAO.getProdutos();
		Gson gson = new Gson();
		return gson.toJson(produtos);
	}

	@Path("/list/{id}")
	@GET
	public String getProduto(@PathParam("id") String id) throws Exception{
		Produto b =  produtoDAO.findProduto(Long.parseLong(id));
		Gson gson = new Gson();
		return gson.toJson(b);
	}
	
	
	@Path("/create")
	@POST
	@Consumes("application/json")
	public void setProduto(String json) throws Exception {
		Gson gson = new Gson();
		Produto b =  gson.fromJson(json, Produto.class);
		produtoDAO.addProduto(b);
	}
	
	@Path("/createform")
	@GET
	public void createProduto(@QueryParam("id") String id,
			@QueryParam("descricao") String descricao,
			@QueryParam("codigo") float codigo,
			@QueryParam("marca") String marca,
			@QueryParam("categoria") String categoria,
	        @QueryParam("quantidade") float quantidade,
            @QueryParam("valor") float valor)
			throws Exception {
		    Produto b =  new Produto(descricao, codigo, marca, categoria, quantidade, valor); 
            produtoDAO.addProduto(b);
	}
	
	

}
