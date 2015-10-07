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

import dao.CadastroDAO;
import entity.Cadastro;

@Path("/cadastro")
@Produces("application/json")
public class CadastroWebService {

	@EJB
	private CadastroDAO cadastroDAO;

	@Path("/list")
	@GET 	
	public String getAllCadastros() throws Exception{
		List<Cadastro> cadastros = cadastroDAO.getCadastros();
		Gson gson = new Gson();
		return gson.toJson(cadastros);
	}

	@Path("/list/{id}")
	@GET
	@Produces("application/json")
	public String getCadastro(@PathParam("id") String id){
		Cadastro b =  new Cadastro("cama", 13,  "JJJ",  "Java how to program", id, id, 0, 0, id, id);
		Gson gson = new Gson();
		return gson.toJson(b);
	}
	
	@Path("/create")
	@POST
	@Consumes("application/json")
	public void setCadastro(String json) throws Exception {
		Gson gson = new Gson();
		Cadastro b =  gson.fromJson(json, Cadastro.class);
       cadastroDAO.addCadastro(b);
	}
	
	@Path("/createform")
	@GET
	public void createCadastro(
			@QueryParam("nome") String nome,
			@QueryParam("registro") Float registro,
			@QueryParam("endereco") String endereco,
			@QueryParam("bairro") String bairro,
			@QueryParam("cidade") String cidade,
			@QueryParam("uf") String uf,
			@QueryParam("cep") Float cep,
			@QueryParam("telefone") Float telefone,
			@QueryParam("email") String email,
			@QueryParam("observacoes") String observacoes)
			throws Exception {
		    System.out.println("observacoes" + observacoes);
		    Cadastro b =  new Cadastro(nome, registro, endereco, bairro, cidade, uf, cep, telefone, email, observacoes); 
            cadastroDAO.addCadastro(b);
	}
	
	
	}
	
	

