package stakkTraze.example.resources;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author stakkTraze
 */
@Path("/")
public class BaseResource {

    public Response get() {
        return Response.ok("Hello World").build();
    }

}
