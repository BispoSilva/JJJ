package webservice;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/cadastrostore")
public class ApplicationConfig extends Application {

	    public Set<Class<?>> getClasses() {
	        return new HashSet<Class<?>>(Arrays.asList(CadastroWebService.class, EncomendarWebService.class, ProdutoWebService.class, ServicoWebService.class, MontagemWebService.class, EstoqueWebService.class));
	    }
	

}

