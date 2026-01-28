package cucum_project.BDD_sample.ping.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import cucum_project.BDD_sample.ping.control.PingService;
import cucum_project.BDD_sample.ping.entity.Ping;

@Stateless
@Path("ping")
public class PingResource {

    @Inject
    private PingService pingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Ping ping() {
        return pingService.getPing();
    }

}
