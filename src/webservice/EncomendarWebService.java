package webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import dao.EncomendarDAO;
import entity.Cadastro;
import entity.Encomendar;
import entity.Produto;

@Path("/encomendar")
@Produces("application/json")
public class EncomendarWebService {
	
	@EJB
	private EncomendarDAO encomendarDAO;

	@Path("/list")
	@GET 	
	public String getAllEncomendars() throws Exception{
		List<Encomendar> encomendar = (List<Encomendar>) encomendarDAO.getEncomendars();
		Gson gson = new Gson();
		return gson.toJson(encomendar);
	}

	@Path("/list/{id}")
	@GET
	@Produces("application/json")
	public String getProduto(@PathParam("id") long id){
		Encomendar b =  new Encomendar();
		b.setCadastro(new Cadastro());
		b.addProduto(new Produto("deitel", 10,  "JJJ",  "Java how to program", 0, 0));
		b.addProduto(new Produto());
		Gson gson = new Gson();
		return gson.toJson(b);
	}
	
	@Path("/create")
	@POST
	@Consumes("application/json")
	public void setProduto(String json) throws Exception {
		/*
		Gson gson = new Gson();
		Encomendar b =  gson.fromJson(json, Encomendar.class);
		*/
		
		Encomendar b = new Encomendar();
		b.setCadastro(new Cadastro());
		b.addProduto(new Produto("deitel", 10,  "JJJ",  "Java how to program", 0, 0));
		b.addProduto(new Produto());
		encomendarDAO.addEncomendar(b);
		
	}
    /*
	@Path("/createform")
	@GET
	public void createCadastro(@QueryParam("codigo") Float codigo,
			@QueryParam("descricao") String descricao, 
			@QueryParam("quantidade") Double quantidade, 
			@QueryParam("valor") Double valor)
			throws Exception {
		    Encomendar b =  new Encomendar(codigo, descricao, quantidade, valor); 
            encomendarDAO.addEncomendar(b);
	     }
      */
}
