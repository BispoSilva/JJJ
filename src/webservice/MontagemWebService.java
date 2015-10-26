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

	import dao.MontagemDAO;
	
	import entity.Montagem;



	@Path("/montagem")
	@Produces("application/json")
	public class MontagemWebService {
		
		@EJB
		private MontagemDAO montagemDAO;

		@Path("/list")
		@GET 	
		public String getAllMontagems() throws Exception{
			List<Montagem> montagems = montagemDAO.getMontagems();
			Gson gson = new Gson();
			return gson.toJson(montagems);
		}
		@Path("/list/{id}")
		@GET
		public String getMontagem(@PathParam("id") String id) throws Exception{
			Montagem b =  montagemDAO.findMontagem(Long.parseLong(id));
			Gson gson = new Gson();
			return gson.toJson(b);
		}

		
		
		@Path("/create")
		@POST
		@Consumes("application/json")
		public void setMontagem(String json) throws Exception {
			Gson gson = new Gson();
			Montagem b =  gson.fromJson(json, Montagem.class);
			montagemDAO.addMontagem(b);
		}
		
		@Path("/createform")
		@GET
		public void createMontagem(@QueryParam("id") String id,
				@QueryParam("descricao") String descricao,
				@QueryParam("codigo") float codigo,
		        @QueryParam("quantidade") float quantidade,
	            @QueryParam("valor") float valor)
				throws Exception {
			    Montagem b =  new Montagem(descricao, codigo, quantidade, valor); 
	            montagemDAO.addMontagem(b);
		}
		


}
