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
		public String getAllProdutos() throws Exception{
			List<Cadastro> produtos = cadastroDAO.getCadastros();
			Gson gson = new Gson();
			return gson.toJson(produtos);
		}

		@Path("/list/{email}")
		@GET
		@Produces("application/json")
		public String getUser(@PathParam("email") String email){
			Cadastro b =  new Cadastro("plucas@lala.com", "josival", "Rua 1234", "jardim brasil", "Guarulhos", "SP", "34", "12", "tudo"); 
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
		public void createBook(@QueryParam("email") String email,
				@QueryParam("nome") String nome, 
				@QueryParam("endereco") String endereco, 
				@QueryParam("bairro") String bairro, 
				@QueryParam("cidade") String cidade, 
				@QueryParam("uf") String uf, 
				@QueryParam("cep") String cep, 
				@QueryParam("telefone") String telefone,
		        @QueryParam("observacoes") String observacoes)
				throws Exception {
			System.out.println("INICIO");
			Cadastro b =  new Cadastro(email, nome, endereco, bairro, cidade, uf, cep, telefone, observacoes); 
			System.out.println("FIM");			
			cadastroDAO.addCadastro(b);
		     }
	}
	
	

