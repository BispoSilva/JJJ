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

	@Path("/list/{descricao}")
	@GET
	@Produces("application/json")
	public String getProduto(@PathParam("descricao") String descricao){
		Produto b =  new Produto("deitel", 10,  "JJJ",  "Java how to program", 0, 0);
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
	public void createProduto(
			@QueryParam("descricao") String descricao,
			@QueryParam("codigo") int codigo,
			@QueryParam("marca") String marca,
			@QueryParam("categoria") String categoria,
	        @QueryParam("quantidade") int quantidade,
            @QueryParam("valor") Float valor)
			throws Exception {
		    System.out.println("valor" + valor);
		    Produto b =  new Produto(descricao, codigo, marca, categoria, quantidade, valor); 
            produtoDAO.addProduto(b);
	}
	
	

}
