package org.auditioner.services.family;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/auditioner/family")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FamilyResource {


    @POST
    public void addFamily(Family family)
    {

    }
}
