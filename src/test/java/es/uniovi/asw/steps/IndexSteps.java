package es.uniovi.asw.steps;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import es.uniovi.asw.Application;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class IndexSteps {

	@Autowired
	protected WebApplicationContext context;

	protected MockMvc mvc;
	protected MvcResult result;

	@Value("${local.server.port}")
	protected int port;

	@Cuando("^el cliente llama a /$")
	public void el_cliente_llama_a() throws Throwable {
		Assert.notNull(context);
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
		result = mvc.perform(get("/")).andReturn();
	}

	@Entonces("^el cliente recibe el código de estado (\\d+)$")
	public void el_cliente_recibe_el_código_de_estado(int status) throws Throwable {
		assertThat(result.getResponse().getStatus(), is(status));
	}

	@Entonces("^el cliente recibe la cadena \"([^\"]*)\"$")
	public void el_cliente_recibe_la_cadena(String str) throws Throwable {
		assertThat(result.getResponse().getContentAsString(),
				containsString(str));
	}

}
