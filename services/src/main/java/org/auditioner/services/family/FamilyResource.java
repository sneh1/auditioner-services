package org.auditioner.services.family;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/auditioner/family")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FamilyResource {


    private FamilyDAO familyDAO;

    public FamilyResource(FamilyDAO familyDAO) {
        this.familyDAO = familyDAO;
    }

    @POST
    public Response addFamily(Family family)
    {
        long familyId = familyDAO.addFamily(family);

        return Response.created(URI.create("/auditioner/family/" + familyId)).build();
    }
}
