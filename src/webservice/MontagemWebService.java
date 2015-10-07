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

		@Path("/list/{descricao}")
		@GET
		@Produces("application/json")
		public String getMontagem(@PathParam("descricao") String descricao){
			Montagem b =  new Montagem("mesa", 2,  "J",  "Java how to program", 1, 1);
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
		public void createMontagem(
				@QueryParam("codigo") Float codigo,
				@QueryParam("descricao") String descricao,
		        @QueryParam("quantidade") Float quantidade,
	            @QueryParam("data") Float data)
				throws Exception {
			    System.out.println("data" + data);
			    Montagem b =  new Montagem( codigo, descricao, quantidade, data); 
			    montagemDAO.addMontagem(b);
		}
		
		


}
