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

	import dao.EstoqueDAO;
	import entity.Estoque;

	@Path("/estoque")
	@Produces("application/json")
	public class EstoqueWebService {
		
		@EJB
		private EstoqueDAO estoqueDAO;

		@Path("/list")
		@GET 	
		public String getAllEstoques() throws Exception{
			List<Estoque> estoques = estoqueDAO.getEstoques();
			Gson gson = new Gson();
			return gson.toJson(estoques);
		}

		@Path("/list/{codigo}")
		@GET
		@Produces("application/json")
		public String getEstoque(@PathParam("codigo") Float codigo){
			Estoque b =  new Estoque("estante", 4,  "tt",  "Java how to program", 2, 2);
			Gson gson = new Gson();
			return gson.toJson(b);
		}
		
		@Path("/create")
		@POST
		@Consumes("application/json")
		public void setEstoque(String json) throws Exception {
			Gson gson = new Gson();
			Estoque b =  gson.fromJson(json, Estoque.class);
			estoqueDAO.addEstoque(b);
		}
		
		@Path("/createform")
		@GET
		public void createEstoque(
				@QueryParam("codigo") Float codigo,
				@QueryParam("descricao") String descricao,
		        @QueryParam("quantidade") Float quantidade,
	            @QueryParam("data") Float data)
				throws Exception {
			    System.out.println("data" + data);
			    Estoque b =  new Estoque( codigo, descricao, quantidade, data); 
			    estoqueDAO.addEstoque(b);
		}
		
		


}
