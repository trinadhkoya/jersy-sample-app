package io.trinadhkoya.github.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path(value = "demo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class DemoResource {
	
	@Path("context")
	@GET
	public String contextParmDemo(@Context UriInfo info, @Context HttpHeaders headers){
		
		return info.getAbsolutePath().toString()+" "+" headers are "+headers.toString()+" "+" Cookies are "+headers.getCookies().toString();
	}
	

}
