package nb.ninja.resources;

import redis.clients.jedis.Jedis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class NinjaResource {

    @GET
    public String tasks(@Context Jedis jedis){
        return jedis.get("task");
    }
}
