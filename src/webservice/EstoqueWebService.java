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

		@Path("/list/{id}")
		@GET
		public String getEstoque(@PathParam("id") String id) throws Exception{
			Estoque b =  estoqueDAO.findEstoque(Long.parseLong(id));
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
		public void createProduto(@QueryParam("id") String id,
				@QueryParam("descricao") String descricao,
				@QueryParam("codigo") float codigo,
				@QueryParam("marca") String marca,
				@QueryParam("categoria") String categoria,
		        @QueryParam("quantidade") float quantidade,
		        @QueryParam("data") float data,
	            @QueryParam("valor") float valor)
				throws Exception {
			    Estoque b =  new Estoque(descricao, codigo, marca, categoria, quantidade, data, valor); 
	            estoqueDAO.addEstoque(b);
		}
		


}
