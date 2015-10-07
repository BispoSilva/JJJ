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

	import dao.ServicoDAO;
	import entity.Servico;

	@Path("/servico")
	@Produces("application/json")
	public class ServicoWebService {
		
		@EJB
		private ServicoDAO servicoDAO;

		@Path("/list")
		@GET 	
		public String getAllServicos() throws Exception{
			List<Servico> servicos = servicoDAO.getServicos();
			Gson gson = new Gson();
			return gson.toJson(servicos);
		}

		@Path("/list/{descricao}")
		@GET
		@Produces("application/json")
		public String getServicos(@PathParam("codigo") Float codigo){
			Servico b =  new Servico();
			Gson gson = new Gson();
			return gson.toJson(b);
		}
		
		@Path("/create")
		@POST
		@Consumes("application/json")
		public void setServico(String json) throws Exception {
			Gson gson = new Gson();
			Servico b =  gson.fromJson(json, Servico.class);
			servicoDAO.addServico(b);
		}
		
		@Path("/createform")
		@GET
		public void createServico(
				@QueryParam("codigo") Float codigo,
				@QueryParam("descricao") String descricao,
				@QueryParam("data") Float data,
		        @QueryParam("quantidade") Float quantidade,
	            @QueryParam("hora") Float hora)
				throws Exception {
			    System.out.println("hora" + hora);
			    Servico b =  new Servico(codigo, descricao, data, quantidade, hora); 
			    servicoDAO.addServico(b);
		}
		
		

}
